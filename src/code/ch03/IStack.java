package code.ch03;

public interface IStack<T> {
	public void clear();// ��ջ�ÿ�

	public boolean isEmpty();// �ж�ջ�Ƿ�Ϊ��

	public int length();// ����ջ������Ԫ�ظ���

	public T peek();// ����ջ��Ԫ��

	public void push(T x) throws Exception;// ������Ԫ��x��ջ

	public Object pop();// ��ջ��Ԫ�س�ջ������

	public void display();// ���ջ�е�����Ԫ��

}
