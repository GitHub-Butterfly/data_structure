package homework;

import java.util.Scanner;

/**
 * @author Thinkpad
 * ��д쳲��������еĵݹ��㷨�ͷǵݹ��㷨�������n���ֵ
 */

/*
    ����˼·��
    ���ģ���һ����ֱ�Ϊ0��1���Ժ����Ϊǰ����֮��
        �ݹ��㷨�����ݼ��㹫ʽ��ʹ�ú����ݹ�ķ�ʽ���б�ʾ
        �ǵݹ��㷨��ʹ������forѭ���ķ�ʽ����
 */

public class P55_3 {
    public static void main(String[] args) {
        System.out.print("����������֪��쳲��������еĵڼ��");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("���ǵݹ鷽������쳲��������е�" + x + "���ֵΪ��" + fibonacci_nonrecursion(x));
        System.out.println("���ݹ鷽������쳲��������е�" + x + "���ֵΪ��" + fibonacci_recursion(x));
    }

    private static int fibonacci_nonrecursion(int x) {
        if (x == 1) {
            return 0;
        }
        if (x == 2) {
            return 1;
        }

        int temp1 = 0, temp2 = 0;
        for (int i = 1; i <= x; i++) {
            if (i == 1) {
                temp1 = 0;
            } else if (i == 2) {
                temp2 = 1;
            } else {
                if (i % 2 != 0) {
                    temp1 += temp2;
                } else {
                    temp2 += temp1;
                }
            }
        }

        /*return temp1 + temp2;*/
        if (x % 2 != 0) {
            return temp1;
        }else{
            return temp2;
        }
    }

    private static int fibonacci_recursion(int x) {
        if (x == 1) {
            return 0;
        } else if (x == 2) {
            return 1;
        } else {
            return fibonacci_recursion(x - 1) + fibonacci_recursion(x - 2);
        }
    }
}
