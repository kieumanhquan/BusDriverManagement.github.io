package util.file;

//public interface DataReadable {
//
//    Object readDataFromFile(String fileName);
//
//}

import java.util.List;

public interface DataReadable {
    <T> List<T> readDataFromFile(String fileName);
}
