package lzq.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (numRows <= 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> pascalsTriangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> layer = new ArrayList<Integer>();
		layer.add(1);
		pascalsTriangle.add(layer);
		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> layeri = new ArrayList<Integer>();
			ArrayList<Integer> layerj = pascalsTriangle.get(i - 1);
			layeri.add(1);
			for (int j = 1; j <= i; j++) {
				if (j == i) {
					layeri.add(1);
				} else {
					layeri.add(layerj.get(j) + layerj.get(j - 1));
				}
			}
			pascalsTriangle.add(layeri);
		}
		return pascalsTriangle;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> pascalsTriangle = new PascalsTriangle()
				.generate(1);
		System.out.println(pascalsTriangle);
	}

}
