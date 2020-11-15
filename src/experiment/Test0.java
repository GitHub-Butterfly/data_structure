package experiment;

import code.list.SinglyList;

/**
 * @author Thinkpad
 * use linked list to solve Joseph Ring
 */

/*
    解题思路：
        0.创建链表类对象
        1.让链表构成环路
        2.添加判断条件——是否只剩下一个元素？是，则结束程序；否，则执行循环中的程序

 */

public class Test0 {
    public static void main(String[] args) {
        int n = 0;

        String[] values = new String[]{"1", "2", "3", "4", "5"};
        SinglyList sil = new SinglyList(values);
        System.out.println(sil.toString());
        System.out.println(sil.get(1));//使用sl.get(i)得到索引为i的元素
        sil.last().next = sil.first();
        Joseph_Ring(sil.size(), 1, 2, sil);
    }

    //n个人围成一圈，从第x个人（以第1个人为例）开始报数，数到第m个人结束，直到剩下最后一个人。
    //要求输出出局人和最后剩下的那个人的序号。
    public static void Joseph_Ring(int n, int x, int m, SinglyList sl) {
        m--;
        System.out.println("出局的人是：");
        while (n > 1) {
            System.out.println(sl.remove_JosephRing(m));
            n--;
        }
        System.out.println("剩下的人是：" + sl.get(0));
    }
}
