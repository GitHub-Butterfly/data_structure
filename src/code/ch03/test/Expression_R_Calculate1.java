package code.ch03.test;

import code.ch03.LinkedStack;

public class Expression_R_Calculate1 {
    //计算后缀（suffix）表达式
    public static int calculate_Suffix(String suffix) throws Exception {
        LinkedStack<String> stack = new LinkedStack<>();
        String[] strs = new String[suffix.length()];
        for (int i = 0; i < suffix.length(); i++) {
            strs[i] = suffix.charAt(i) + "";
            System.out.println("strs[" + i + "] = " + strs[i]);
        }
        System.out.println("=============================");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != " ") {
                if (strs[i].equals("+")) {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int result = b + a;
                    System.out.println("-------------" + b + "+" + a + "="+ result);
                    stack.push(result + "");
                } else if (strs[i].equals("-")) {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int result = b - a;
                    System.out.println("-------------" + b + "-" + a + "="+ result);
                    stack.push(result + "");
                } else if (strs[i].equals("*")) {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int result = b * a;
                    System.out.println("-------------" + b + "*" + a + "="+ result);
                    stack.push(result + "");
                } else if (strs[i].equals("/")) {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int result = b / a;
                    System.out.println("-------------" + b + "/" + a + "="+ result);
                    stack.push(result + "");
                }else{
                    if (!strs[i].equals(" ")) {
                        System.out.println("strs[" + i + "] = " + strs[i]);
                        stack.push(strs[i]);
                    }
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) throws Exception {
        String suffix = "5 6 7 9 9/-*+8+";
        System.out.println(calculate_Suffix(suffix));
    }
}
