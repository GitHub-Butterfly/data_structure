package experiment;

import code.list.SeqList;
import code.list.SinglyList;

/**
 * @author Thinkpad
 * use sequence list to solve Joseph Ring
 */

/*
    解题思路：
        0.创建顺序表类对象
        1.让顺序表构成环路
        2.添加判断条件——是否只剩下一个元素？是，则结束程序；否，则执行循环中的程序
 */

public class Test1 {
    public static void main(String[] args) {
        String[] values = new String[]{"1", "2", "3", "4", "5"};
        SeqList sel = new SeqList(values);
        System.out.println(sel.toString());
        seqList_Joseph_Ring(sel.size(), 1, 2, sel);
        System.out.println(sel.toString());

    }

    public static void seqList_Joseph_Ring(int n, int x, int m, SeqList sel) {
        int t = 0, t1 = 0;
        m--;//让remove(i)删除的是第i个元素
        while (n > 1) {
            if (m < n) {
                System.out.println(sel.remove(m));
            } else {
                System.out.println(sel.remove(m % n));
            }
            n--;
            m += m;
            if (m > n) {
                t++;
            }
            if (t > 1) {
                m++;
            }
        }
    }
}
