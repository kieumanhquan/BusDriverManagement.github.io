package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
    private String name;
    private String address;
    private String phonenumber;

    public Person() {
    }

    public Person(String name, String address, String phonenumber) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void inputInfo(){
        System.out.println("Nhập tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điên thoại: ");
        this.phonenumber = new Scanner(System.in).nextLine();
    }

    @Override
    public String toString() {
        return "Person {" +
                " name = '" + name + '\'' +
                ", address = '" + address + '\'' +
                ", phonenumber = '" + phonenumber + '\'' +
                '}';
    }
}
