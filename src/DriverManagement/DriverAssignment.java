package DriverManagement;

import entity.Driver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DriverAssignment implements Serializable {
    private Driver driver;
    private List<BusLineList> busLineLists = new ArrayList<>();
    private int busLineSum;
    private float distanceSum;

    public DriverAssignment() {
    }

    public DriverAssignment(Driver driver, List<BusLineList> busLineLists) {
        this.driver = driver;
        this.busLineLists = busLineLists;
    }

    public float getDistanceSum() {
        return distanceSum;
    }

    public void setDistanceSum(float distanceSum) {
        this.distanceSum = distanceSum;
    }

    public int getBusLineSum() {
        return busLineSum;
    }

    public void setBusLineSum(int busLineSum) {
        this.busLineSum = busLineSum;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<BusLineList> getBusLineLists() {
        return busLineLists;
    }

    public void setBusLineLists(List<BusLineList> busLineLists) {
        this.busLineLists = busLineLists;
    }

    @Override
    public String toString() {
        return "DriverAssignment {" +
                " driver = " + driver +
                ", busLineLists = " + busLineLists +
                '}';
    }
}