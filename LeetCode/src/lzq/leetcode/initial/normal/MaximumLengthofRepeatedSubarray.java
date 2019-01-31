package lzq.leetcode.initial.normal;

/**
 * MaximumLengthofRepeatedSubarray
 *
 * @author luzheqi
 * @date 2017/10/30
 * @time 下午5:13
 */
public class MaximumLengthofRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        if(A.length <= 0 || B.length <=0){
            return 0;
        }
        int maxLength = Integer.MIN_VALUE;
        int[][] map = new int[A.length][B.length];
        for(int i = 0; i < A.length; i++){
            map[i][0] = A[i] == B[0] ? 1 : 0;
            if( map[i][0] > maxLength){
                maxLength = map[i][0];
            }
        }
        for(int i = 0; i < B.length; i++){
            map[0][i] = A[0] == B[i] ? 1 : 0;
            if(map[0][i] > maxLength){
                maxLength = map[0][i];
            }
        }

        for(int i = 1; i < A.length; i++){
            for(int j = 1; j < B.length; j++){
                if(A[i] == B[j]){
                    map[i][j] = map[i-1][j-1] + 1;
                    if(map[i][j] > maxLength){
                        maxLength = map[i][j];
                    }
                }
            }
        }
        return maxLength;
    }
}
