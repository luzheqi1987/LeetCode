package lzq.test;

public class Test {
	public void lis1(int[] L) {

		int n = L.length;
		int[] B = new int[n + 1];// ����B��
		B[0] = -10000;// ��B[0]��Ϊ��С�������κ����붼����-10000��
		B[1] = L[0];// ��ʼʱ�������������г���Ϊ1����ĩԪ��Ϊa1
		int Len = 1;// LenΪ��ǰ�����������г��ȣ���ʼ��Ϊ1��
		int p, r, m;// p,r,m�ֱ�Ϊ���ֲ��ҵ��Ͻ磬�½���е㣻
		for (int i = 1; i < n; i++)
		{
			p = 0;
			r = Len;
			while (p <= r)// ���ֲ�����ĩԪ��С��ai+1�ĳ������������������У�
			{
				m = (p + r) / 2;
				if (B[m] < L[i])
					p = m + 1;
				else
					r = m - 1;
			}
			B[p] = L[i];// ������Ϊp�������������еĵ�ǰ��ĩԪ����Ϊai+1;
			if (p > Len)
				Len++;// ���µ�ǰ�����������г��ȣ�

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
