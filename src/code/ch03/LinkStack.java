package code.ch03;


import code.ch02.Node;

public class LinkStack<T> implements IStack<T> {
	private Node<T> top;// ջ��Ԫ��

	// ��ջ�ÿ�
	public void clear() {
		top = null;
	}

	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return top == null;
	}

	// ����ջ������Ԫ�ظ���
	public int length() {
		Node<T> p = top;
		int length = 0;
		while (p != null) {
			p = p.next;
			length++;
		}
		return length;

	}

	// ����ջ��Ԫ��
	public T peek() {
		if (!isEmpty())
			return (T) top.data;
		else
			return null;
	}

	// ��ջ
	public void push(T x) throws Exception {
		Node<T> s = new Node<T>(x, null);
		s.next = top;
		top = s;
	}

	// ��ջ
	public T pop() {
		if (isEmpty())
			return null;
		Node<T> p = top;
		top = top.next;
		return (T) p.data;
	}

	// ���ջ�е���������Ԫ��
	public void display() {
		Node<T> p = top;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
	}

}
