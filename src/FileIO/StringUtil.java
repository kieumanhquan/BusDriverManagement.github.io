package FileIO;

public class StringUtil {
    public static boolean isEmptyString(String fileName){
        return fileName == null || fileName.trim().equals("");
    }
}
