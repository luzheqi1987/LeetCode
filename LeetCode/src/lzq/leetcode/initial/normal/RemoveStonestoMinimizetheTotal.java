package lzq.leetcode.initial.normal;

import java.util.*;

public class RemoveStonestoMinimizetheTotal {

    public int minStoneSum(int[] piles, int k) {
        int total = 0;
        Map<Integer, List<Integer>> numberIndex = new HashMap<>();
        TreeSet<Integer> descPiles = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < piles.length; i++) {
            int pile = piles[i];
            total += pile;
            List<Integer> indexList = numberIndex.getOrDefault(pile, new ArrayList<>());
            indexList.add(i);
            numberIndex.put(pile, indexList);
            descPiles.add(pile);
        }
        while (k > 0) {
            if (k == 1) {
                System.out.println(k);
            }
            int before = descPiles.first();
            List<Integer> beforeIndexes = numberIndex.get(before);
            int after = before - before / 2;
            if (before != after) {
                Integer index = beforeIndexes.get(0);
                beforeIndexes.remove(index);
                if (beforeIndexes.isEmpty()) {
                    numberIndex.remove(before);
                    descPiles.remove(before);
                }
                List<Integer> afterIndexList = numberIndex.getOrDefault(after, new ArrayList<>());
                afterIndexList.add(index);
                numberIndex.put(after, afterIndexList);
                descPiles.add(after);
            }
            total -= before / 2;
            k--;
        }
        return total;
    }

    public int minStoneSum1(int[] piles, int k) {
        int total = 0;
        TreeMap<Integer, List<Integer>> numberIndex = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < piles.length; i++) {
            int pile = piles[i];
            total += pile;
            List<Integer> indexList = numberIndex.getOrDefault(pile, new ArrayList<>());
            indexList.add(i);
            numberIndex.put(pile, indexList);
        }
        while (k > 0) {
            if (k == 1) {
                System.out.println(k);
            }
            int before = numberIndex.firstKey();
            List<Integer> beforeIndexes = numberIndex.get(before);
            int after = before - before / 2;
            if (before != after) {
                Integer index = beforeIndexes.get(0);
                beforeIndexes.remove(index);
                if (beforeIndexes.isEmpty()) {
                    numberIndex.remove(before);
                }
                List<Integer> afterIndexList = numberIndex.getOrDefault(after, new ArrayList<>());
                afterIndexList.add(index);
                numberIndex.put(after, afterIndexList);
            }
            total -= before / 2;
            k--;
        }
        return total;
    }

    public static void main(String[] args) {
        RemoveStonestoMinimizetheTotal r = new RemoveStonestoMinimizetheTotal();
        System.out.println(r.minStoneSum1(new int[]{8011, 8387, 6007, 1235, 5595, 138, 3136, 1740, 963, 9412, 802, 4475, 9695, 3713, 1742, 8559, 2237, 4356, 4012, 3449, 990, 6930, 523, 931, 5937, 5902, 2817, 4088, 385, 1359, 1888, 1106, 416, 670, 347, 6113, 4190, 2094, 2575, 3011, 8571, 32, 6318, 9658, 708, 4061, 2481, 595, 69}, 80));
    }
}
