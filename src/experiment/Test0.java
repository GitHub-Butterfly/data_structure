package experiment;

import code.list.SinglyList;

/**
 * @author Thinkpad
 * use linked list to solve Joseph Ring
 */

/*
    ����˼·��
        0.�������������
        1.�������ɻ�·
        2.����ж����������Ƿ�ֻʣ��һ��Ԫ�أ��ǣ���������򣻷���ִ��ѭ���еĳ���

 */

public class Test0 {
    public static void main(String[] args) {
        int n = 0;

        String[] values = new String[]{"1", "2", "3", "4", "5"};
        SinglyList sil = new SinglyList(values);
        System.out.println(sil.toString());
        System.out.println(sil.get(1));//ʹ��sl.get(i)�õ�����Ϊi��Ԫ��
        sil.last().next = sil.first();
        Joseph_Ring(sil.size(), 1, 2, sil);
    }

    //n����Χ��һȦ���ӵ�x���ˣ��Ե�1����Ϊ������ʼ������������m���˽�����ֱ��ʣ�����һ���ˡ�
    //Ҫ����������˺����ʣ�µ��Ǹ��˵���š�
    public static void Joseph_Ring(int n, int x, int m, SinglyList sl) {
        m--;
        System.out.println("���ֵ����ǣ�");
        while (n > 1) {
            System.out.println(sl.remove_JosephRing(m));
            n--;
        }
        System.out.println("ʣ�µ����ǣ�" + sl.get(0));
    }
}
