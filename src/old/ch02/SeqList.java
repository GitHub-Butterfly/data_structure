package old.ch02;

public class SeqList<T> {
	protected Object[] element; // 对象数组
	protected int n; // 元素个数（长度）

	public SeqList(int length) { // 构造空表
		element = new Object[length];
		this.n = 0;
	}

	public SeqList() { // 构造方法重载
		this(64); // 调用本类指定参数列表的构造方法
	}

	public SeqList(T[] values) { // 由values数组提供元素
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
			throw new RuntimeException("元素不存在");
		}
	}

	public void set(int i, T x) {
		if (i >= 0 && i < n) {
			element[i] = x;
		} else {
			throw new RuntimeException("該位置不存在");
		}
	}

	@Override
	public String toString() {
		String str = this.getClass().getName() + "(";// 返回类名
		if (this.n > 0)
			str += this.element[0].toString();
		for (int i = 1; i < this.n; i++)
			str += ", " + this.element[i].toString();
		// 执行T类的toString()方法，运行时多态
		return str + ") "; // 空表返回()
	}

	public void insert(int i, T x) {
		if (i < 0) {
			throw new RuntimeException("該位置不存在");
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

	public boolean isEmpty() { // 判断顺序表是否空
		return this.n > 0 ? false : true;
	}

	public int size() {
		return this.n;
	}
}
