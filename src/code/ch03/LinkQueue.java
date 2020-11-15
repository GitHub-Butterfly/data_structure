/*
package code.ch03;

import code.ch02.Node;

public class LinkQueue<T> implements IQueue<T> {
	private Node<T> front;// ����ָ��
	private Node<T> rear;// ��βָ��

	// ����ն���
	public LinkQueue() {
		front = rear = null;
	}

	// �������ÿ�
	public void clear() {
		front = rear = null;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return front == null;
	}

	// ���ض��еĳ���
	public int length() {
		Node p = front;
		int length = 0;
		while (p != null) {
			p = p.next;
			length++;
		}
		return length;
	}

	// ��ȡ����Ԫ�ز�������ֵ
	public T peek() {
		if (isEmpty())
			return null;
		return (T) front.data;
	}

	// ���
	public void offer(T x) throws Exception {
		Node<T> s = new Node<T>(x);
		if (!isEmpty()) {// ������зǿ�
			rear.next = s;
			rear = s;
		} else {
			front = rear = s;
		}

	}

	// ����
	public T poll() {
		if ((front == null))
			return null;
		Node p = front;
		front = front.next;
		if (p == rear)// ɾ�����Ϊ��β���ʱ����Ҫ�޸�rear
			rear = null;
		return (T) p.data;
	}

	// ��������е���������Ԫ��
	public void display() {
		if (!isEmpty()) {
			for (Node p = front; p != null; p = p.next) {
				System.out.print(p.data + " ");
			}
		} else {
			System.out.print("�˶���Ϊ��");
		}
	}
}
*/
