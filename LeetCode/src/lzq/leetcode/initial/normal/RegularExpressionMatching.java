package lzq.leetcode.initial.normal;

import java.util.Arrays;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for(int j = 1; j <= p.length(); j++) {
            if(p.charAt(j - 1) == '*'){
                match[0][j] |= match[0][j - 2];
            }
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++){
                if (p.charAt(j - 1) != '*' && match(s, p, i, j)){
                    match[i][j] |= match[i - 1][j - 1];
                } else{
                    match[i][j] |= match[i][j - 2];
                    if(match(s, p, i, j - 1)){
                        match[i][j] |= match[i - 1][j];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }

    private boolean match(String s, String p, int i, int j) {
        if(p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch("ab", ".*"));
    }
}
