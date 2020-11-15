package code.list;

public class Node<T> {
	public T data;
	public Node<T> next; // ��ַ�����ú�̽��

	public Node(T data, Node<T> next) {
		this.data = data; // T�������ø�ֵ
		this.next = next; // Node<T>�������ø�ֵ
	}

	public Node() {
		this(null, null);
	}

	public String toString() {
		return this.data.toString();
	}
}
