package util.file;

//public interface DataWritable {
//
//    void writeDataToFile(Object[] data, String fileName);
//
//}

import java.util.List;

public interface DataWritable {
    <T> void writeDataToFile(List<T> data, String fileName);
}