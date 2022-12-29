package lzq.leetcode.initial.normal;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> strs = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                String number = getNumber(s, i);
                strs.push(number);
                i += number.length();
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                StringBuilder string = new StringBuilder(getString(s, i));
                i += string.length();
                while(!strs.isEmpty() && !strs.peek().equals("[")){
                    string.insert(0, strs.pop());
                }
                strs.push(string.toString());
            } else if (s.charAt(i) == '[') {
                strs.push(String.valueOf(s.charAt(i)));
                i++;
            } else if (s.charAt(i) == ']') {
                String lastString = strs.pop();
                strs.pop();
                int number = Integer.parseInt(strs.pop());
                StringBuilder newString = new StringBuilder();
                for (int j = 0; j < number; j++) {
                    newString.append(lastString);
                }
                while(!strs.isEmpty() && !strs.peek().equals("[")){
                    newString.insert(0, strs.pop());
                }
                strs.push(newString.toString());
                i++;
            }
        }
        StringBuilder result = new StringBuilder();
        while (!strs.isEmpty()) {
            result.insert(0, strs.pop());
        }
        return result.toString();
    }

    private String getNumber(String s, int index) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            sb.append(s.charAt(index));
            index++;
        }
        return sb.toString();
    }

    private String getString(String s, int index) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length() && s.charAt(index) >= 'a' && s.charAt(index) <= 'z') {
            sb.append(s.charAt(index));
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString("2[2[y]pq4[2[jk]e1[f]]]"));
    }
}
