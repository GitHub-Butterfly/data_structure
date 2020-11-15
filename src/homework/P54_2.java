package homework;

import java.util.Scanner;

/**
 * @author Thinkpad
 * ƥ����ţ��������߼���٣����Ǽ��������⣩
 */

/*
    ����˼·��
    java�У��߼��棺true���߼��٣�false
    ���ñ�־flag=true���Ը������ַ������б�����������ߵĴ����ţ������ź�Բ����ʱ��ʹflag=false��
    ���������ߵĴ����ţ������ź�Բ���ţ���ʹflag=true��
    �ڱ����պ����ʱ�����flag��ֵ��
 */

public class P54_2 {
    public static void main(String[] args) {
        System.out.println("������һ���ַ������ҽ������ַ����еĴ����ţ������ź�Բ�����Ƿ�ɶ�ƥ�䣺");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (checkMatching(str)) {
            System.out.println("TRUE : �����ţ������ź�Բ�����ǳɶ�ƥ�䡣");
        }else{
            System.out.println("FALSE : �����ţ������ź�Բ���Ų��ǳɶ�ƥ�䣡");
        }
    }

    private static boolean checkMatching(String str) {
        boolean flag = true;
        boolean flag0 = true;int f0 = 0;
        boolean flag1 = true;int f1 = 0;
        boolean flag2 = true;int f2 = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c == '{')) {
                flag0 = false;
                f0++;
            } else if ((c == '}')) {
                f0--;
                if (f0 == 0) {
                    flag0 = true;
                }
            }
            if ((c == '[')) {
                flag1 = false;
                f1++;
            } else if ((c == ']')) {
                f1--;
                if (f1 == 0) {
                    flag1 = true;
                }
            }
            if ((c == '(')) {
                flag2 = false;
                f2++;
            } else if ((c == ')')) {
                f2--;
                if (f2 == 0) {
                    flag2 = true;
                }
            }
        }
        if (!(flag0 && flag1 && flag2)) {
            flag = false;
        }

        return flag;
    }
}
