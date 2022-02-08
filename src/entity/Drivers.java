package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Drivers extends Person implements Serializable {

    public static int AUTO_ID = 10000;

    private int id;

    private String driveLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriveLevel() {
        return driveLevel;
    }

    public void setDriveLevel(String driveLevel) {
        this.driveLevel = driveLevel;
    }

    public void inputInfo() {
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
        super.inputInfo();
        inputDriveLevel();

    }

    public void inputDriveLevel() {
        System.out.print("Nhập trình độ (A-F): ");
        String driveLevel = "";
        do {
            driveLevel = new Scanner(System.in).nextLine();
            if (driveLevel.matches("[a-fA-F]")) {
                this.driveLevel = driveLevel;
                break;
            }
            System.out.println("trình độ phải A-F");
        } while (true);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", driveLevel='" + driveLevel + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}