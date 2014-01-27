package lzq.leetcode.initial.normal;

import java.util.ArrayList;

import lzq.leetcode.model.Interval;

public class MergeIntervals {
	/**
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, Given [1,3],[2,6],[8,10],[15,18], return
	 * [1,6],[8,10],[15,18].
	 * 
	 * @param intervals
	 * @return
	 */
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (null == intervals || intervals.isEmpty()) {
			return new ArrayList<Interval>();
		}
		ArrayList<Interval> sorted = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			if (sorted.isEmpty()) {
				sorted.add(intervals.get(i));
			} else {
				int j;
				for (j = 0; j < sorted.size(); j++) {
					if (intervals.get(i).end < sorted.get(j).start) {
						sorted.add(j, intervals.get(i));
						break;
					} else if (intervals.get(i).start >= sorted.get(j).start
							&& intervals.get(i).start <= sorted.get(j).end
							&& intervals.get(i).end >= sorted.get(j).end) {
						sorted.get(j).end = intervals.get(i).end;
						break;
					} else if (intervals.get(i).end >= sorted.get(j).start
							&& intervals.get(i).end <= sorted.get(j).end
							&& intervals.get(i).start <= sorted.get(j).start) {
						sorted.get(j).start = intervals.get(i).start;
						break;
					} else if (intervals.get(i).start <= sorted.get(j).start
							&& intervals.get(i).end >= sorted.get(j).end) {
						sorted.get(j).start = intervals.get(i).start;
						sorted.get(j).end = intervals.get(i).end;
						break;
					} else if (intervals.get(i).start >= sorted.get(j).start
							&& intervals.get(i).end <= sorted.get(j).end) {
						break;
					}
				}
				if (j >= sorted.size()) {
					sorted.add(intervals.get(i));
				}
			}
		}
		ArrayList<Interval> newIntervals = new ArrayList<Interval>();
		Interval first = sorted.get(0);
		for (int i = 1; i < sorted.size(); i++) {
			if (null == first) {
				first = sorted.get(i);
			} else if (sorted.get(i).start >= first.start
					&& sorted.get(i).start <= first.end
					&& sorted.get(i).end >= first.end) {
				first.end = sorted.get(i).end;
			} else if (sorted.get(i).end >= first.start
					&& sorted.get(i).end <= first.end
					&& sorted.get(i).start <= first.start) {
				first.start = sorted.get(i).start;
			} else if (sorted.get(i).start >= first.start
					&& sorted.get(i).end <= first.end) {
				continue;
			} else if (sorted.get(i).start <= first.start
					&& sorted.get(i).end >= first.end) {
				first.start = sorted.get(i).start;
				first.end = sorted.get(i).end;
			} else {
				newIntervals.add(first);
				first = null;
				first = sorted.get(i);
			}
		}
		if (null != first) {
			newIntervals.add(first);
		}
		return newIntervals;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(2, 3);
		Interval i2 = new Interval(4, 5);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(8, 9);
		Interval i5 = new Interval(1, 10);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);

		System.out.println(new MergeIntervals().merge(intervals));
	}

}
