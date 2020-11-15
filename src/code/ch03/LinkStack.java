package code.ch03;


import code.ch02.Node;

public class LinkStack<T> implements IStack<T> {
	private Node<T> top;// 栈顶元素

	// 将栈置空
	public void clear() {
		top = null;
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		return top == null;
	}

	// 返回栈中数据元素个数
	public int length() {
		Node<T> p = top;
		int length = 0;
		while (p != null) {
			p = p.next;
			length++;
		}
		return length;

	}

	// 返回栈顶元素
	public T peek() {
		if (!isEmpty())
			return (T) top.data;
		else
			return null;
	}

	// 入栈
	public void push(T x) throws Exception {
		Node<T> s = new Node<T>(x, null);
		s.next = top;
		top = s;
	}

	// 出栈
	public T pop() {
		if (isEmpty())
			return null;
		Node<T> p = top;
		top = top.next;
		return (T) p.data;
	}

	// 输出栈中的所有数据元素
	public void display() {
		Node<T> p = top;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
	}

}
