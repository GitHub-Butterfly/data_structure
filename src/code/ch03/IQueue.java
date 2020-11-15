package code.ch03;

public interface IQueue<T> {
	public void clear();// �������ÿ�

	public boolean isEmpty();// �ж϶����Ƿ�Ϊ��

	public int length();// ���ض��е�����Ԫ�ظ���

	public T peek();// ���ض���Ԫ��

	public void offer(T x) throws Exception;// ������Ԫ��x���뵽���г�Ϊ��βԪ��

	public T poll();// ������Ԫ��ɾ����������ֵ

	public void display();// ��������е���������Ԫ��

}
