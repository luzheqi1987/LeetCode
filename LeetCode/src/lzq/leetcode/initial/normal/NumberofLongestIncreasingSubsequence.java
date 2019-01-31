package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NumberofLongestIncreasingSubsequence
 *
 * @author luzheqi
 * @date 2017/10/16
 * @time 上午11:54
 */
public class NumberofLongestIncreasingSubsequence {
//    public int findNumberOfLIS(int[] nums) {
//        if (null == nums || nums.length <= 0) {
//            return 0;
//        }
//        Map<Integer, List<NumberPojo>> levelMap = new HashMap<>();
//        Map<NumberPojo, Integer> preLength = new HashMap<>();
//        List<NumberPojo> oneLevelNums = new ArrayList<>();
//        oneLevelNums.add(new NumberPojo(0, nums[0]));
//        levelMap.put(1, oneLevelNums);
//        int maxLevel = 1;
//        int maxNumber = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int tmpLevel = 1;
//            for (; tmpLevel <= maxLevel; tmpLevel++) {
//                List<NumberPojo> tmpNums = levelMap.get(tmpLevel);
//                int tmpIndex = 0;
//                for (; tmpIndex < tmpNums.size(); tmpIndex++) {
//                    if (nums[i] > tmpNums.get(tmpIndex).value) {
//                        break;
//                    }
//                }
//                if (tmpIndex == tmpNums.size()) {
//                    break;
//                }
//            }
//            if (tmpLevel <= maxLevel) {
//                List<NumberPojo> tmpNums = levelMap.get(tmpLevel);
//                NumberPojo pojo = new NumberPojo(i, nums[i]);
//                tmpNums.add(pojo);
//                levelMap.put(tmpLevel, tmpNums);
//                if (tmpLevel == maxLevel) {
//                    List<NumberPojo> preLevelNums = levelMap.get(tmpLevel - 1);
//                    if (null == preLevelNums || preLevelNums.isEmpty()) {
//                        maxNumber++;
//                    } else {
//                        maxNumber += calcNumber(pojo, levelMap, tmpLevel - 1);
//                    }
//                }
//            } else {
//                maxLevel = tmpLevel;
//                List<NumberPojo> tmpNums = new ArrayList<>();
//                NumberPojo pojo = new NumberPojo(i, nums[i]);
//                tmpNums.add(pojo);
//                levelMap.put(tmpLevel, tmpNums);
//                maxNumber = calcNumber(pojo, levelMap, tmpLevel - 1);
//            }
//        }
//        return maxNumber;
//    }
//
//    public int calcNumber(NumberPojo num, Map<Integer, List<NumberPojo>> levelMap, int level){
//        List<NumberPojo> preLevelNumbers = levelMap.get(level);
//        if(preLevelNumbers == null || preLevelNumbers.isEmpty()){
//            return 1;
//        }
//        int sum = 0;
//        for(NumberPojo preLevelNumber : preLevelNumbers){
//            if(num.value > preLevelNumber.value && num.pos > preLevelNumber.pos){
//                sum += calcNumber(preLevelNumber, levelMap, level-1);
//            }
//        }
//        return sum;
//    }
//
//    class NumberPojo{
//        public int pos;
//        public int value;
//
//        public NumberPojo(){}
//
//        public NumberPojo(int pos, int value){
//            this.pos = pos;
//            this.value = value;
//        }
//    }

    public int findNumberOfLIS(int[] nums) {
        int numLength = nums.length;
        int maxNumber = 0;
        int maxLength = 0;
        int[] lengths =  new int[numLength];
        int[] numbers = new int[numLength];
        for(int i = 0; i<numLength; i++){
            lengths[i] = numbers[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(lengths[i] == lengths[j] + 1)numbers[i] += numbers[j];
                    if(lengths[i] < lengths[j] + 1){
                        lengths[i] = lengths[j] + 1;
                        numbers[i] = numbers[j];
                    }
                }
            }
            if(maxLength == lengths[i]){
                maxNumber += numbers[i];
            }
            if(maxLength < lengths[i]){
                maxLength = lengths[i];
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        NumberofLongestIncreasingSubsequence subsequence = new NumberofLongestIncreasingSubsequence();
        int nums[] = new int[]{1,2,3,1,2,3,1,2,3};
        System.out.println(subsequence.findNumberOfLIS(nums));
    }
}
