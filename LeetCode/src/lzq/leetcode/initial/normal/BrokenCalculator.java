package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BrokenCalculator
 *
 * @author luzheqi
 * @date 2019-02-11
 * @time 17:01
 */
public class BrokenCalculator {
    Set<Integer> cache = new HashSet<>();

    public int brokenCalc1(int X, int Y) {
        if (X == Y) {
            return 0;
        }
        List<Integer> currentList = new ArrayList<>();
        currentList.add(X);
        int step = 0;
        int maxStep = 0;
        int x = X;
        while (x < Y) {
            maxStep++;
            x = x * 2;
        }
        maxStep += x - Y;

        while (step < maxStep && !currentList.isEmpty() && !currentList.contains(Y)) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : currentList) {
                if(!cache.contains(i)) {
                    if (i > 1) {
                        tmp.add(i - 1);

                    }
                    if (i < Y && !cache.contains(i)) {
                        int doubleI = i * 2;
                        tmp.add(doubleI);
                        if (doubleI > Y && doubleI - Y + step + 1 < maxStep) {
                            maxStep = doubleI - Y + step + 1;
                        }

                    }
                    int y = i;
                    int tempMax = step;
                    while (y < Y) {
                        tempMax++;
                        y = y * 2;
                    }
                    if(tempMax + y - Y < maxStep){
                        maxStep = tempMax + y - Y;
                    }
                    cache.add(i);
                }
            }
            step++;
            currentList.clear();
            currentList.addAll(tmp);
        }
        return step;
    }

    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        return res + X - Y;
    }

    public static void main(String[] args) {
        BrokenCalculator bc = new BrokenCalculator();
        System.out.println(bc.brokenCalc(1, 10000000));
        System.out.println(bc.brokenCalc1(1, 10000000));
    }
}
