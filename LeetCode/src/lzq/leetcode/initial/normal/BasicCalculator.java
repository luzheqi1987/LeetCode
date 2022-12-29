package lzq.leetcode.initial.normal;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i += getSpaceNumber(s, i);
            } else if (s.charAt(i) == '(') {
                stack.push("(");
                i++;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                String number = getNumber(s, i);
                if(stack.isEmpty()) {
                    stack.push(number);
                }else {
                    if (stack.peek().equals("(")) {
                        stack.push(number);
                    } else {
                        String lastOp = stack.pop();
                        if (lastOp.equals("-") && (stack.isEmpty() || stack.peek().equals("("))) {
                            stack.push(String.valueOf(-1 * Integer.parseInt(number)));
                        } else {

                            int lastNumber = Integer.parseInt(stack.pop());
                            if (lastOp.equals("-")) {
                                stack.push(String.valueOf(lastNumber - Integer.parseInt(number)));
                            } else {
                                stack.push(String.valueOf(lastNumber + Integer.parseInt(number)));
                            }
                        }
                    }
                }
                i += number.length();
            } else if (s.charAt(i) == '+') {
                stack.push("+");
                i++;
            }else if (s.charAt(i) == '-') {
                stack.push("-");
                i++;
            }else if (s.charAt(i) == ')') {
                String number = stack.pop();
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(number);
                } else {
                    String lastOp = stack.pop();
                    if(lastOp.equals("-") && (stack.isEmpty() || stack.peek().equals("("))) {
                        stack.push(String.valueOf(-1 * Integer.parseInt(number)));
                    } else {
                        if (!stack.peek().equals("(")) {
                            int lastNumber = Integer.parseInt(stack.pop());
                            if(lastOp.equals("-")){
                                stack.push(String.valueOf(lastNumber - Integer.parseInt(number)));
                            }else{
                                stack.push(String.valueOf(lastNumber + Integer.parseInt(number)));
                            }
                        } else {
                            stack.push(number);
                        }
                    }
                }
                i++;
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private int getSpaceNumber(String s, int index) {
        int i = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            i++;
            index++;
        }
        return i;
    }
    private String getNumber(String s, int index) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            sb.append(s.charAt(index++));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
