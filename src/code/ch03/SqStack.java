package code.ch03;

public class SqStack<T> implements IStack<T> {

	private Object[] stackElem;// 顺序栈存储空间
	private int top;// 指向栈顶元素的下一个存储单元位置
	private int maxSize;// 栈的最大存储单元个数

	// 构造最大存储单元个数为maxSize的空栈
	public SqStack(int maxSize) {
		top = 0;
		this.maxSize = maxSize;
		stackElem =  new Object[maxSize];
	}

	// 将栈置空
	public void clear() {
		top = 0;
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		return top == 0;
	}

	// 返回栈中数据元素个数
	public int length() {

		return top;
	}

	// 返回栈顶元素
	public T peek() {
		if (!isEmpty())
			return (T)stackElem[top - 1];
		else
			return null;
	}

	// 入栈
	public void push(T x) throws Exception {
		if (top == maxSize)
			throw new Exception("栈已满");
		stackElem[top] = x;
		top++;
	}

	// 出栈
	public T pop() {
		if (isEmpty())
			return null;
		top--;
		return (T)stackElem[top];

	}

	// 输出栈中的所有数据元素
	public void display() {
		if (top == 0)
			System.out.println("栈为空");
		else {
			for (int i = top - 1; i >= 0; i--) {
				System.out.print(stackElem[i] + " ");
			}
		}

	}

	public static void main(String[] args) throws Exception {
		SqStack<String> s = new SqStack(5);
		s.push("a");
		s.push("b");
		s.push("c");
		s.push("d");
		s.display();
	}
}
