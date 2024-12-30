package org.example.coding;

import java.util.function.BiPredicate;

/*
YANDEX
ЗАДАЧА
Дан массив чисел a1, a2, ... aN.
Необходимо найти монотонный подотрезок (т.е. строго убывающий или строго возрастающий) максимальной длинны
и вернуть индексы его начала и конца.

Пример: [2, 7, 5, 4, 4, 3] -> [1, 3]
 */
public class MonoSegment {

    private static final BiPredicate<Integer, Integer> GREAT = (a, b) -> a > b;
    private static final BiPredicate<Integer, Integer> LESS = (a, b) -> a < b;

    public static void main(String[] args) {
        int[] nums = {2, 7, 5, 4, 4, 3};

        // Поиск возрастающей и убывающей лучше делать в отдельных проходах,
        // а не городить все в одном, т.к. надо учитывать много условий
        int[] maxIncreasing = getMaxIncreasing(nums);
        int[] maxDecreasing = getMaxDecreasing(nums);
        int[] res = maxIncreasing[1] - maxIncreasing[0] > maxDecreasing[1] - maxDecreasing[0]
                ? maxIncreasing : maxDecreasing;
        System.out.printf("%s %s", res[0], res[1]);
    }

    private static int[] getMaxIncreasing(int[] nums) {
        return getMax(nums, GREAT);
    }

    private static int[] getMaxDecreasing(int[] nums) {
        return getMax(nums, LESS);
    }

    private static int[] getMax(int[] nums, BiPredicate<Integer, Integer> comparator) {
        int left = 0;
        int max = 1;
        int[] res = new int[2];
        for (int right = 1; right < nums.length; right++) {
            if (!comparator.test(nums[right], nums[right - 1])) {
                if (right - left > max) {
                    res[0] = left;
                    res[1] = right - 1;
                    max = right - left + 1;
                }
                left = right;
            }
        }
        // проверяем после выхода, что последний отрезок максимальный
        if (nums.length - left > max) {
            res[0] = left;
            res[1] = nums.length - 1;
        }
        return res;
    }

}
