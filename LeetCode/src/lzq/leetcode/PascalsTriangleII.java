package lzq.leetcode;

import java.util.ArrayList;

public class PascalsTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (rowIndex < 0) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			ArrayList<Integer> tmpRow = new ArrayList<Integer>();
			tmpRow.add(1);
			for (int j = 1; j <= i; j++) {
				if (j == i) {
					tmpRow.add(1);
				} else {
					tmpRow.add(row.get(j) + row.get(j - 1));
				}
			}
			row.clear();
			row.addAll(tmpRow);
		}
		return row;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> layer = new PascalsTriangleII().getRow(6);
		System.out.println(layer);

	}

}
