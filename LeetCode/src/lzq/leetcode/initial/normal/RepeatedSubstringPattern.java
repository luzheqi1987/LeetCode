package lzq.leetcode.initial.normal;

public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String str) {
		int length = str.length();
		if (length <= 1) {
			return false;
		}

		for (int i = 1; i <= length / 2; i++) {
			if (length % i == 0) {
				String substring = str.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for(int j = 0;j < length / i; j++){
					sb.append(substring);
				}
				if(sb.toString().equals(str)){
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
		String str1 = "abab";
		String str2 = "aba";
		String str3 = "abcabcabcabc";
		
		System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(str1));
		System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(str2));
		System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(str3));
	}

}
