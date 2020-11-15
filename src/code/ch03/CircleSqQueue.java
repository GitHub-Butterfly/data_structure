package code.ch03;

public class CircleSqQueue {
	private Object[] queueElem;// ���еĴ洢�ռ�
	private int front;// ָ�����Ԫ��
	private int rear;// ָ���βԪ�ص���һ���洢��Ԫ
	private int maxSize;// ���е����洢��Ԫ����

	// �������洢��Ԫ����ΪmaxSize�Ŀն���
	public CircleSqQueue(int maxSize) {
		front = rear = 0;
		queueElem = new Object[maxSize];
		this.maxSize = maxSize;
	}

	// �������ÿ�
	public void clear() {
		front = rear = 0;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// ���ض��еĳ���
	public int length() {
		return (rear - front + maxSize) % maxSize;
	}

	// ��ȡ����Ԫ�ز�������ֵ
	public Object peek() {
		if (isEmpty())
			return null;
		return queueElem[front];
	}

	// ���
	public void offer(Object x) throws Exception {
		if ((rear + 1) % maxSize == front)
			throw new Exception("��������");
		queueElem[rear] = x;
		rear = (rear + 1) % maxSize;
	}

	// ����
	public Object poll() {
		if (rear == front)
			return null;
		Object p = queueElem[front];
		front = (front + 1) % maxSize;
		return p;
	}

	// ��������е���������Ԫ��
	public void display() {
		if (!isEmpty()) {
			for (int i = front; i < rear; i = (i + 1) % maxSize) {
				System.out.print(queueElem[i] + " ");
			}
		} else {
			System.out.print("�˶���Ϊ��");
		}

	}

}
