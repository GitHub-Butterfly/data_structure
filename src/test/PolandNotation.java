package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
//�ȶ����沨�����ʽ
//(3*4)*5-6--->34*5*6-
// Ϊ�˷���ʹ�ÿո����
        String suffixExpression="30 4 * 5 * 6 -";
//1.��"3 4 * 5 * 6 -"����Arraylist��
//2.��Arraylist���ݸ�һ����������ϱ���Arraylist���ջ��ɼ���
        List<String> repList = getListString(suffixExpression);
        System.out.println("repList"+repList);
        int calculate = calculate(repList);
        System.out.println("��������"+calculate);


    }


    public static List<String> getListString(String suffixExpression){
//��suffixExpression�ָ�
        String[] s = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele:s ){
            list.add(ele);
        }
        return list;



    }
    //����沨�����ʽ
    public static int calculate(List<String> is){
//����ջ
        Stack<String> stack = new Stack<>();
        for (String item:is){
//ʹ��������ʽ
            if (item.matches("\\d+")){
//��ջ
                stack.push(item);


            }else {
//pop���������������㣬����ջ
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

//�ѽ��ѹ��ջ��
                stack.push(""+res);

            }


        }
//���ͣ����stack�е�������������
        return Integer.parseInt(stack.pop());

    }

}
