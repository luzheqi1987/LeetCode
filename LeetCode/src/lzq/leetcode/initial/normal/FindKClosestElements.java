package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (k >= arr.length) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }

        int xPos = findX(arr, x);
        int nearestNum = arr[xPos];
        if (nearestNum > x && xPos > 0 && x - arr[xPos - 1] <= nearestNum - x) {
            xPos--;
        }else if (nearestNum < x && xPos < arr.length - 1 && arr[xPos + 1] - x < x - nearestNum) {
            xPos++;
        }
        List<Integer> result = new ArrayList<>();
        result.add(arr[xPos]);
        int left = xPos - 1;
        int right = xPos + 1;
        while (left >= 0 && right <= arr.length - 1 && result.size() < k) {
            if (arr[right] - x < x - arr[left]) {
                result.add(arr[right]);
                right++;
            } else {
                result.add(0, arr[left]);
                left--;
            }
        }

        if (result.size() < k) {
            int currentSize = k - result.size();
            if (right > arr.length - 1) {
                for (int i = 0; i < currentSize; i++) {
                    result.add(0, arr[left - i]);
                }
            } else {
                for (int i = 0; i < currentSize; i++) {
                    result.add(arr[right + i]);
                }
            }
        }

        return result;
    }

    private int findX(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        FindKClosestElements f = new FindKClosestElements();
        System.out.println(f.findClosestElements(new int[]{1,3}, 1, 2).stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
