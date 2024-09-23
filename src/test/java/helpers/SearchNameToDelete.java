package helpers;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SearchNameToDelete {
    public static String findClosestNameToAverageLength(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("Имен нет");
        }
        IntSummaryStatistics statistics = names.stream()
                .mapToInt(String::length)
                .summaryStatistics();
        double averageLength = statistics.getAverage();
        return names.stream()
                .min(Comparator.comparingDouble(name -> Math.abs(name.length() - averageLength)))
                .orElse(null);
    }
}
