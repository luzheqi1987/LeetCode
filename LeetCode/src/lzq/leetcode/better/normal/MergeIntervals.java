package lzq.leetcode.better.normal;

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

		ArrayList<Interval> newIntervals = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			insert(newIntervals, interval);
		}
		return newIntervals;
	}

	void insert(ArrayList<Interval> intervals, Interval newInterval) {
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return;
		}

		int position = search(intervals, newInterval);
		if (intervals.get(position).end < newInterval.start) {
			position++;
		} else if ((position >= 1)
				&& (intervals.get(position - 1).start < newInterval.start)
				&& (intervals.get(position - 1).end >= newInterval.start)) {
			position--;
		}
		if (position < intervals.size()) {
			newInterval.start = Math.min(newInterval.start,
					intervals.get(position).start);
		}
		for (int i = position; i < intervals.size(); i++) {
			if (intervals.get(i).start <= newInterval.end) {
				newInterval.end = Math.max(newInterval.end,
						intervals.get(i).end);
				intervals.remove(i);
				i--;
			} else {
				break;
			}
		}
		intervals.add(position, newInterval);
	}

	int search(ArrayList<Interval> intervals, Interval interval) {
		int start = 0;
		int end = intervals.size() - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (intervals.get(mid).start < interval.start) {
				start = mid + 1;
			} else if (intervals.get(mid).start > interval.start) {
				end = mid - 1;
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
