package code.ch02;

public interface IList {

	public void clear();// �����Ա��óɿձ�

	public boolean isEmpty();// �ж����Ա��Ƿ�Ϊ�ձ�

	public int length();// �������Ա�ĳ���

	public Object get(int i) throws Exception;// ��ȡ���������Ա��е�i������Ԫ��

	public void insert(int i, Object x) throws Exception;// ����x��Ϊ��i��Ԫ��

	public void remove(int i) throws Exception; // ɾ����i��Ԫ��

	public int indexOf(Object x);// ����Ԫ��x�״γ��ֵ�λ���

	public void display();// ������Ա��и�������Ԫ�ص�ֵ

}
