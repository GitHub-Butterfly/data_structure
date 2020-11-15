package code.ch03;

public class Expression {
    public static String infixToSuffix(String infix) throws Exception {
        LinkedStack<String> stack = new LinkedStack<>();
        StringBuffer postfix = new StringBuffer();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c + "");
                    break;
                case ')':
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.append(stack.pop());
                    }
                    if (!stack.isEmpty() && stack.peek().equals("(")){
						stack.pop();
					}
                    break;
                case '+':
                case '-':
					postfix.append(" ");
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.append(stack.pop());
                    }
                    stack.push( c + "");
                    break;
                case '*':
                case '/':
					postfix.append(" ");//往中缀表达式中添加空格" "
                    while (!stack.isEmpty() && !stack.peek().equals("(")
                            && !stack.peek().equals("+")
                            && !stack.peek().equals("-")) {
                        postfix.append(stack.pop());
                    }
                    stack.push( c + "");
                    break;
                default:
                    stack.push(c + "");
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) throws Exception {
		String ex1 = "(5800+69*(6-8/9)+8)";
		System.out.println(infixToSuffix(ex1));//5800 69 6 8 9/- *+8+
         String ex2 = "(5+6*(6-8/9)+8)";
		System.out.println(infixToSuffix(ex2));//5800 69 6 8 9/- *+8+
        String ex = "(5800 + 69 * (6 - 8 / 9) + 8)";
        System.out.println(infixToSuffix(ex));
    }
}
