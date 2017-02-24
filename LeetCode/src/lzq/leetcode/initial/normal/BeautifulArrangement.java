package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BeautifulArrangement {

	public int countArrangement(int N) {
		if (N == 0) {
			return 0;
		}
		int[] used = new int[N + 1];

		return findRight(N, 1, used);
	}

	private int findRight(int maxNumber, int position, int[] used) {
		if (position > maxNumber) {
			return 1;
		}

		int rightNumber = 0;
		for (int i = 1; i <= maxNumber; i++) {
			if (used[i] == 0 && (position % i == 0 || i % position == 0)) {
				used[i] = 1;
				rightNumber += findRight(maxNumber, position + 1, used);
				used[i] = 0;
			}
		}
		return rightNumber;
	}

	public int countArrangement1(int N) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			hs.add(i);
		}
		List<Integer> arrays = new ArrayList<>(N + 1);
		for (int i = 0; i <= N; i++) {
			arrays.add(0);
		}
		return c_r(hs, 1, N, arrays);

	}

	private int c_r(HashSet<Integer> hs, int index, int N, List<Integer> arrays) {
		if (index == N + 1) {
			for (int j : arrays) {
				System.out.print(j + "\t");
			}
			System.out.println();
			return 1;
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (i % index == 0 || index % i == 0) {
				if (hs.contains(i)) {
					hs.remove(i);
					arrays.set(index, i);
					count += c_r(hs, index + 1, N, arrays);
					hs.add(i);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		BeautifulArrangement b = new BeautifulArrangement();
		System.out.println(b.countArrangement(6));
		// System.out.println(b.countArrangement1(6));
	}

}
