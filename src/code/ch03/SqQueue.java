package code.ch03;

public class SqQueue<T> implements IQueue<T> {
	private Object[] queueElem;// ���еĴ洢�ռ�
	private int front;// ָ�����Ԫ��
	private int rear;// ָ���βԪ�ص���һ���洢��Ԫ
	private int maxSize;// ���е����洢��Ԫ����

	// �������洢��Ԫ����ΪmaxSize�Ŀն���
	public SqQueue(int maxSize) {
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
		return rear - front;
	}

	// ��ȡ����Ԫ�ز�������ֵ
	public T peek() {
		if (isEmpty())
			return null;
		return (T) queueElem[front];
	}

	// ���
	public void offer(Object x) throws Exception {
		if (rear == maxSize)
			throw new Exception("��������");
		queueElem[rear] = x;
		rear++;
	}

	// ����
	public T poll() {
		if (rear == front)
			return null;
		Object p = queueElem[front];
		front++;
		return (T) p;
	}

	// ��������е���������Ԫ��
	public void display() {
		if (!isEmpty()) {
			for (int i = front; i < rear; i++) {
				System.out.print(queueElem[i] + " ");
			}
		} else {
			System.out.print("�˶���Ϊ��");
		}

	}

}
