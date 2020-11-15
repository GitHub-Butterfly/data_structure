/*
package code.ch03;

import code.ch02.Node;

public class LinkQueue<T> implements IQueue<T> {
	private Node<T> front;// 队首指针
	private Node<T> rear;// 队尾指针

	// 构造空队列
	public LinkQueue() {
		front = rear = null;
	}

	// 将队列置空
	public void clear() {
		front = rear = null;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front == null;
	}

	// 返回队列的长度
	public int length() {
		Node p = front;
		int length = 0;
		while (p != null) {
			p = p.next;
			length++;
		}
		return length;
	}

	// 读取队首元素并返回其值
	public T peek() {
		if (isEmpty())
			return null;
		return (T) front.data;
	}

	// 入队
	public void offer(T x) throws Exception {
		Node<T> s = new Node<T>(x);
		if (!isEmpty()) {// 如果队列非空
			rear.next = s;
			rear = s;
		} else {
			front = rear = s;
		}

	}

	// 出队
	public T poll() {
		if ((front == null))
			return null;
		Node p = front;
		front = front.next;
		if (p == rear)// 删除结点为队尾结点时，需要修改rear
			rear = null;
		return (T) p.data;
	}

	// 输出队列中的所有数据元素
	public void display() {
		if (!isEmpty()) {
			for (Node p = front; p != null; p = p.next) {
				System.out.print(p.data + " ");
			}
		} else {
			System.out.print("此队列为空");
		}
	}
}
*/
