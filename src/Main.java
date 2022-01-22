import DriverManagement.BusLineList;
import DriverManagement.DriverAssignment;
import FileIO.DataUtil;
import FileIO.FileUtil;
import FileIO.ObjectUtil;
import entity.BusLine;
import entity.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Driver> drivers = new ArrayList<>();
    private static List<BusLine> busLines = new ArrayList<>();
    private static List<DriverAssignment> driverAssignments = new ArrayList<>();
    private static List<Integer> checkDriverID = new ArrayList<>();
    private static List<Integer> checkBusLineID = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewDriver();
                    break;
                case 2:
                    createNewBusLine();
                    break;
                case 3:
                    assignmentList();
                    break;
                case 4:
                    sortAssignmentList();
                    break;
                case 5:
                    statisticalDistance();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    private static void statisticalDistance() {
        for (DriverAssignment driverAssignment : driverAssignments) {
            System.out.println("Thống kê khoảng cách cho lái xe " + driverAssignment.getDriver().getName());
            System.out.println(driverAssignment.getDistanceSum());
        }
    }

    private static void sortAssignmentList() {
        boolean check = true;
        if (driverAssignments == null || driverAssignments.size() == 0) {
            System.out.println("Bạn cần nhập danh sách lái xe vào! ");
            return;
        }

        do {
            int sortChoice = 0;
            System.out.println("---------- SẮP XẾP DANH SÁCH PHÂN CÔNG LÁI XE    ---------");
            System.out.println("1. Theo tên họ tên lái xe.");
            System.out.println("2. Theo số lượng tuyến đảm nhận trong ngày.");
            System.out.println("3. Thoát chức năng.");
            System.out.print("Xin chọn chức năng: ");

            do {
                try {
                    sortChoice = new Scanner(System.in).nextInt();
                    check = true;
                } catch (Exception e) {
                    System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                    check = false;
                    continue;
                }
                if (sortChoice < 1 || sortChoice > 3) {
                    System.out.print("Nhập trong khoảng từ 1 đến 3! Nhập lại: ");
                    check = false;
                }
            } while (!check);

            switch (sortChoice) {
                case 1:
                    sortByDiverName();
                    break;
                case 2:
                    sortByBusLineNumber();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private static void sortByBusLineNumber() {
        for (int i = 0; i < driverAssignments.size(); i++) {
            for (int j = i + 1; j < driverAssignments.size(); j++) {
                if (driverAssignments.get(i).getBusLineSum() < driverAssignments.get(j).getBusLineSum()) {
                    DriverAssignment tmp = driverAssignments.get(i);
                    driverAssignments.set(i, driverAssignments.get(j));
                    driverAssignments.set(j, tmp);
                }
            }
        }

        for (DriverAssignment driverAssignment : driverAssignments) {
            System.out.println(driverAssignment);
        }
    }

    private static void sortByDiverName() {
        for (int i = 0; i < driverAssignments.size(); i++) {
            for (int j = i + 1; j < driverAssignments.size(); j++) {
                if (driverAssignments.get(i).getDriver().getName().compareTo(driverAssignments.get(j).getDriver().getName()) > 0) {
                    DriverAssignment tmp = driverAssignments.get(i);
                    driverAssignments.set(i, driverAssignments.get(j));
                    driverAssignments.set(j, tmp);
                }
            }
        }

        for (DriverAssignment driverAssignment : driverAssignments) {
            System.out.println(driverAssignment);
        }
    }

    private static boolean isValidDiverAndBusLine() {
        return !DataUtil.isEmptyCollection(drivers) && !DataUtil.isEmptyCollection(busLines);
    }

    private static void assignmentList() {
        if (!isValidDiverAndBusLine()) {
            System.out.println("Cần nhập danh sách lái xe và tuyến đường trước khi phân công!");
            return;
        }

        boolean check = true;
        System.out.println("Nhập số lượng lái xe muốn phân công: ");
        int driverNumber = 0;
        do {
            try {
                driverNumber = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài chữ: ");
                check = false;
                continue;
            }

            if (driverNumber <= 0 || driverNumber > drivers.size()) {
                System.out.println("Số lượng lái xe muốn phân công phải lớn hơn 0 và nhỏ hơn tổng lái xe: ");
                check = false;
            }
        } while (!check);

        for (int i = 0; i < driverNumber; i++) {
            int countBusLine = 0;
            float distance = 0;
            checkBusLineID = new ArrayList<>();
            System.out.println("Nhập id lái xe thứ " + (i + 1) + " muốn phân công: ");
            Driver driver = inputDriverID();
            int tmp = 0;
            assert driver != null;
            System.out.println("Phân công cho lái xe " + driver.getName());
            System.out.println("Nhập số tuyến đường lái xe " + driver.getName() + " được phân công. ");
            int busLineNumber = inputBusLineNumber();

            List<BusLineList> busLineLists = new ArrayList<>();
            for (int j = 0; j < busLineNumber; j++) {
                countBusLine++;
                System.out.println("Nhập mã tuyến đường thứ " + (j + 1) + " mà lái xe " + driver.getName() + " được phân công: ");
                BusLine busLine = inputBusLineID();
                System.out.println(busLine);
                System.out.println("Nhập số lượt lái xe " + driver.getName() + " đi tuyến đường này: ");
                int turnNumber = 0;
                do {
                    try {
                        turnNumber = new Scanner(System.in).nextInt();
                        check = true;
                    } catch (Exception e) {
                        System.out.println("Không được có ký tự khác ngoài số! Nhập lại: ");
                        check = false;
                        continue;
                    }
                    if (turnNumber < 0) {
                        System.out.print("Số lượt lái phải lớn hơn 0! Nhập lại: ");
                        check = false;
                        continue;
                    }
                    tmp += turnNumber;
                    distance += busLine.getDistance() * turnNumber;
                    if (tmp > 15) {
                        tmp = 0;
                        System.out.println("Tổng lượt lái của lái xe lớn hơn 15! Nhập lại: ");
                        check = false;
                    }
                } while (!check);
                busLineLists.add(new BusLineList(busLine, tmp));
            }
            DriverAssignment driverAssignment = new DriverAssignment(driver, busLineLists);
            driverAssignment.setBusLineSum(countBusLine);
            driverAssignment.setDistanceSum(distance);
            driverAssignments.add(driverAssignment);
        }
        for (DriverAssignment driverAssignment : driverAssignments) {
            System.out.println(driverAssignment);
        }
        FileUtil.writeDataToFile(driverAssignments, "diverAssignmentList.txt");
    }

    private static Driver inputDriverID() {
        int tmpID = 0;
        boolean check = true;
        Driver driver = null;
        do {
            try {
                tmpID = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("không được có ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }

            driver = searchDriverId(tmpID);
            if (ObjectUtil.isEmpty(driver)) {
                System.out.print("Không có mã nhân viên lái xe vừa nhập! Nhập lại: ");
                check = false;
            }

            for (Integer integer : checkDriverID) {
                if (integer == tmpID) {
                    System.out.println("Lái xe đã tồn tại! Nhập lại: ");
                    check = false;
                    break;
                }
            }
        } while (!check);
        checkDriverID.add(tmpID);
        System.out.println(checkDriverID);
        return driver;
    }

    private static Driver searchDriverId(int tmpID) {
        for (Driver driver : drivers) {
            if (driver.getId() == tmpID) {
                return driver;
            }
        }
        return null;
    }

    private static BusLine inputBusLineID() {
        int tmpID = 0;
        boolean check = true;
        BusLine busLine = null;
        do {
            try {
                tmpID = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("không được có ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }

            busLine = searchRouteId(tmpID);
            if (ObjectUtil.isEmpty(busLine)) {
                System.out.print("Không có id tuyến đường vừa nhập! Nhập lại: ");
                check = false;
            }

            for (Integer integer : checkBusLineID) {
                if (integer == tmpID) {
                    System.out.println("Tuyến đường đã tồn tại! Nhập lại: ");
                    check = false;
                    break;
                }
            }
        } while (!check);
        checkBusLineID.add(tmpID);
        System.out.println(checkBusLineID);
        return busLine;
    }

    private static BusLine searchRouteId(int tmpID) {
        for (BusLine busLine : busLines) {
            if (busLine.getId() == tmpID) {
                return busLine;
            }
        }
        return null;
    }

    private static int inputBusLineNumber() {
        int BusLineNumber = 0;
        boolean check = true;
        do {
            try {
                BusLineNumber = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }

            if (BusLineNumber < 0 || BusLineNumber > Main.busLines.size()) {
                System.out.print("Tuyến đường không được nhỏ hơn 0 và lớn hơn tổng số tuyến! Nhập lại: ");
                check = false;
            }
        } while (!check);
        return BusLineNumber;
    }

    private static void createNewBusLine() {
        System.out.println("Nhập số lượng tuyến đường: ");
        int countBusLine = 0;
        boolean check = true;
        do {
            try {
                countBusLine = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại.");
                check = false;
                continue;
            }

            if (countBusLine <= 0) {
                System.out.println("số lượng tuyến đường phải lớn hơn 0! Nhập lại: ");
                check = false;
            }
        } while (!check);

        for (int i = 0; i < countBusLine; i++) {
            BusLine busLine = new BusLine();
            busLine.inputBusLineInfo();
            busLines.add(busLine);
        }

        for (BusLine busLine : busLines) {
            System.out.println(busLine);
        }
        FileUtil.writeDataToFile(busLines, "busLineList.txt");
    }

    private static void createNewDriver() {
        System.out.println("Nhập số lượng lái xe: ");
        int countDriver = 0;
        boolean check = true;
        do {
            try {
                countDriver = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }

            if (countDriver <= 0) {
                System.out.println("Số lượng lái xe phải lớn hơn 0! Nhập lại.");
                check = false;
            }
        } while (!check);

        for (int i = 0; i < countDriver; i++) {
            Driver driver = new Driver();
            driver.inputInfo();
            drivers.add(driver);
        }

        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        FileUtil.writeDataToFile(drivers, "driverList.txt");
    }

    private static int functionChoice() {
        System.out.println("-----QUẢN LÝ PHÂN CÔNG LÁI XE BUS-------");
        System.out.println("1. Nhập danh sách lái xe");
        System.out.println("2. Nhập danh sách tuyến đường");
        System.out.println("3. Danh sách phân công lái xe");
        System.out.println("4. Sắp xếp danh sách phân công");
        System.out.println("5. Kê khai tổng khoảng cách chay xe cho mỗi lái xe");
        System.out.println("6. Thoát");
        System.out.print("Nhập sự lựa chọn của bạn: ");
        int functionChoice = 0;
        boolean checkFunction = true;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                checkFunction = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                continue;
            }

            if (functionChoice <= 0 || functionChoice > 6) {
                System.out.print("Nhập số trong khoảng từ 1 đến 6! Nhập lại: ");
                checkFunction = false;
            } else break;
        } while (!checkFunction);
        return functionChoice;
    }
}