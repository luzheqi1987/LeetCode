package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
	/**
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 1,2,3 ¡ú 1,3,2 3,2,1 ¡ú
	 * 1,2,3 1,1,5 ¡ú 1,5,1
	 * 
	 * @param num
	 */
	public void nextPermutation(int[] num) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		List<Integer> rest = new ArrayList<Integer>();
		int i = 0;
		for (i = num.length - 1; i >= 1; i--) {
			if (num[i] <= num[i - 1]) {
				rest.add(num[i]);
			} else {
				break;
			}
		}
		if (i <= 0) {
			Arrays.sort(num);
		} else {
			int j = 0;
			rest.add(num[i]);
			for (; j < rest.size(); j++) {
				if (rest.get(j) > num[i - 1]) {
					break;
				}
			}
			int tmp = rest.get(j);
			rest.set(j, num[i - 1]);
			num[i - 1] = tmp;
			for (j = 0; i < num.length; i++, j++) {
				num[i] = rest.get(j);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NextPermutation()
				.nextPermutation(new int[] { 1, 6, 7, 3, 5, 4, 2 });
	}

}
