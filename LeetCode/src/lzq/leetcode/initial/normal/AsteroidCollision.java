package lzq.leetcode.initial.normal;

import java.util.*;

/**
 * AsteroidCollision
 *
 * @author luzheqi
 * @date 2017/11/27
 * @time 下午5:54
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (null == asteroids) {
            return null;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < asteroids.length && asteroids[i] < 0) {
            stack.push(asteroids[i++]);
        }
        for (; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                boolean beated = false;
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (top > 0 && top < Math.abs(asteroids[i])) {
                        stack.pop();
                    } else if (top > 0 && top == Math.abs(asteroids[i])) {
                        stack.pop();
                        beated = true;
                        break;
                    } else if (top > 0 && top > Math.abs(asteroids[i])) {
                        beated = true;
                        break;
                    } else {
                        break;
                    }
                }
                if (!beated) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int j = 0; j < result.length; j++) {
            result[result.length - j - 1] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        //ac.printIntArray(ac.asteroidCollision(new int[]{5, 10, -5}));
        //ac.printIntArray(ac.asteroidCollision(new int[]{8, -8}));
        //ac.printIntArray(ac.asteroidCollision(new int[]{10, 2, -5}));
        //ac.printIntArray(ac.asteroidCollision(new int[]{-2, -1, 1, 2}));
        ac.printIntArray(ac.asteroidCollision(new int[]{-2, -2, 1, -2}));
    }

    private void printIntArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
