package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

import lzq.leetcode.model.Point;

public class MaxPointsonaLine {
	/**
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 * 
	 * @param points
	 * @return
	 */
	public int maxPoints(Point[] points) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

		Map<Float, Integer> kmap = new HashMap<Float, Integer>();
		int size = points.length;
		int total = 0;
		int sum_cloumn = 0;

		if (size <= 2) {
			return size;
		}

		for (int i = 0; i < size; i++) {
			sum_cloumn = 0;
			int add = 1;
			kmap.clear();
			for (int j = 0; j < size; j++) {
				if (j == i) {
					continue;
				}

				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					add++;
					continue;
				}

				float k = 0;

				if (points[i].x != points[j].x) {
					k = (float) (points[j].y - points[i].y)
							/ (points[j].x - points[i].x);
					if (kmap.containsKey(k)) {
						kmap.put(k, kmap.get(k) + 1);
					} else {
						kmap.put(k, 1);
					}
				} else {
					sum_cloumn++;
				}
			}
			for (Float f : kmap.keySet()) {
				if (kmap.get(f) > sum_cloumn) {
					sum_cloumn = kmap.get(f);
				}
			}
			sum_cloumn += add;

			if (sum_cloumn > total) {
				total = sum_cloumn;
			}
		}
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1, 0);
		Point p3 = new Point(1, -1);
		Point[] points = new Point[3];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		System.out.println(new MaxPointsonaLine().maxPoints(points));
	}

}
