package lzq.leetcode.initial.normal;

public class ReverseBits {
	
    public int reverseBits(int n) {
        int i = 0;
        for(int j = 0; j < 32; j++){
        	i = (i << 1) | ((n >> j) & 0x1);
        }
        return i;
    }
    
	public static void main(String[] args) {
		int i = 43261596;
		ReverseBits reverseBits = new ReverseBits();
		System.out.println(reverseBits.reverseBits(i));
	}
}
