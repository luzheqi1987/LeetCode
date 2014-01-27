package lzq.leetcode.better.normal;

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
		int position = search(intervals, newInterval);
		if (intervals.get(position).end < newInterval.start) {
			position++;
			if (position < intervals.size()) {
				newInterval.start = Math.min(newInterval.start,
						intervals.get(position).start);
			}
		} else if (intervals.get(position).start < newInterval.start) {
			newInterval.start = intervals.get(position).start;
		} else if (position >= 1
				&& intervals.get(position - 1).start < newInterval.start
				&& intervals.get(position - 1).end >= newInterval.start) {
			position--;
			newInterval.start = Math.min(newInterval.start,
					intervals.get(position).start);
		}
		for (int i = position; i < intervals.size(); i++) {
			if (intervals.get(i).start <= newInterval.end) {
				newInterval.end = Math.max(intervals.get(i).end,
						newInterval.end);
				intervals.remove(position);
				--i;
			} else if (intervals.get(i).start > newInterval.end) {
				break;
			}
		}
		intervals.add(position, newInterval);
		return intervals;
	}

	int search(ArrayList<Interval> intervals, Interval newInterval) {
		int start = 0;
		int end = intervals.size() - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (intervals.get(mid).start > newInterval.start) {
				end = mid - 1;
			} else if (intervals.get(mid).start < newInterval.start) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return start;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(0, 5);
		Interval i2 = new Interval(9, 12);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(8, 10);
		Interval i5 = new Interval(12, 16);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		// intervals.add(i3);
		// intervals.add(i4);
		// intervals.add(i5);
		Interval newInterval = new Interval(7, 16);

		System.out.println(new InsertInterval().insert(intervals, newInterval));
	}

}
