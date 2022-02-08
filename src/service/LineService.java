package service;


import entity.Line;
import main.MainRun;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static main.MainRun.busLineList;

public class LineService {
    public static final String LINE_DATA_FILE = "line.dat";

    public void showLine() {
        for (Line line : busLineList) System.out.println(line);
    }

    public void addNewLine() {
        System.out.print("Nhập số tuyến muốn thêm mới: ");
        int lineNumber = -1;
        do {
            try {
                lineNumber = new Scanner(System.in).nextInt();
                if (lineNumber > 0) {
                    break;
                }
                System.out.print("Số tuyến muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số tuyến muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < lineNumber; i++) {
            Line line = new Line();
            line.inputInfo();
            busLineList.add(line);
        }
        MainRun.fileUtil.writeDataToFile(busLineList, LINE_DATA_FILE);
    }

    public Line findLineById(int lineId) {
        for (Line line : busLineList) {
            if (line.getId() == lineId)
                return line;
        }
        return null;
    }

    public void initializeLineData() {
        List<Line> lineList = MainRun.fileUtil.readDataFromFile(LINE_DATA_FILE);
        if (lineList != null) {
            Line.AUTO_ID = lineList.get(busLineList.size() - 1).getId() + 1;
            busLineList = busLineList;
        } else {
            busLineList = new ArrayList<>();
        }
    }
}
