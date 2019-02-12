package lzq.leetcode.initial.normal;

/**
 * StringWithoutAAAorBBB
 *
 * @author luzheqi
 * @date 2019-02-01
 * @time 18:54
 */
public class StringWithoutAAAorBBB {
    public String strWithout3a3b(int A, int B) {
        int a = A;
        int b = B;
        char ac = 'a';
        char bc = 'b';
        if(A > B){
            a = B;
            b = A;
            ac = 'b';
            bc = 'a';
        }
        StringBuilder sb = new StringBuilder();
        while(a < b && a > 0 && b > 0){
            sb.append(bc).append(bc).append(ac);
            a--;
            b--;
            b--;
        }
        if(a > 0 && b > 0) {
            for (int i = 0; i < a; i++) {
                sb.append(bc).append(ac);
            }
        }else if(b > 0){
            for (int i = 0; i < b; i++) {
                sb.append(bc);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringWithoutAAAorBBB().strWithout3a3b(7,10));
    }
}
