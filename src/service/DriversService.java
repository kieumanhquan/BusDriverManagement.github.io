package service;

import entity.Drivers;
import main.MainRun;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DriversService {
    public static final String DRIVER_DATA_FILE = "driver.dat";

    public void showDriver() {
        for (Drivers drivers : MainRun.driversList) System.out.println(drivers);
    }

    public void addNewDriver() {
        System.out.print("Nhập số lái xe muốn thêm mới: ");
        int driverNumber = -1;
        do {
            try {
                driverNumber = new Scanner(System.in).nextInt();
                if (driverNumber > 0) {
                    break;
                }
                System.out.print("Số lái xe muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lái xe muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < driverNumber; i++) {
            Drivers drivers = new Drivers();
            drivers.inputInfo();
            MainRun.driversList.add(drivers);
        }
        MainRun.fileUtil.writeDataToFile(MainRun.driversList, DRIVER_DATA_FILE);
    }

    public Drivers findDriversById(int driversId) {
        for (Drivers drivers : MainRun.driversList) {
            if (drivers.getId() == driversId)
                return drivers;
        }
        return null;
    }

    public void initializeDriverData() {
        List<Drivers> driversList = MainRun.fileUtil.readDataFromFile(DriversService.DRIVER_DATA_FILE);
        if (driversList != null) {
            Drivers.AUTO_ID = driversList.get(driversList.size() - 1).getId() + 1;
            MainRun.driversList = driversList;
            System.out.println(MainRun.driversList.size());
        } else {
            MainRun.driversList = new ArrayList<>();
        }

    }
}
