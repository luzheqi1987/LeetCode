package lzq.leetcode.initial.normal;

import java.util.*;

/**
 * FrogJump
 *
 * @author luzheqi
 * @date 2018/9/25
 * @time 上午11:36
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length < 2) {
            return false;
        } else if (stones[0] != 0 || stones[1] != 1) {
            return false;
        }
        List<Integer> stoneList = new ArrayList<>();
        Arrays.stream(stones).forEach(t -> stoneList.add(t));
        Map<Integer, Set<Integer>> steps = new HashMap<>();
        Set<Integer> firstStone = new HashSet<>();
        firstStone.add(1);
        firstStone.add(2);
        steps.put(1, firstStone);
        for (int stone : stones) {
            if (stone == 0) {
                continue;
            } else {
                int now = stone;
                Set<Integer> nextSteps = steps.get(now);
                if (null == nextSteps || nextSteps.isEmpty()) {
                    continue;
                }
                for (int nextStep : nextSteps) {
                    if (stoneList.contains(now + nextStep)) {
                        int targetStone = now + nextStep;
                        Set<Integer> tmpStep = steps.get(targetStone);
                        if (null == tmpStep) {
                            tmpStep = new HashSet<>();
                        }
                        if(nextStep - 1 > 0){
                            tmpStep.add(nextStep - 1);
                        }
                        tmpStep.add(nextStep);
                        tmpStep.add(nextStep + 1);

                        steps.put(targetStone, tmpStep);
                        if(targetStone == stones[stones.length - 1]){
                            return true;
                        }
                    }
                }
            }
        }
        Set<Integer> lastStone = steps.get(stones[stones.length - 1]);
        return lastStone != null && !lastStone.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new FrogJump().canCross(new int[]{0,1,3,6,10,15,16,21}));
    }
}
