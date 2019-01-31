package lzq.leetcode.initial.normal;

/**
 * NumberofMatchingSubsequences
 *
 * @author luzheqi
 * @date 2018/3/8
 * @time 下午5:55
 */
public class NumberofMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {
        int sum = 0;
        int[] index = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            index[i] = 0;
        }

        boolean hasMatch = false;
        char[] cs = S.toCharArray();
        for (int m = 0; m < cs.length; m++) {
            char c = cs[m];
            if (!hasMatch && m > 0 && cs[m - 1] == c) {
                continue;
            }
            if (hasMatch) hasMatch = false;
            for (int i = 0; i < words.length; i++) {
                if (index[i] == -1) {
                    continue;
                }
                if (c == words[i].charAt(index[i])) {
                    index[i]++;
                    if (index[i] >= words[i].length()) {
                        sum++;
                        index[i] = -1;
                        hasMatch = true;
                    }
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        NumberofMatchingSubsequences n = new NumberofMatchingSubsequences();
        System.out.println(n.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
