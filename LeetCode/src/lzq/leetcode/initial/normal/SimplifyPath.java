package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
	/**
	 * Given an absolute path for a file (Unix-style), simplify it.
	 * 
	 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", =>
	 * "/c"
	 * 
	 * @param path
	 * @return
	 */
	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == path || "".equals(path) || !path.startsWith("/")) {
			return "";
		}

		List<String> pathList = new ArrayList<String>();
		char[] paths = path.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < paths.length; i++) {
			if (paths[i] == '/') {
				if (!sb.toString().equals("")) {
					if (!sb.toString().equals(".")
							&& !sb.toString().equals("..")) {
						pathList.add(sb.toString());
					} else if (sb.toString().equals("..")) {
						if (!pathList.isEmpty()) {
							pathList.remove(pathList.size() - 1);
						}
					}
					sb = null;
					sb = new StringBuilder();
				}
			} else {
				sb.append(paths[i]);
			}
		}
		if (!sb.toString().equals("")) {
			if (!sb.toString().equals(".") && !sb.toString().equals("..")) {
				pathList.add(sb.toString());
			} else if (sb.toString().equals("..")) {
				if (!pathList.isEmpty()) {
					pathList.remove(pathList.size() - 1);
				}
			}
		}
		if (pathList.isEmpty()) {
			return "/";
		} else {
			sb = null;
			sb = new StringBuilder();
			for (String s : pathList) {
				sb.append("/" + s);
			}
			return sb.toString();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/..";
		String pa = new SimplifyPath().simplifyPath(path);
		System.out.println(pa);
	}

}
