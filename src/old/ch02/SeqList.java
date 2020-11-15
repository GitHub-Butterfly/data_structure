package old.ch02;

public class SeqList<T> {
	protected Object[] element; // ��������
	protected int n; // Ԫ�ظ��������ȣ�

	public SeqList(int length) { // ����ձ�
		element = new Object[length];
		this.n = 0;
	}

	public SeqList() { // ���췽������
		this(64); // ���ñ���ָ�������б�Ĺ��췽��
	}

	public SeqList(T[] values) { // ��values�����ṩԪ��
		this(64);
		for (int i = 0; i < values.length; i++) {
			element[i] = values[i];
		}
		this.n = values.length;
	}

	public T get(int i) {
		if (i >= 0 && i < n) {
			return (T) element[i];
		} else {
			throw new RuntimeException("Ԫ�ز�����");
		}
	}

	public void set(int i, T x) {
		if (i >= 0 && i < n) {
			element[i] = x;
		} else {
			throw new RuntimeException("ԓλ�ò�����");
		}
	}

	@Override
	public String toString() {
		String str = this.getClass().getName() + "(";// ��������
		if (this.n > 0)
			str += this.element[0].toString();
		for (int i = 1; i < this.n; i++)
			str += ", " + this.element[i].toString();
		// ִ��T���toString()����������ʱ��̬
		return str + ") "; // �ձ���()
	}

	public void insert(int i, T x) {
		if (i < 0) {
			throw new RuntimeException("ԓλ�ò�����");
		} else if (i >= n) {
			if (n == element.length) {
				addSize();
			}
			element[this.n] = x;
			this.n++;
		}
	}

	public void insert(T x) {
		this.insert(this.n, x);
	}

	public void addSize() {
		Object[] newElement = new Object[(int) (element.length * 1.5)];
		copyArray(newElement, element);
		element = newElement;
	}

	public void copyArray(Object[] a, Object[] b) {
		for (int i = 0; i < a.length && i < b.length; i++) {
			a[i] = b[i];
		}
	}

	public T remove(int i) {
		if (i >= 0 && i < this.n) {
			T old = (T) element[i];
			for (int j = i; j < this.n - 1; j++) {
				element[j] = element[j + 1];
			}
			element[this.n - 1] = null;
			this.n--;
			return old;
		}
		return null;
	}

	public boolean isEmpty() { // �ж�˳����Ƿ��
		return this.n > 0 ? false : true;
	}

	public int size() {
		return this.n;
	}
}
