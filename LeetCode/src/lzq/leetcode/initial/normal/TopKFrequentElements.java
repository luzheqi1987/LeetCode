package lzq.leetcode.initial.normal;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (k >= nums.length) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int curSize = map.getOrDefault(num, 0);
            map.put(num, curSize + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.size - o1.size;
            }
        });
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new Node(e.getKey(), e.getValue()));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().num;
        }
        return res;
    }

    class Node {
        int num;
        int size;

        public Node(int num, int size) {
            this.num = num;
            this.size = size;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    public static void main(String[] args) {
        TopKFrequentElements tkfe = new TopKFrequentElements();
        System.out.println(Arrays.stream(tkfe.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).boxed().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
