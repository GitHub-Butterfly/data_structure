package homework;

import java.util.*;

/**
 * @author Thinkpad
 * 把十进制整数转换为二至九进制数并输出
 */

/*
    解题思路：
    利用除数求余的方法来解题
    例如：10（十进制）求三进制数：10%3得3余1,3%3得1余0,1%3得0,余1，10（十进制）=101（三进制）
    步骤：创建十进制转X进制的方法——方法decimalToX(int x, int y);   x代表十进制数，y代表转换的目标进制
 */

public class P54_1 {
    public static void main(String[] args) {
        /*System.out.println(1 / 1);

        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(Arrays.toString(list.toArray()));*/

        System.out.println("请依次输入十进制数和目标进制数，且中间使用回车隔开：");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        ArrayList list = decimalToX(x, y);
        System.out.print(x + "转换为" + y + "进制后的结果是\t——————>>>\t");
        for (Object str : list
        ) {
            System.out.print(str);
        }
/*        //另一种输出集合中元素的方法
        System.out.println("\n========");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
*/
    }

    //x代表十进制数，y代表转换的目标进制
    private static ArrayList decimalToX(int x, int y) {
        ArrayList<String> list = new ArrayList<>();
        int temp = 0;//temp用于存储转换后的进制序列
        while (x >= y) {
            temp = x % y;
            list.add(temp + "");
            x /= y;
        }
        list.add(x + "");

        return list;
    }
}
