package old.code_teacher_0.node;

/**
 * �ڵ���  T����ʾ�ǽڵ�����
 * @param <T>
 */

public class Node<T> {
    public T data;//�����򣬱�������Ԫ��
    public Node<T> next;//��ַ�����ú�̽ڵ�

    public Node() {
        this.data  = null;
        this.next = null;
    }
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
