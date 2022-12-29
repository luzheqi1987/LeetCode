package lzq.leetcode.initial.normal;

import java.util.*;

public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> or = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            or.put(order.charAt(i), i);
        }
        List<Character> newOrder = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            newOrder.add(s.charAt(i));
        }

        newOrder.sort(new Comparator<Character>() {
            public int compare(Character c1, Character c2){
                if (c1 == c2) {
                    return 0;
                }
                if (or.containsKey(c1) && or.containsKey(c2)) {
                    return or.get(c1) - or.get(c2);
                } else if (or.containsKey(c1) && !or.containsKey(c2)) {
                    return -1;
                }else if (!or.containsKey(c1) && or.containsKey(c2)) {
                    return 1;
                }
                return c1 - c2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(char c : newOrder) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("exv", "xwe"));
    }
}
