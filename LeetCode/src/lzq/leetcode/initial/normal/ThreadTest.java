package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class ThreadTest {
    public List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadTest tt = new ThreadTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println(i);
                    tt.list.add(i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println(i);
                    tt.list.add(i);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(tt.list.size());
        List<Integer>  a  = new ArrayList<>();
    }
}
