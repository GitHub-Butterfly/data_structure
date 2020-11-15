package homework;

import java.util.Scanner;

/**
 * @author Thinkpad
 * 编写斐波那契数列的递归算法和非递归算法，求出第n项的值
 */

/*
    解题思路：
    核心：第一二项分别为0和1，以后各项为前两项之和
        递归算法：根据计算公式，使用函数递归的方式进行表示
        非递归算法：使用条件for循环的方式进行
 */

public class P55_3 {
    public static void main(String[] args) {
        System.out.print("请输入你想知道斐波那契数列的第几项：");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("（非递归方法：）斐波那契数列第" + x + "项的值为：" + fibonacci_nonrecursion(x));
        System.out.println("（递归方法：）斐波那契数列第" + x + "项的值为：" + fibonacci_recursion(x));
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
