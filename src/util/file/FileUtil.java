package util.file;

import util.StringUtil;

import java.io.*;
import java.util.List;

public class FileUtil implements DataReadable, DataWritable {
    @Override
    public <T> void writeDataToFile(List<T> data, String fileName) {
        if (StringUtil.isNullOrEmpty(fileName) || data.isEmpty()) {
            return;
        }
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName))) {
            o.writeObject(data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> readDataFromFile(String fileName) {
        if (StringUtil.isNullOrEmpty(fileName)) {
            return null;
        }
        if (!new File(fileName).exists()) {
            return null;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
