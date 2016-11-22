package lzq.leetcode.initial.normal;

import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class OneThreeTwo132Pattern {

	public boolean find132pattern(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> ranges = new TreeMap<>();
		Set<Integer> keys = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
			}
			if (max < nums[i]) {
				max = nums[i];
			}
			if (ranges.isEmpty()) {
				ranges.put(nums[i], nums[i]);
				keys.add(nums[i]);
			} else {
				for (int key : keys) {
					if (key < nums[i]) {
						if (nums[i] < ranges.get(key)) {
							return true;
						} else {
							ranges.put(key, nums[i]);
							if (max == nums[i]) {
								ranges.clear();
								keys.clear();
								ranges.put(key, nums[i]);
								keys.add(key);
								break;
							}
						}
					} else if (key > nums[i]) {
						ranges.put(nums[i], nums[i]);
						keys.add(nums[i]);
						break;
					}
				}
			}
		}

		return false;
	}
	public boolean find132pattern1(int[] nums) {
		Stack<Range> stack = new Stack<>();
		for(int num : nums) {
			Range cur = new Range(num, num);
			while(!stack.isEmpty() && cur.max > stack.peek().min) {
				cur.min = Math.min(stack.peek().min, cur.min);
				cur.max = Math.max(stack.peek().max, cur.max);
				stack.pop();
			}
			stack.push(cur);
			
			if(stack.peek().min < num && num < stack.peek().max)
				return true;
		}
		
		return false;
	}

	public static class Range {
		public int min;
		public int max;
		
		public Range(int mn, int mx) {
			min = mn;
			max = mx;
		}
	}
	public static void main(String[] args) {
		OneThreeTwo132Pattern oneThreeTwo132Pattern = new OneThreeTwo132Pattern();
		int[] i1 = new int[] {250000000,250050000,249900000,249950000,249800000,249850000,249700000,249750000,249600000,249650000,249500000,249550000,249400000,249450000,249300000,249350000,249200000,249250000,249100000,249150000,249000000,249050000,248900000,248950000,248800000,248850000,248700000,248750000,248600000,248650000,248500000,248550000,248400000,248450000,248300000,248350000,248200000,248250000,248100000,248150000,248000000,248050000,247900000,247950000,247800000,247850000,247700000,247750000,247600000,247650000,247500000,247550000,247400000,247450000,247300000,247350000,247200000,247250000,247100000,247150000,247000000,247050000,246900000,246950000,246800000,246850000,246700000,246750000,246600000,246650000,246500000,246550000,246400000,246450000,246300000,246350000,246200000,246250000,246100000,246150000,246000000,246050000,245900000,245950000,245800000,245850000,245700000,245750000,245600000,245650000,245500000,245550000,245400000,245450000,245300000,245350000,245200000,245250000,245100000,245150000,245000000,245050000,244900000};
		int[] i2 = new int[] { 3, 1, 4, 2 };
		int[] i3 = new int[] { 1, 0, 1, -4, -3 };
		int[] i4 = new int[] { 1, 2, 3, 4 };
		int[] i5 = new int[] { 1, -4, 2, -1, 3, -3, -4, 0, -3, -1 };
		int[] i6 = new int[] {-1,10,-20,-10,-15};

		//System.out.println(oneThreeTwo132Pattern.find132pattern1(i1));
		//System.out.println(oneThreeTwo132Pattern.find132pattern1(i2));
		System.out.println(oneThreeTwo132Pattern.find132pattern1(i3));
		//System.out.println(oneThreeTwo132Pattern.find132pattern1(i4));
		//System.out.println(oneThreeTwo132Pattern.find132pattern1(i5));
		//System.out.println(oneThreeTwo132Pattern.find132pattern1(i6));
	}

}
