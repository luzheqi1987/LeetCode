package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * IntervalListIntersections
 *
 * @author luzheqi
 * @date 2019-02-03
 * @time 16:09
 */
public class IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            Interval a = A[i];
            Interval b = B[j];

            if (a.start <= b.start) {
                if(a.end >= b.start) {
                    if (b.end >= a.end) {
                        result.add(new Interval(b.start, a.end));
                        i++;
                    } else {
                        result.add(new Interval(b.start, b.end));
                        j++;
                    }
                }else{
                    i++;
                }
            } else if (b.start <= a.start ) {
                if(b.end >= a.start) {
                    if (a.end >= b.end) {
                        result.add(new Interval(a.start, b.end));
                        j++;
                    } else {
                        result.add(new Interval(a.start, a.end));
                        i++;
                    }
                }else{
                    j++;
                }
            }
        }
        Interval[] intervals = new Interval[result.size()];
        return result.toArray(intervals);
    }

    public static void main(String[] args) {
        IntervalListIntersections i = new IntervalListIntersections();
        Interval[] A = new Interval[]{new Interval(0, 2), new Interval(5, 10), new Interval(13, 23), new Interval(24, 25)};
        Interval[] B = new Interval[]{new Interval(1, 5), new Interval(8, 12), new Interval(15, 24), new Interval(25, 26)};
        Interval[] result = i.intervalIntersection(A, B);
        for (Interval interval : result) {
            System.out.println(interval.start + "\t" + interval.end);
        }
    }


    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
