package entity.table;

import entity.Drivers;

import java.io.Serializable;
import java.util.List;

public class AssignmentTable implements Serializable {
    private Drivers drivers;

    private List<Assignment> assignmentList;

    public AssignmentTable(Drivers drivers, List<Assignment> assignmentList) {
        this.drivers = drivers;
        this.assignmentList = assignmentList;
    }

    public Drivers getDrivers() {
        return drivers;
    }

    public void setDrivers(Drivers drivers) {
        this.drivers = drivers;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public String toString() {
        return "AssignmentTable{" +
                "driver=" + drivers +
                ", assignmentList=" + assignmentList +
                '}';
    }
}
