package code.list;

public class Node<T> {
	public T data;
	public Node<T> next; // 地址域，引用后继结点

	public Node(T data, Node<T> next) {
		this.data = data; // T对象引用赋值
		this.next = next; // Node<T>对象引用赋值
	}

	public Node() {
		this(null, null);
	}

	public String toString() {
		return this.data.toString();
	}
}
