package utils;

import model.BaseMedicine;
import java.util.Comparator;
import java.util.List;

public class SortingUtils {
    public static void sortByPrice(List<BaseMedicine> list) {
        list.sort(Comparator.comparing(BaseMedicine::calculateFinalPrice));
    }
}
