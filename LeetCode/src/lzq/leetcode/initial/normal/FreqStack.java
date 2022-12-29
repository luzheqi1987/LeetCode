package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqStack {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> freqMap = new HashMap<>();
    List<Integer> maxList = new ArrayList<>();
    Map<Integer, List<Integer>> maxMap = new HashMap<>();
    int currentMax = Integer.MIN_VALUE;

    public FreqStack() {

    }

    public void push(int val) {
        list.add(val);
        int preFreq = freqMap.getOrDefault(val, 0);
        int currFreq = preFreq + 1;

        if (preFreq != 0) {
            List<Integer> preNums = maxMap.get(preFreq);
            preNums.remove(new Integer(val));
            if (preNums.isEmpty()) {
                maxMap.remove(preFreq);
            }else {
                maxMap.put(preFreq, preNums);
            }
        }

        if (currFreq > currentMax) {
            currentMax = currFreq;
            List<Integer> nums = new ArrayList<>();
            nums.add(val);
            maxMap.put(currentMax, nums);
            maxList.add(currentMax);
        } else {
            List<Integer> nums = maxMap.getOrDefault(currFreq, new ArrayList<>());
            nums.add(val);
            maxMap.put(currFreq, nums);
        }
        freqMap.put(val, currFreq);
    }

    public int pop() {
        int result = -1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if(freqMap.get(list.get(i)) == currentMax) {
                result = list.get(i);
                list.remove(i);
                break;
            }
        }
        int currentFreq = currentMax - 1;
        List<Integer> preNums = maxMap.get(currentMax);
        preNums.remove(new Integer(result));
        if (preNums.isEmpty()) {
            maxMap.remove(currentMax);
            currentMax = maxList.get(maxList.size() - 2);
            maxList.remove(maxList.size() - 1);
        } else {
            maxMap.put(currentMax, preNums);
        }

        List<Integer> currNums = maxMap.getOrDefault(currentFreq, new ArrayList<>());
        currNums.add(result);
        maxMap.put(currentFreq, currNums);
        freqMap.put(result, currentFreq);
        return result;
    }

    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}
