package FileIO;

import java.util.Collection;

public class DataUtil {
    public static <T> boolean isEmptyCollection(Collection<T> collection){
        return collection == null || collection.isEmpty();
    }
}
