package lzq.leetcode.initial.normal;

import java.util.ArrayList;

public class RemoveElement {
	/**
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 * 
	 * @param A
	 * @param elem
	 * @return
	 */
	public int removeElement(int[] A, int elem) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> removeIndex = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				removeIndex.add(i);
			}
		}
		for (int i = removeIndex.size() - 1; i >= 0; i--) {
			int tmp = removeIndex.get(i);
			if (tmp == A.length - removeIndex.size() + i) {
				A[tmp] = 0;
			} else {
				A[tmp] = A[A.length - removeIndex.size() + i];
				A[A.length - removeIndex.size() + i] = 0;
			}
		}
		return A.length - removeIndex.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RemoveElement().removeElement(
				new int[] { 4, 5 }, 4));
	}
}
