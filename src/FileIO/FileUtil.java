package FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
    public static <T> void writeDataToFile(List<T> data, String fileName) {
        if (DataUtil.isEmptyCollection(data)) {
            return;
        }

        while (StringUtil.isEmptyString(fileName)) {
            System.out.println("Tên file không hợp lệ! Nhâp lại");
            fileName = new Scanner(System.in).nextLine();
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List readDataFromFile(String fileName) {
        if (StringUtil.isEmptyString(fileName)) {
            return new ArrayList<>();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
