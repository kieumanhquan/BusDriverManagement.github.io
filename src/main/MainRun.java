package main;

import entity.Line;
import entity.Drivers;
import entity.table.AssignmentTable;
import service.AssigmentService;
import service.LineService;
import service.DriversService;
import util.file.FileUtil;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class MainRun {
    public static List<Drivers> driversList;
    public static List<Line> busLineList;
    public static List<AssignmentTable> assignmentTableList;
    public static FileUtil fileUtil = new FileUtil();

    public static DriversService driversService = new DriversService();
    public static LineService lineService = new LineService();
    public static AssigmentService assigmentService = new AssigmentService();


    public static void main(String[] args) {
        initializeData();
        menu();
    }

    public static void initializeData() {
        driversService.initializeDriverData();
        lineService.initializeLineData();
        assigmentService.initializeAssignmentTableData();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    driversService.addNewDriver();
                    driversService.showDriver();
                    break;
                case 2:
                    lineService.addNewLine();
                    lineService.showLine();
                    break;
                case 3:
                    assigmentService.creatAssignmentTable();
                    assigmentService.showAssignmentTable();
                    break;
                case 4:
                    assigmentService.sortByNameDriver();
                    assigmentService.showAssignmentTable();
                    break;
                case 5:
                    assigmentService.sortByTurnNumber();
                    assigmentService.showAssignmentTable();
                    break;
                case 6:
                    assigmentService.distanceStatistics();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }


    public static int functionChoice() {
        System.out.println("---------QUẢN LÝ Bảng điểm sinh viên---------");
        System.out.println("1. Nhập danh sách lái xe mới và in ra danh sách lái xe trong trường");
        System.out.println("2. Nhập danh sách tuyến mới và in ra danh sách tuyến trong trường");
        System.out.println("3. Bảng phân công của lái xe và in ra danh sách bảng phân công");
        System.out.println("4. Sắp xếp họ tên lái xe");
        System.out.println("5. Sắp xếp số lượng tuyến trong ngày(Giảm dần)");
        System.out.println("6. Bảng kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
        System.out.println("7. Thoát");
        System.out.println("----------------------------------------------");
        System.out.print("Chọn chức năng: ");
        do {
            try {
                int choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 7) {
                    return choice;
                }
                System.out.print("Chức năng khả dụng là một số nguyên từ 1 tới 7, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Chức năng chọn phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
    }

}