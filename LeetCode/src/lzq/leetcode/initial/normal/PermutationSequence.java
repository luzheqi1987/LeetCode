package lzq.leetcode.initial.normal;

import java.util.ArrayList;

public class PermutationSequence {
	/**
	 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
	 * 
	 * By listing and labeling all of the permutations in order, We get the
	 * following sequence (ie, for n = 3):
	 * 
	 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth
	 * permutation sequence.
	 * 
	 * Note: Given n will be between 1 and 9 inclusive.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		--k;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		String s = new String();
		int njiecheng = 1;
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
			njiecheng *= i;
		}
		for (int j = n; j >= 1; j--) {
			int num = k / (njiecheng / j);
			s = s + numbers.get(num);
			numbers.remove(num);
			k = k % (njiecheng / j);
			njiecheng = njiecheng / j;
		}
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PermutationSequence().getPermutation(3, 5));
	}

}
