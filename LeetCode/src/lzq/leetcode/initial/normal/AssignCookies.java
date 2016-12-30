package lzq.leetcode.initial.normal;

import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int i = 0, j = 0, sum = 0;
		while (i < g.length && j < s.length) {
			if (s[j] >= g[i]) {
				sum++;
				i++;
				j++;
			} else {
				j++;
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
