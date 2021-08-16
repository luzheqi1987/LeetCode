package lzq.leetcode.initial.normal;

import java.util.HashSet;
import java.util.Set;

public class LargestNumberAfterMutatingSubstring {

    public String maximumNumber(String num, int[] change) {
        char[] numChars = num.toCharArray();
        boolean started = false;
        for (int pos = 0; pos <= num.length() - 1; pos++) {
            if (change[numChars[pos] - '0'] > numChars[pos] - '0' || (
                    started && change[numChars[pos] - '0'] == numChars[pos] - '0'
            )) {
                numChars[pos] = (char) (change[numChars[pos] - '0'] + '0');
                started = true;
            } else if (started) {
                break;
            }
        }
        return new String(numChars);
    }

    public static void main(String[] args) {
        LargestNumberAfterMutatingSubstring a = new LargestNumberAfterMutatingSubstring();
        System.out.println(a.maximumNumber("334111", new int[]{0, 9, 2, 3, 3, 2, 5, 5, 5, 5}));
    }
}
