package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Driver extends Person implements Serializable {
    private int id;
    private String level;

    private final static String LEVEL_A = "Trình độ A";
    private final static String LEVEL_B = "Trình độ B";
    private final static String LEVEL_C = "Trình độ C";
    private final static String LEVEL_D = "Trình độ D";
    private final static String LEVEL_E = "Trình độ E";
    private final static String LEVEL_F = "Trình độ F";

    private static int AUTO_ID = 10000;

    public Driver() {
    }

    public Driver(int id, String level) {
        this.id = id;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static String getLevelA() {
        return LEVEL_A;
    }

    public static String getLevelB() {
        return LEVEL_B;
    }

    public static String getLevelC() {
        return LEVEL_C;
    }

    public static String getLevelD() {
        return LEVEL_D;
    }

    public static String getLevelE() {
        return LEVEL_E;
    }

    public static String getLevelF() {
        return LEVEL_F;
    }

    public void inputInfo(){
        this.setId(Driver.AUTO_ID);
        super.inputInfo();
        System.out.println("Nhập loại trình độ của lái xe: ");
        System.out.println("1. Trình độ A");
        System.out.println("2. Trình độ B");
        System.out.println("3. Trình độ C");
        System.out.println("4. Trình độ D");
        System.out.println("5. Trình độ E");
        System.out.println("6. Trình độ F");
        boolean check = true;
        do {
            int choice = 0;
            try {
                choice = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.print("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }
            if (choice <= 0 || choice > 6) {
                System.out.print("Nhập số trong khoảng từ 1 đến 6! Nhập lại: ");
                check = false;
                continue;
            }
            switch (choice) {
                case 1:
                    this.setLevel(Driver.LEVEL_A);
                    System.out.println("Trình độ A");
                    check = true;
                    break;
                case 2:
                    this.setLevel(Driver.LEVEL_B);
                    System.out.println("Trình độ B");
                    check = true;
                    break;
                case 3:
                    this.setLevel(Driver.LEVEL_C);
                    System.out.println("Trình độ C");
                    check = true;
                    break;
                case 4:
                    this.setLevel(Driver.LEVEL_D);
                    System.out.println("Trình độ D");
                    check = true;
                    break;
                case 5:
                    this.setLevel(Driver.LEVEL_E);
                    System.out.println("Trình độ E");
                    check = true;
                    break;
                case 6:
                    this.setLevel(Driver.LEVEL_F);
                    System.out.println("Trình độ F");
                    check = true;
                    break;
                default:
                    System.out.println("Nhập sai! Hãy nhập từ 1 đến 3!");
                    check = false;
                    break;
            }
        } while (!check);
        Driver.AUTO_ID++;
    }

    @Override
    public String toString() {
        return super.toString()+ " Driver {" +
                " id = " + id +
                ", level = '" + level + '\'' +
                '}';
    }
}