package lzq.leetcode.initial.normal;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort2 {
    public void sort(int[] numbers) {
        partition(numbers, 0, numbers.length - 1);
    }

    private void partition(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = numbers[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && numbers[right] >= pivot) {
                right--;
            }
            while (left < right && numbers[left] <= pivot) {
                left++;
            }
            swap(numbers, left, right);
        }
        swap(numbers, left, start);
        partition(numbers, left + 1, end);
        partition(numbers, start, left - 1);
    }

    private void swap(int[] numbers, int l, int r) {
        int tmp = numbers[l];
        numbers[l] = numbers[r];
        numbers[r] = tmp;
    }

    public static void main(String[] args) {
        QuickSort2 q = new QuickSort2();
        int[] numbers = new int[]{3,2,2,3,4,5,6,7,3,2,15,35,23,32};
        q.sort(numbers);
        System.out.println(Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
