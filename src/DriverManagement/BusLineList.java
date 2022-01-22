package DriverManagement;

import entity.BusLine;

import java.io.Serializable;

public class BusLineList implements Serializable {
    private BusLine busLine;
    private int drivingTurnNumber;

    public BusLineList() {
    }

    public BusLineList(BusLine busLine, int drivingTurnNumber) {
        this.busLine = busLine;
        this.drivingTurnNumber = drivingTurnNumber;
    }

    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }

    public int getDrivingTurnNumber() {
        return drivingTurnNumber;
    }

    public void setDrivingTurnNumber(int drivingTurnNumber) {
        this.drivingTurnNumber = drivingTurnNumber;
    }

    @Override
    public String toString() {
        return "BusLineList {" +
                " busLine = " + busLine +
                ", drivingTurnNumber = " + drivingTurnNumber +
                '}';
    }
}
