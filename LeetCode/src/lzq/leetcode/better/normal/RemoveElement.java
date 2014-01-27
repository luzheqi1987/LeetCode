package lzq.leetcode.better.normal;

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
		int newlen = 0;
		int oldlen = A.length;

		for (int i = 0; i < oldlen; i++) {
			if (A[i] == elem) {
				continue;
			} else {
				A[newlen++] = A[i];
			}
		}

		return newlen;
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
