package lzq.test;

public class Test {
	public void lis1(int[] L) {

		int n = L.length;
		int[] B = new int[n + 1];// 数组B；
		B[0] = -10000;// 把B[0]设为最小，假设任何输入都大于-10000；
		B[1] = L[0];// 初始时，最大递增子序列长度为1的最末元素为a1
		int Len = 1;// Len为当前最大递增子序列长度，初始化为1；
		int p, r, m;// p,r,m分别为二分查找的上界，下界和中点；
		for (int i = 1; i < n; i++)
		{
			p = 0;
			r = Len;
			while (p <= r)// 二分查找最末元素小于ai+1的长度最大的最大递增子序列；
			{
				m = (p + r) / 2;
				if (B[m] < L[i])
					p = m + 1;
				else
					r = m - 1;
			}
			B[p] = L[i];// 将长度为p的最大递增子序列的当前最末元素置为ai+1;
			if (p > Len)
				Len++;// 更新当前最大递增子序列长度；

		}
		System.out.println(Len);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 5, 4, 7, 6 };
		new Test().lis1(a);
	}

}
