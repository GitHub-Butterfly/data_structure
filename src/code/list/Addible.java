package code.list;
//2.  һԪ����ʽ����������ʵ��

public interface Addible<T>                      //����ӽӿڣ�T��ʾ����Ԫ�ص���������
{
    public void add(T t);                        //+=�ӷ���Լ����Ԫ����ӹ���
    public boolean removable();                  //Լ��ɾ��Ԫ������
}
