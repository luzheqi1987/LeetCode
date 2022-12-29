package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater1 {
    public int maxArea(int[] height) {
        int max = 0;
        if(height.length <= 1) {
            return max;
        }
        List<Integer> stack = new ArrayList<>();
        for(int i = 0; i < height.length; i++){
            if(stack.isEmpty()) {
                stack.add(i);
                continue;
            }
            if(height[stack.get(stack.size() - 1)] < height[i]){
                stack.add(i);
                continue;
            }

            for(int j = stack.size() - 1; j >=0; j--) {
                if(height[stack.get(j)] >= height[i]){
                    int last = stack.get(j);
                    int curr = (i - last) * height[i];
                    max = Math.max(max, curr);
                }
            }
        }
        stack = new ArrayList<>();
        for(int i = height.length - 1; i >= 0; i--){
            if(stack.isEmpty()) {
                stack.add(i);
                continue;
            }

            if(height[stack.get(stack.size() - 1)] < height[i]){
                stack.add(i);
                continue;
            }

            for(int j = stack.size() - 1; j >=0; j--){
                if(height[stack.get(j)] >= height[i]){
                    int last = stack.get(j);
                    int curr = (last - i) * height[i];
                    max = Math.max(max, curr);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater1 s = new ContainerWithMostWater1();
        System.out.println(s.maxArea(new int[]{1,2}));
    }
}
