package lzq.leetcode.initial.dfs;

import java.util.ArrayList;

public class RestoreIPAddresses {
	/**
	 * Given a string containing only digits, restore it by returning all
	 * possible valid IP address combinations.
	 * 
	 * For example: Given "25525511135",
	 * 
	 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 * 
	 * @param s
	 * @return
	 */
	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == s) {
			return new ArrayList<String>();
		} else if (s.length() <= 3) {
			return new ArrayList<String>();
		}
		return dfs(s, 0, 0);

	}

	ArrayList<String> dfs(String s, int start, int th) {
		if (th < 3 && start >= s.length() - 3 + th) {
			return null;
		} else if (th == 3 && start < s.length() - 3) {
			return null;
		} else if (th == 3 && start >= s.length() - 3) {
			if (Integer.valueOf(s.substring(start)) > 255
					|| (s.substring(start).length() > 1 && s.substring(start)
							.startsWith("0"))) {
				return null;
			}
			ArrayList<String> strings = new ArrayList<String>();
			strings.add(s.substring(start));
			return strings;
		}
		ArrayList<String> news = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			if (start + i < s.length()) {
				String tmp = s.substring(start, start + i);
				if (Integer.valueOf(tmp) > 255
						|| (tmp.length() > 1 && tmp.startsWith("0"))) {
					continue;
				}
				ArrayList<String> strs = dfs(s, start + i, th + 1);
				if (null != strs) {
					for (String str : strs) {
						news.add(tmp + "." + str);
					}
				}
			}
		}
		return news;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "010010";
		ArrayList<String> news = new RestoreIPAddresses().restoreIpAddresses(s);

		System.out.println(news);
	}

}
