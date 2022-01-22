package entity;

import java.io.Serializable;
import java.util.Scanner;

public class BusLine implements Serializable {
    private int id;
    private float distance;
    private int busStopNumber;

    private static int AUTO_ID = 100;

    public BusLine() {
    }

    public BusLine(int id, float distance, int busStopNumber) {
        this.id = id;
        this.distance = distance;
        this.busStopNumber = busStopNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getBusStopNumber() {
        return busStopNumber;
    }

    public void setBusStopNumber(int busStopNumber) {
        this.busStopNumber = busStopNumber;
    }

    public void inputBusLineInfo(){
        this.setId(BusLine.AUTO_ID);
        System.out.println("Nhập thông khoảng cách: ");
        this.distance = new Scanner(System.in).nextFloat();
        System.out.println("Nhập số điểm dừng: ");
        this.busStopNumber = new Scanner(System.in).nextInt();
        BusLine.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "BusLine {" +
                " id = " + id +
                ", distance = " + distance +
                ", busStopNumber = " + busStopNumber +
                '}';
    }
}
