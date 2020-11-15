package code.ch03;

import code.ch02.SinglyList;

public class LinkedStack<T> implements IStack<T> {
	private SinglyList<T> sl;

	public LinkedStack() {
		sl = new SinglyList<>();
	}
	
	// 将栈置空
	public void clear() {
		this.sl.clear();
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		return this.sl.isEmpty();
	}

	// 返回栈中数据元素个数
	public int length() {
		return this.sl.size();
	}

	// 返回栈顶元素
	public T peek() {
		return this.sl.get(0);
	}

	// 入栈
	public void push(T x) throws Exception {
		this.sl.insert(0, x);
	}

	// 出栈
	public T pop() {
		return (T) this.sl.remove(0);
	}

	// 输出栈中的所有数据元素
	public void display() {
		System.out.print(this.sl.toString());
	}

	public static void main(String[] args) throws Exception {
		LinkedStack<String> ls = new LinkedStack();
		ls.push("a");
		ls.push("b");
		ls.push("c");
		ls.push("d");
		ls.display();
	}
}
