package lzq.leetcode.initial.normal;

public class TwoKeysKeyboard {

    public int minSteps(int n) {
        int steps = 0;
        int tmp = n;
        int divided = n / 2;
        while(divided > 1){
            if(tmp % divided == 0){
                steps += tmp / divided;
                tmp = divided;
                divided = divided / 2;
            }else{
                divided--;
            }
        }
        steps += tmp > 1 ? tmp : 0;
        return steps;
    }

    public static void main(String[] args) {
        System.out.println((new TwoKeysKeyboard()).minSteps(1));
        System.out.println((new TwoKeysKeyboard()).minSteps(2));
        System.out.println((new TwoKeysKeyboard()).minSteps(3));
        System.out.println((new TwoKeysKeyboard()).minSteps(4));
        System.out.println((new TwoKeysKeyboard()).minSteps(5));
        System.out.println((new TwoKeysKeyboard()).minSteps(6));
        System.out.println((new TwoKeysKeyboard()).minSteps(7));
        System.out.println((new TwoKeysKeyboard()).minSteps(8));
        System.out.println((new TwoKeysKeyboard()).minSteps(9));
        System.out.println((new TwoKeysKeyboard()).minSteps(10));
        System.out.println((new TwoKeysKeyboard()).minSteps(11));
        System.out.println((new TwoKeysKeyboard()).minSteps(12));
    }
}
