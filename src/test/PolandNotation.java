package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
//先定义逆波兰表达式
//(3*4)*5-6--->34*5*6-
// 为了方便使用空格隔开
        String suffixExpression="30 4 * 5 * 6 -";
//1.把"3 4 * 5 * 6 -"放入Arraylist中
//2.将Arraylist传递给一个方法，配合遍历Arraylist配合栈完成计算
        List<String> repList = getListString(suffixExpression);
        System.out.println("repList"+repList);
        int calculate = calculate(repList);
        System.out.println("计算结果是"+calculate);


    }


    public static List<String> getListString(String suffixExpression){
//将suffixExpression分割
        String[] s = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele:s ){
            list.add(ele);
        }
        return list;



    }
    //完成逆波兰表达式
    public static int calculate(List<String> is){
//创建栈
        Stack<String> stack = new Stack<>();
        for (String item:is){
//使用正则表达式
            if (item.matches("\\d+")){
//入栈
                stack.push(item);


            }else {
//pop出两个数，并运算，在入栈
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if (item.equals("+")){
                    res=num1+num2;
                }else if (item.equals("-")){
                    res=num1-num2;
                }else if (item.equals("*")){
                    res=num1*num2;
                }else if (item.equals("/")){
                    res=num1/num2;
                }

//把结果压入栈中
                stack.push(""+res);

            }


        }
//最后停留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());

    }

}
