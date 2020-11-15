package code.ch03.test;

import code.ch03.LinkedStack;

public class Expression_R_Calculate {
    //计算后缀（suffix）表达式
    public static int calculate_Suffix(String suffix) throws Exception {
        LinkedStack<String> stack = new LinkedStack<>();
        StringBuffer temp = new StringBuffer();
        StringBuffer temp1 = new StringBuffer();
        int a = 0, b = 0, result = 0;//初始值为0
        for (int i = 0; i < suffix.length(); i++) {
            char c = suffix.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    /*if (!stack.isEmpty() && !stack.peek().equals(" ")) {
                        temp.append(stack.pop());
                    }
                    if (!stack.isEmpty() && !stack.peek().equals(" ")) {
                        stack.pop();
                    }
                    a = Integer.parseInt(temp.toString());
                    temp = new StringBuffer();

                    *//*if (!stack.isEmpty() && !stack.peek().equals(" ")) {
                        temp1.append(stack.pop());
                    }
                    if (!stack.isEmpty() && !stack.peek().equals(" ")) {
                        stack.pop();
                    }
                    b = Integer.parseInt(temp1.toString());
                    temp1 = new StringBuffer();*//*
*/
                    a = Integer.parseInt(stack.pop());
                    if (stack.peek() == " ") {
                        stack.pop();
                    }
                    if (stack.peek() != " " && !stack.isEmpty()) {
                        b = Integer.parseInt(stack.pop());
                    }

                    if(c == '+'){
                        result = a + b;
                    } else if (c == '-') {
                        result = a - b;
                    } else if (c == '*') {
                        result = a * b;
                    } else if (c == '/') {
                        result = a / b;
                    }
                    stack.push(result + "");
                    /*a = b = 0;
                    temp = new StringBuffer();*/
                    break;
                default:
                    stack.push(c + "");
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String suffix = "5 6 7 9 9/-*+8+";
        System.out.println(calculate_Suffix(suffix));
        System.out.println("=======================================");
        System.out.println(Integer.parseInt("0") + 1);
        String s="3>2";// 这里你可以自己拼一bai下字符串
    }
}
