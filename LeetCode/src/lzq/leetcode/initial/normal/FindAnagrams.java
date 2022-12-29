package lzq.leetcode.initial.normal;

import java.util.*;
import java.util.stream.Collectors;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        Map<Character, Integer> pc = new HashMap<>();
        Set<Character> pcs = new HashSet<>();
        for (char c : p.toCharArray()) {
            pc.put(c, pc.getOrDefault(c, 0) + 1);
            pcs.add(c);
        }
        int currentNum = 0;
        Map<Character, Integer> currentMap = new HashMap<>();
        Set<Character> readyChar = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!pcs.contains(s.charAt(i))) {
                currentMap.clear();
                readyChar.clear();
                currentNum = 0;
            } else if (currentNum < p.length()) {
                currentMap.put(s.charAt(i), currentMap.getOrDefault(s.charAt(i), 0) + 1);
                if (currentMap.getOrDefault(s.charAt(i), -1).equals(pc.getOrDefault(s.charAt(i), -2))) {
                    readyChar.add(s.charAt(i));
                } else {
                    readyChar.remove(s.charAt(i));
                }
                currentNum++;
                if (currentNum == p.length() && readyChar.size() == pcs.size()) {
                    result.add(i - (p.length() - 1));
                }
            } else {
                currentMap.put(s.charAt(i - p.length()), currentMap.get(s.charAt(i - p.length())) - 1);
                if (currentMap.getOrDefault(s.charAt(i - p.length()), -1).equals(pc.getOrDefault(s.charAt(i - p.length()), -2))) {
                    readyChar.add(s.charAt(i - p.length()));
                } else {
                    readyChar.remove(s.charAt(i - p.length()));
                }
                currentMap.put(s.charAt(i), currentMap.getOrDefault(s.charAt(i), 0) + 1);
                if (currentMap.getOrDefault(s.charAt(i), -1).equals(pc.getOrDefault(s.charAt(i), -2))) {
                    readyChar.add(s.charAt(i));
                } else {
                    readyChar.remove(s.charAt(i));
                }
                if (readyChar.size() == pcs.size()) {
                    result.add(i - (p.length() - 1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAnagrams ff = new FindAnagrams();
        System.out.println(ff.findAnagrams("cbaebabacd", "abc").stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
