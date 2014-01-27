package lzq.leetcode.initial.normal;

import java.util.ArrayList;

import lzq.leetcode.model.Interval;

public class InsertInterval {
	/**
	 * Given a set of non-overlapping intervals, insert a new interval into the
	 * intervals (merge if necessary).
	 * 
	 * You may assume that the intervals were initially sorted according to
	 * their start times.
	 * 
	 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
	 * [1,5],[6,9].
	 * 
	 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
	 * in as [1,2],[3,10],[12,16].
	 * 
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (null == intervals || intervals.isEmpty()) {
			ArrayList<Interval> newIntervals = new ArrayList<Interval>();
			if (null != newInterval) {
				newIntervals.add(newInterval);
			}
			return newIntervals;
		}
		int i;
		for (i = 0; i < intervals.size(); i++) {
			if (newInterval.start >= intervals.get(i).start
					&& newInterval.start <= intervals.get(i).end
					&& newInterval.end >= intervals.get(i).end) {
				intervals.get(i).end = newInterval.end;
				break;
			} else if (newInterval.end >= intervals.get(i).start
					&& newInterval.end <= intervals.get(i).end
					&& newInterval.start <= intervals.get(i).start) {
				intervals.get(i).start = newInterval.start;
				break;
			} else if (newInterval.start >= intervals.get(i).start
					&& newInterval.end <= intervals.get(i).end) {
				return intervals;
			} else if (newInterval.start <= intervals.get(i).start
					&& newInterval.end >= intervals.get(i).end) {
				intervals.get(i).start = newInterval.start;
				intervals.get(i).end = newInterval.end;
				break;
			} else if (newInterval.end < intervals.get(i).start) {
				intervals.add(i, newInterval);
				break;
			}
		}
		if (i >= intervals.size()) {
			intervals.add(newInterval);
			return intervals;
		}
		ArrayList<Interval> newIntervals = new ArrayList<Interval>();
		Interval first = intervals.get(0);
		for (i = 1; i < intervals.size(); i++) {
			if (null == first) {
				first = intervals.get(i);
			} else if (intervals.get(i).start >= first.start
					&& intervals.get(i).start <= first.end
					&& intervals.get(i).end >= first.end) {
				first.end = intervals.get(i).end;
			} else if (intervals.get(i).end >= first.start
					&& intervals.get(i).end <= first.end
					&& intervals.get(i).start <= first.start) {
				first.start = intervals.get(i).start;
			} else if (intervals.get(i).start >= first.start
					&& intervals.get(i).end <= first.end) {
				continue;
			} else if (intervals.get(i).start <= first.start
					&& intervals.get(i).end >= first.end) {
				first.start = intervals.get(i).start;
				first.end = intervals.get(i).end;
			} else {
				newIntervals.add(first);
				first = null;
				first = intervals.get(i);
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
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(8, 10);
		Interval i5 = new Interval(12, 16);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);
		Interval newInterval = new Interval(4, 9);

		System.out.println(new InsertInterval().insert(intervals, newInterval));
	}

}
