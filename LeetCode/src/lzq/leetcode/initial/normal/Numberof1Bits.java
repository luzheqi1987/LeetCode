package lzq.leetcode.initial.normal;

public class Numberof1Bits {
    public int hammingWeight(int n) {
    	int tmp = n;
    	int oneNumber = 0;
    	while(tmp != 0){
    		oneNumber++;
    		tmp = tmp & (tmp - 1);
    	}
    	return oneNumber;
    }
    
	public static void main(String[] args) {
		int n = 11;
		Numberof1Bits numberof1Bits = new Numberof1Bits();
		System.out.println(numberof1Bits.hammingWeight(n));
	}

}
