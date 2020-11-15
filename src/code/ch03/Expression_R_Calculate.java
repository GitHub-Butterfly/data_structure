package code.ch03;

import java.net.InetAddress;

public class Expression_R_Calculate {
    //计算后缀（suffix）表达式
    public static int calculate_Suffix(String suffix) throws Exception {
        LinkedStack<String> stack = new LinkedStack<>();
        StringBuffer temp = new StringBuffer();
        int a = 0, b = 0, result = 0;//初始值为0
        for (int i = 0; i < suffix.length(); i++) {
            char c = suffix.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    /*while (!stack.isEmpty() && stack.peek() != " ") {
                        temp.append(stack.pop());
                    }*/
                    if (!stack.isEmpty() && stack.peek() != " ") {
                        temp.append(stack.pop());
                    }
                    a = Integer.parseInt(temp.toString());
                    temp = new StringBuffer();
                    /*while (stack.peek() != " " && !stack.isEmpty()) {
                        temp.append(temp.toString());
                    }*/
                    if (!stack.isEmpty() && stack.peek() != " ") {
                        temp.append(stack.pop());
                    }
                    if (temp.toString() != " ") {
                        b = Integer.parseInt(temp.toString());
                    }
                    temp = new StringBuffer();
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
        String suffix = "5 6 6 8 9/- *+8+";
        System.out.println(calculate_Suffix(suffix));

        System.out.println(Integer.parseInt("0") + 1);
        String s="3>2";// 这里你可以自己拼一bai下字符串
    }
}
