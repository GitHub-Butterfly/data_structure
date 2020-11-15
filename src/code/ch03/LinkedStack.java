package code.ch03;

import code.ch02.SinglyList;

public class LinkedStack<T> implements IStack<T> {
	private SinglyList<T> sl;

	public LinkedStack() {
		sl = new SinglyList<>();
	}
	
	// ��ջ�ÿ�
	public void clear() {
		this.sl.clear();
	}

	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return this.sl.isEmpty();
	}

	// ����ջ������Ԫ�ظ���
	public int length() {
		return this.sl.size();
	}

	// ����ջ��Ԫ��
	public T peek() {
		return this.sl.get(0);
	}

	// ��ջ
	public void push(T x) throws Exception {
		this.sl.insert(0, x);
	}

	// ��ջ
	public T pop() {
		return (T) this.sl.remove(0);
	}

	// ���ջ�е���������Ԫ��
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
