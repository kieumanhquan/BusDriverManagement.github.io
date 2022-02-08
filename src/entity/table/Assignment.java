package entity.table;

import entity.Line;

import java.io.Serializable;

public class Assignment implements Serializable {
    private Line busLine;

    private int turnNumber;

    public Assignment(Line busLine, int turnNumber) {
        this.busLine = busLine;
        this.turnNumber = turnNumber;
    }

    public Line getLine() {
        return busLine;
    }

    public float getDistance(){
        //1 lượt gồm lượt đi lượt về
        return busLine.getDistance()*turnNumber*2;
    }

    public void setLine(Line busLine) {
        this.busLine = busLine;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "line=" + busLine +
                ", turnNumber=" + turnNumber +
                '}';
    }
}