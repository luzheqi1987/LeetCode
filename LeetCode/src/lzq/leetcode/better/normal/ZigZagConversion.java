package lzq.leetcode.better.normal;


public class ZigZagConversion {
	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	 * number of rows like this: (you may want to display this pattern in a
	 * fixed font for better legibility)
	 * 
	 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion given a
	 * number of rows:
	 * 
	 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3)
	 * should return "PAHNAPLSIIGYIR".
	 * 
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (nRows == 1) {
			return s;
		}

		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < nRows; ++i) {
			int curOriginalIdx = i;
			int k = 0;
			while (curOriginalIdx < s.length()) {
				int nextOriginalIdx;
				if (k % 2 == 0)
					nextOriginalIdx = curOriginalIdx + 2 * (nRows - 1 - i);
				else
					nextOriginalIdx = curOriginalIdx + 2 * (i);
				if (nextOriginalIdx != curOriginalIdx)
					result.append(s.charAt(curOriginalIdx));
				curOriginalIdx = nextOriginalIdx;
				k++;
			}
		}

		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
	}

}
