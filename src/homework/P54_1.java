package homework;

import java.util.*;

/**
 * @author Thinkpad
 * ��ʮ��������ת��Ϊ�����Ž����������
 */

/*
    ����˼·��
    ���ó�������ķ���������
    ���磺10��ʮ���ƣ�������������10%3��3��1,3%3��1��0,1%3��0,��1��10��ʮ���ƣ�=101�������ƣ�
    ���裺����ʮ����תX���Ƶķ�����������decimalToX(int x, int y);   x����ʮ��������y����ת����Ŀ�����
 */

public class P54_1 {
    public static void main(String[] args) {
        /*System.out.println(1 / 1);

        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(Arrays.toString(list.toArray()));*/

        System.out.println("����������ʮ��������Ŀ������������м�ʹ�ûس�������");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        ArrayList list = decimalToX(x, y);
        System.out.print(x + "ת��Ϊ" + y + "���ƺ�Ľ����\t������������>>>\t");
        for (Object str : list
        ) {
            System.out.print(str);
        }
/*        //��һ�����������Ԫ�صķ���
        System.out.println("\n========");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
*/
    }

    //x����ʮ��������y����ת����Ŀ�����
    private static ArrayList decimalToX(int x, int y) {
        ArrayList<String> list = new ArrayList<>();
        int temp = 0;//temp���ڴ洢ת����Ľ�������
        while (x >= y) {
            temp = x % y;
            list.add(temp + "");
            x /= y;
        }
        list.add(x + "");

        return list;
    }
}
