package lzq.leetcode.better.normal;

public class ContainerWithMostWater {
	/**
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 * 
	 * Note: You may not slant the container.
	 * 
	 * 1.���ȼ��������ҵ���ȡ����ݻ�������Ϊ i , j (�ٶ�i<j)����ô�õ�������ݻ� C = min( ai , aj ) * ( j- i)
	 * ��
	 * 
	 * 2.�������ǿ���ôһ�����ʣ�
	 * 
	 * ��: �� j ���Ҷ�û��һ���߻�����ߣ� ������� k |( j<k && ak > aj) ����ô �� ak> aj������ min(
	 * ai,aj, ak) =min(ai,aj) ��������i, k���ɵ��������ݻ�C' = min(ai,aj ) * ( k-i) >
	 * C����C����ֵì�ܣ����Ե�֤j�ĺ�߲����б������ߵ��ߣ�
	 * 
	 * ��:ͬ����i�����Ҳ�����б����ߵ��ߣ�
	 * 
	 * ��˵��ʲô�أ��������Ŀǰ�õ��ĺ�ѡ�� ��Ϊ x, y�����ߣ�x< y)����ô�ܹ��õ����������ݻ����µ������߱�Ȼ�� [x,y]�����ڲ��� ax'
	 * > =ax , ay'>= ay;
	 * 
	 * 3.�������Ǵ���ͷ���м俿£��ͬʱ���º�ѡֵ�������������ʱ�����ȴ� x, y�н�С�ı߿�ʼ������
	 * 
	 * 
	 * 
	 * ֱ�۵Ľ����ǣ��ݻ�����������ܳ��͸ߵ�Ӱ�죬�����ȼ�Сʱ�򣬸߱����������п�������������������Ǵӳ����ʱ��ʼ�ݼ���Ȼ��Ѱ�Ҹ��ߵ��������º򲹣�
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == height || height.length <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = height.length - 1;
		while (start < end) {
			max = Math.max(max,
					(end - start) * Math.min(height[start], height[end]));
			if (height[start] < height[end]) {
				int tmp = start + 1;
				while (tmp < end && height[tmp] <= height[start]) {
					tmp++;
				}
				start = tmp;
			} else {
				int tmp = end - 1;
				while (start < tmp && height[tmp] <= height[end]) {
					tmp--;
				}
				end = tmp;
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ContainerWithMostWater().maxArea(new int[] { 1,
				1 }));
	}

}
