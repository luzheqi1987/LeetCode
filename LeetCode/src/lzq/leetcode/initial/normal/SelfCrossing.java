package lzq.leetcode.initial.normal;

import com.sun.tools.javac.util.StringUtils;

/**
 * SelfCrossing
 *
 * @author luzheqi
 * @date 2018/9/25
 * @time 下午2:53
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        int n = x.length;
        if (n <= 3) {
            return false;
        }

        boolean f = true;

        if (x[2] <= x[0]) {
            f = false;
        }

        for (int i = 3; i < n; i++) {
            if (!f) {
                if (x[i] >= x[i - 2]) {
                    return true;
                }
            } else {

                if (x[i] <= x[i - 2]) {
                    f = false;
                    if (x[i - 2] - x[i - 4] <= x[i]) {
                        x[i - 1] = x[i - 1] - x[i - 3];
                    }
                }
            }
        }
        return false;
    }

    private String calcId(String expName){
        String[] parts = expName.split("-");
        if(parts == null || parts.length != 2){
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(parts[0].substring(parts[0].indexOf("s") + 1));
        sb.append(String.format("%04d", Integer.valueOf(parts[1].substring(parts[1].indexOf("l") + 1))));

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new SelfCrossing().calcId("s1-l1"));
        System.out.println(new SelfCrossing().isSelfCrossing(new int[]{2, 1, 1, 2}));
        System.out.println(new SelfCrossing().isSelfCrossing(new int[]{1, 2, 3, 4}));
        System.out.println(new SelfCrossing().isSelfCrossing(new int[]{1, 1, 1, 1}));
    }
}
