package lzq.leetcode.better.dp;

public class LongestPalindromicSubstring {
	/**
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 * 
	 * @param s
	 * @return
	 */
	/**
	 * http://blog.csdn.net/hopeztm/article/details/7932245
	 * http://www.leetcode.com/2011/11/longest-palindromic-substring-part-ii.
	 * html 不过原文的陈述仔细研究了一下，有一些地方让人着实费解，所以自己决定重写一遍。
	 * 
	 * 这里描述了一个叫Manacher’s Algorithm的算法。
	 * 
	 * 算法首先将输入字符串S， 转换成一个特殊字符串T，转换的原则就是将S的开头结尾以及每两个相邻的字符之间加入一个特殊的字符，例如#
	 * 
	 * 例如: S = “abaaba”, T = “#a#b#a#a#b#a#”.
	 * 
	 * 为了找到最长的回文字串，例如我们当前考虑以Ti为回文串中间的元素，如果要找到最长回文字串，我们要从当前的Ti扩展使得 Ti-d … Ti+d
	 * 组成最长回文字串. 这里 d 其实和 以Ti为中心的回文串长度是一样的. 进一步解释就是说，因为我们这里插入了 #
	 * 符号，对于一个长度为偶数的回文串
	 * ，他应该是以#做为中心的，然后向两边扩，对于长度是奇数的回文串，它应该是以一个普通字符作为中心的。通过使用#，我们将无论是奇数还是偶数的回文串
	 * ，都变成了一个以Ti为中心，d为半径两个方向扩展的问题。并且d就是回文串的长度。
	 * 
	 * 例如 #a#b#a#, P = 0103010, 对于b而言P的值是3，是最左边的#，也是延伸的最左边。这个值和当前的回文串是一致的。
	 * 
	 * 如果我们求出所有的P值，那么显然我们要的回文串，就是以最大P值为中心的回文串。
	 * 
	 * T = # a # b # a # a # b # a # P = 0 1 0 3 0 1 6 1 0 3 0 1 0 例如上面的例子，最长回文是
	 * “abaaba”, P6 = 6.
	 * 
	 * 根据观察发现，如果我们在一个位置例如
	 * abaaba的中间位置，用一个竖线分开，两侧的P值是对称的。当然这个性质不是在任何时候都会成立，接下来就是分析如何利用这个性质
	 * ，使得我们可以少算很多P的值。
	 * 
	 * 下面的例子 S = “babcbabcbaccba” 存在更多的折叠回文字串。
	 * 
	 * 
	 * C表示当前的回文中心，L和R处的线表示以C为中心可以到达的最左和最右位置，如果知道这些，我们如何可以更好的计算C后面的P[i].
	 * 假设我们当前计算的是 i = 13, 根据对称性，我们知道对称的那个下标 i' = 9.
	 * 
	 * 根据C对称的原则，我们很容易得到如下数据 P[ 12 ] = P[ 10 ] = 0, P[ 13 ] = P[ 9 ] = 1, P[ 14 ]
	 * = P[ 8 ] = 0).
	 * 
	 * Now we are at index i = 15, and its mirrored index around C is i’ = 7. Is
	 * P[ 15 ] = P[ 7 ] = 7? 当时当i = 15的时候，却只能得到回文 “a#b#c#b#a”, 长度是5， 而对称 i ' = 7
	 * 的长度是7.
	 * 
	 * 
	 * 如上图所示，如果以 i, i' 为中心，画出对称的区域如图，其中以i‘ = 7 对称的区域是 实心绿色 + 虚绿色 和
	 * 左侧，虚绿色表示当前的对称长度已经超过之前的对称中心C。而之前的P对称性质成立的原因是 i 右侧剩余的长度 R - i 正好比 以 i‘
	 * 为中心的回文小。 这个性质可以这样归纳，对于 i 而言，因为根据C对称的最右是R，所以i的右侧有 R - i 个元素是保证是 i' 左侧是对称的。
	 * 而对于 i' 而言他的P值，也就是回文串的长度，可能会比 R-i 要大。 如果大于 R - i, 对于i而言，我们只能暂时的先填写 P[i] =
	 * R - i, 然后依据回文的属性来扩充P[i] 的值； 如果P[i '] 小于R-i，那么说明在对称区间C内，i的回文串长度和i'
	 * 是一样长的。例如我们的例子中 i = 15, 因为R = 20，所以i右侧 在对称区间剩余的是 R - 15 = 5, 而 i’ = 7
	 * 的长度是7. 说明 i' 的回文长度已经超出对称区间。我们只能使得P[i] 赋值为5， 然后尝试扩充P[i]. if P[ i' ] ≤ R –
	 * i, then P[ i ] ← P[ i' ] else P[ i ] ≥R – i. (这里下一步操作是扩充 P[ i ]. 扩充P[i]
	 * 之后，我们还要做一件事情是更新 R 和 C， 如果当前对称中心的最右延伸大于R，我们就更新C和R。在迭代的过程中，我们试探i的时候，如果P[i']
	 * <= R - i, 那么只要做一件事情。 如果不成立我们对当前P[i] 做扩展，因为最大长度是n，扩展最多就做n次，所以最多做2*n。
	 * 所以最后算法复杂度是 O(n)
	 * 
	 * 或许贴上代码更容易一些。直接使用大神的代码了，虽然自己也实现了，不过是理解大神的思路实现的。
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == s || s.length() <= 0) {
			return "";
		} else if (s.length() == 1) {
			return s;
		}
		String parperedString = preProcess(s);
		int n = parperedString.length();
		int[] p = new int[n];
		int C = 0;
		int R = 0;
		char[] T = parperedString.toCharArray();

		for (int i = 1; i < n - 1; i++) {
			int i_mirror = 2 * C - i;
			p[i] = (R > i) ? Math.min(R - i, p[i_mirror]) : 0;
			while (T[i + 1 + p[i]] == T[i - 1 - p[i]]) {
				p[i]++;
			}
			if (p[i] + i > R) {
				C = i;
				R = p[i] + i;
			}
		}

		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n - 1; i++) {
			if (p[i] > maxLen) {
				maxLen = p[i];
				centerIndex = i;
			}
		}
		int start = (centerIndex - 1 - maxLen) / 2;
		return s.substring(start, start + maxLen);
	}

	String preProcess(String s) {
		int n = s.length();
		if (n == 0)
			return "^$";
		String ret = "^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.substring(i, i + 1);

		ret += "#$";
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestPalindromicSubstring()
				.longestPalindrome("abb"));
		System.out
				.println(new LongestPalindromicSubstring().preProcess("asdf"));
	}

}
