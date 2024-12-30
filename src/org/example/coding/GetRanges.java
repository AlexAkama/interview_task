package org.example.coding;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
ЗАДАЧА
Необходимо реализовать функцию getRanges, которая возвращает следующие результаты:
getRanges([0, 1, 2, 3, 4, 7, 8, 10])    // "0-4,7-8,10"
getRanges([4,7,10])                     // "4,7,10"
getRanges([2, 3, 8, 9])                 // "2-3,8-9"
 */
public class GetRanges {

    /*
    Моя реализация
     */
    private static final TreeMap<Integer, Integer> MAP = new TreeMap<>();

    public static void main(String[] args) {
        int[] data1 = {0, 1, 2, 3, 4, 7, 8, 10};
        int[] data2 = {4, 7, 10};
        int[] data3 = {2, 3, 8, 9};

        String ranges = getRanges(data1);
        System.out.println(ranges);

    }

    private static String getRanges(int[] nums) {
        for (int num : nums) {
            addToInterval(num);
        }
        return buildResponse();
    }

    private static void addToInterval(int num) {
        Map.Entry<Integer, Integer> before = MAP.floorEntry(num);
        Map.Entry<Integer, Integer> after = MAP.floorEntry(num);

        int start = num;
        int end = num;

        if (before != null && num == before.getValue() + 1) {
            start = before.getKey();
            MAP.remove(before.getKey());
        }

        if (after != null && num == after.getKey() - 1) {
            end = after.getValue();
            MAP.remove(after.getKey());
        }

        MAP.put(start, end);
    }

    private static String buildResponse() {
        return MAP.entrySet().stream()
                .map(GetRanges::mapEntryToInterval)
                .collect(Collectors.joining(","));
    }

    private static String mapEntryToInterval(Map.Entry<Integer, Integer> entry) {
        if (entry.getKey().equals(entry.getValue())) return "" + entry.getKey();
        return entry.getKey() + "-" + entry.getValue();
    }

}
