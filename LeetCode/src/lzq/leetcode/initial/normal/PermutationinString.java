package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

public class PermutationinString {
	Map<Character, Integer> charMap = new HashMap<>();

	public boolean checkInclusion(String s1, String s2) {
		for (char c : s1.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}
		int i = 0;
		
		for(int m = 0; m < s2.length(); m++){
			char c = s2.charAt(m);
			
			if(!charMap.containsKey(c)){
				while(i != m){
					char oldC = s2.charAt(i);
					charMap.put(oldC, charMap.getOrDefault(oldC, 0) + 1);
					i++;
				}
				i++;
				continue;
			}
			
			if(charMap.get(c) > 0){
				charMap.put(c, charMap.getOrDefault(c, 0) - 1);
				if(m - i == s1.length() - 1){
					return true;
				}
				continue;
			}
			
			while(i != m && charMap.get(c) <=0){
				char oldC = s2.charAt(i);
				charMap.put(oldC, charMap.getOrDefault(oldC, 0) + 1);
				i++;
			}
			charMap.put(c, charMap.getOrDefault(c, 0) - 1);
		}
		return false;
	}
	public static void main(String[] args){
		String s1 = "adc";
		String s2 = "dcda";
		
		System.out.println(new PermutationinString().checkInclusion(s1, s2));
	}
}
