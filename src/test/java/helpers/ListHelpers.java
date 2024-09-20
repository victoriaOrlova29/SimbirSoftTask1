package helpers;

import java.util.Collections;
import java.util.List;

public class ListHelpers {

    public static void sortAlphabetically(List<String> list) {
        Collections.sort(list);
    }

    public static void sortReverseAlphabetically(List<String> list) {
        Collections.sort(list, Collections.reverseOrder());
    }
}