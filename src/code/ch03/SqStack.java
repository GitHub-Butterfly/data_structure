package code.ch03;

public class SqStack<T> implements IStack<T> {

	private Object[] stackElem;// ˳��ջ�洢�ռ�
	private int top;// ָ��ջ��Ԫ�ص���һ���洢��Ԫλ��
	private int maxSize;// ջ�����洢��Ԫ����

	// �������洢��Ԫ����ΪmaxSize�Ŀ�ջ
	public SqStack(int maxSize) {
		top = 0;
		this.maxSize = maxSize;
		stackElem =  new Object[maxSize];
	}

	// ��ջ�ÿ�
	public void clear() {
		top = 0;
	}

	// �ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return top == 0;
	}

	// ����ջ������Ԫ�ظ���
	public int length() {

		return top;
	}

	// ����ջ��Ԫ��
	public T peek() {
		if (!isEmpty())
			return (T)stackElem[top - 1];
		else
			return null;
	}

	// ��ջ
	public void push(T x) throws Exception {
		if (top == maxSize)
			throw new Exception("ջ����");
		stackElem[top] = x;
		top++;
	}

	// ��ջ
	public T pop() {
		if (isEmpty())
			return null;
		top--;
		return (T)stackElem[top];

	}

	// ���ջ�е���������Ԫ��
	public void display() {
		if (top == 0)
			System.out.println("ջΪ��");
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
