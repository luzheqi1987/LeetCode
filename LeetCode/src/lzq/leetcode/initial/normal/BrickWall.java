package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
	Map<Integer, Integer> edgeMap = new HashMap<>(); 

	public int leastBricks(List<List<Integer>> wall) {
		if (wall == null) {
			return 0;
		}
		int length = 0;
		int layNum = 0;
		for (int l : wall.get(0)) {
			length += l;
		}
		for (List<Integer> w : wall) {
			layNum++;
			int location = 0;
			for (int l : w) {
				location += l;
				if (location == length) {
					break;
				}
				edgeMap.put(location, edgeMap.getOrDefault(location, 0) + 1);
			}
		}
		int max = Integer.MIN_VALUE;
		for (int value : edgeMap.values()) {
			if (value > max) {
				max = value;
			}
		}
		return layNum - max;
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(new Integer[]{1,2,2,1});
		List<Integer> list2 = Arrays.asList(new Integer[]{3,1,2});
		List<Integer> list3 = Arrays.asList(new Integer[]{1,3,2});
		List<Integer> list4 = Arrays.asList(new Integer[]{2,4});
		List<Integer> list5 = Arrays.asList(new Integer[]{3,1,2});
		List<Integer> list6 = Arrays.asList(new Integer[]{1,3,1,1});
		
		List<List<Integer>> wall = new ArrayList<List<Integer>>(); 
		wall.add(list1);
		wall.add(list2);
		wall.add(list3);
		wall.add(list4);
		wall.add(list5);
		wall.add(list6);
		
		System.out.println(new BrickWall().leastBricks(wall));

	}

}
