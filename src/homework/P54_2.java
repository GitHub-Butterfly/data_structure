package homework;

import java.util.Scanner;

/**
 * @author Thinkpad
 * 匹配符号，并返回逻辑真假（这是简述的题意）
 */

/*
    解题思路：
    java中，逻辑真：true，逻辑假：false
    设置标志flag=true，对给定的字符串进行遍历，遇到左边的大括号，方括号和圆括号时，使flag=false，
    如果遇到左边的大括号，方括号和圆括号，则使flag=true。
    在遍历刚好完成时，输出flag的值。
 */

public class P54_2 {
    public static void main(String[] args) {
        System.out.println("请输入一段字符串，我将检查该字符串中的大括号，方括号和圆括号是否成对匹配：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (checkMatching(str)) {
            System.out.println("TRUE : 大括号，方括号和圆括号是成对匹配。");
        }else{
            System.out.println("FALSE : 大括号，方括号和圆括号不是成对匹配！");
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
