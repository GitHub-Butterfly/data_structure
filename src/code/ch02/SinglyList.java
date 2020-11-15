package code.ch02;

public class SinglyList<T> {
	public Node<T> head; // ͷָ��

	public SinglyList() { // ����ձ�
		head = new Node<T>(null, null);
	}

	public SinglyList(T[] values) {
	}

	public boolean isEmpty() {
		return head.next == null ? true : false;
	}

	// ���ص�i��Ԫ��
	public T get(int i) {
		Node<T> p = head.next;
		for (int j = 0; j < i && p != null; j++) {
			p = p.next;
		}
		return p.data;
	}

	public void set(int i, T x) { // ���õ�i��Ԫ��Ϊx
		Node<T> p = head.next;
		for (int j = 0; j < i && p != null; j++) {
			p = p.next;
		}
		p.data = x;
	}

	public int size() { // ����
		Node<T> p = head.next;
		int size = 0;
		while (p != null) {
			size++;
			p = p.next;
		}
		return size;
	}

	public String toString() {
		Node<T> p = head.next;
		String str = "";
		while (p != null) {
			str += p.toString() + ",";
			p = p.next;
		}
		return str;
	}

	public Node<T> insert(int i, T x) {
		if (x == null) {
			throw new RuntimeException("���ܲ���NULL��");
		}
		Node<T> p = head;
		for (int j = 0; j < i && p.next != null; j++) {
			p = p.next;
		}
		Node<T> newNode = new Node(x, null);
		newNode.next = p.next;
		p.next = newNode;
		return newNode;
	}

	// ����x��Ϊ��i��Ԫ��
	public Node<T> insert(T x) { // β����
		return insert(Integer.MAX_VALUE, x);
	}

	public static void main(String[] args) {
		SinglyList<String> sl = new SinglyList<>();
		for (int i = 0; i < 5; i++) {
			sl.insert(2, "" + i);
		}
		System.out.println(sl);
		sl.set(1,"100");
		System.out.println(sl);
	}

	public T remove(int i) { // ɾ����i��Ԫ��
		Node<T> p = head;
		for (int j = 0; j < i && p.next.next != null; j++) {
			p = p.next;
		}		
		T data = p.next.data;
		p.next = p.next.next;
		return data;
	}

	public void clear() {
		head.next = null;
	}
}
