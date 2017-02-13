package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

import lzq.leetcode.model.TreeNode;

public class MostFrequentSubtreeSum {
	
    public int[] findFrequentTreeSum(TreeNode root) {
    	if(root == null){
    		return new int[]{};
    	}
    	
    	Map<Integer, Integer> sumMap = new HashMap<>();
    	
    	int rootSum = calcSubTreeSum(sumMap, root);
    	
		int maxSum = Integer.MIN_VALUE;
		int resultNumber = 0;
		for(int num : sumMap.keySet()){
			if(sumMap.get(num) > maxSum){
				maxSum = sumMap.get(num);
				resultNumber = 1;
			}else if(sumMap.get(num) == maxSum){
				resultNumber ++;
			}
		}
		
		int[] results = new int[resultNumber];
		int i = 0;
		for(int num : sumMap.keySet()){
			if(sumMap.get(num) == maxSum){
				results[i++] = num;
			}
		}
		
		return results;
    }
    
    private int calcSubTreeSum(Map<Integer, Integer> sumMap, TreeNode root){
    	if(root.left == null && root.right == null){
    		sumMap.put(root.val, sumMap.getOrDefault(root.val, 0) + 1);
    		return root.val;
    	}
    	int left = 0;
    	int right = 0;
    	if(root.left != null){
    		left = calcSubTreeSum(sumMap, root.left);
    	}

    	if(root.right != null){
    		right = calcSubTreeSum(sumMap, root.right);
    	}
    	
    	int curSum = root.val + left + right;
    	sumMap.put(curSum, sumMap.getOrDefault(curSum, 0) + 1);
    	
    	return curSum;
    }
    
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(-5);
		
		node1.left = node2;
		node1.right = node3;
		
		MostFrequentSubtreeSum mostFrequentSubtreeSum = new MostFrequentSubtreeSum();
		int[] results = mostFrequentSubtreeSum.findFrequentTreeSum(node1);
		
		for(int result : results ){
			System.out.print(result + "    ");
		}
		System.out.println();

	}

}
