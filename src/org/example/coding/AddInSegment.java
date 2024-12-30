package org.example.coding;

import java.util.Arrays;

/*
YANDEX
Дается массив nums длинны n
Потом даются q запросов, каждый запрос это два числа l и r (1 <= l <= r <= n).
Нужно прибавить единицу к числам nums[l], nums[l+1], ..., nums[r].
После надо вывести получившийся массив.
 */
public class AddInSegment {

    private static int[] prefix;
    private static int[] calculatePrefix;

    public static void main(String[] args) {
        int[] data = {5, 1, 3, 2, 4, 0};
        buildPrefix(data);

        // Тут нумерация с единицы
        updatePrefix(2, 4);
        updatePrefix(1, 1);
        updatePrefix(6, 6);

        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(getResult()));
    }


    private static void buildPrefix(int[] nums) {
        prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        calculatePrefix = Arrays.copyOf(prefix, prefix.length);
    }

    private static void updatePrefix(int left, int right) {
        for (int i = left; i <= right; i++) {
            calculatePrefix[i]++;
        }
    }

    private static int[] getResult() {
        int[] res = new int[prefix.length - 1];
        for (int i = 1; i < prefix.length; i++) {
            res[i - 1] = calculatePrefix[i] - prefix[i - 1];
        }
        return res;
    }

}
