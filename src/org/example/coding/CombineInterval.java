package org.example.coding;

import java.util.Map;
import java.util.TreeMap;

public class CombineInterval {

    /*
    Есть набор интервалов. Интервалы заданы координатой начала и конца.
    Требуется ответить сколько получится интервалов после объединения интервалов.

    Моя реализация
     */

    private static final TreeMap<Integer, Integer> MAP = new TreeMap<>();

    public static void main(String[] args) {
        int[][] intervals = {{0, 2}, {4, 5}, {1, 3}, {5, 6}};
        for (int[] interval : intervals) {
            addInterval(interval[0], interval[1]);
        }
        for (Map.Entry<Integer, Integer> entry : MAP.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    private static void addInterval(int start, int end) {
        Map.Entry<Integer, Integer> before = MAP.floorEntry(start);
        Map.Entry<Integer, Integer> after = MAP.ceilingEntry(start);

        if (before != null && start <= before.getValue()) {
            start = before.getKey();
            end = Math.max(end, before.getValue());
            MAP.remove(before.getKey());
        }

        while (after != null && end >= after.getKey()) {
            end = Math.max(end, after.getValue());
            MAP.remove(after.getKey());
            after = MAP.ceilingEntry(after.getKey());
        }

        MAP.put(start, end);

    }

}
