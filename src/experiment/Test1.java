package experiment;

import code.list.SeqList;
import code.list.SinglyList;

/**
 * @author Thinkpad
 * use sequence list to solve Joseph Ring
 */

/*
    ����˼·��
        0.����˳��������
        1.��˳����ɻ�·
        2.����ж����������Ƿ�ֻʣ��һ��Ԫ�أ��ǣ���������򣻷���ִ��ѭ���еĳ���
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
        m--;//��remove(i)ɾ�����ǵ�i��Ԫ��
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
