package code.list;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
	// 构造方法
	public SortedSeqList() // 构造空排序顺序表
	{
		super(); // 默认调用父类构造方法SeqList()
	}

	public SortedSeqList(int length) // 构造空排序顺序表，容量为length
	{
		super(length); // 调用父类构造方法SeqList(length)。若省略，默认调用super()
	}

	public SortedSeqList(T[] values) // 构造排序顺序表，由values数组提供元素，O(n2)
	{
		super(values.length); // 创建空排序顺序表，指定容量
		for (int i = 0; i < values.length; i++) // 直接插入排序，每趟插入1个元素（//9.5.1 顺序表的排序算法）
			this.insert(values[i]); // 插入元素，根据对象大小确定插入位置，O(n)
	}

	// 拷贝构造方法
	// 由顺序表list构造排序顺序表。直接插入排序算法，O(n*n)。 //SeqList<T>中的T，就是SortedSeqList<T>中的T，可比较大小
	public SortedSeqList(SeqList<? extends T> list) {
		super(); // 创建空排序顺序表，默认调用父类构造方法SeqList()
		for (int i = 0; i < list.n; i++) // 2.2.3
			this.insert(list.get(i)); // 调用子类覆盖的insert(T)方法，按值插入，O(n)
		// this.addAll(list); //for也可写成，教材此时还没有讲到addAll()；
	}

	public SortedSeqList(SortedSeqList<? extends T> list) // 排序顺序表的拷贝构造方法，深拷贝，O(n)
	{
		super(list); // 调用SeqList(SeqList<T>)，list引用子类实例，参数类型赋值相容
	}
	// 调用toPreviousString()方法得到降序排序的线性表

	// 不支持父类的以下两个方法，将其覆盖并抛出异常
	public void set(int i, T x) {
		throw new UnsupportedOperationException("set(int i, T x)");
	}

	// 子类需要用，若覆盖，子类调用则抛出异常？？
	public int insert(int i, T x) {
		throw new UnsupportedOperationException("insert(int i, T x)");
	}

	// 顺序查找首次出现的与key相等元素，返回元素序号i（0≤i<n）；若查找不成功返回-1，O(n)。覆盖
	public int search(T key) {
		// System.out.print(this.getClass().getName()+".indexOf("+key+","+start+")，");
		for (int i = 0; i < this.n && key.compareTo(this.get(i)) >= 0; i++)// （升序）
		{
			// System.out.print(this.element[i]+"？");
			if (key.compareTo(this.get(i)) == 0) // 对象相等，运行时多态
				return i;
		}
		return -1; // 空表或未找到时
	}

	// 插入x，x!=null，根据x对象大小顺序查找确定插入位置（升序），插入在等值结点之前，返回x序号，O(n)。
	// 调用T的compareTo()方法比较对象大小。覆盖父类insert(x)，参数列表和返回值相同
	public int insert(T x) {
		int i = 0;
		if (this.isEmpty() || x.compareTo(this.get(this.n - 1)) > 0)// compareTo(T)比较大小
			i = this.n; // 最大值尾插入，O(1)
		else
			while (i < this.n && x.compareTo(this.get(i)) > 0) // 寻找插入位置（升序）
				i++;
		super.insert(i, x); // 调用父类被覆盖的insert(i,x)方法，插入x作为第i个元素
		return i;
	}

	// 继承，运行时多态
	/*
	 * public T remove(T key) //删除首次出现的与key相等元素，返回被删除元素；查找不成功返回null。覆盖 { return
	 * this.remove(this.search(key)); //先查找，再remove(i)。若查找返回-1，则不删除
	 * //其中this.search(key)调用子类的查找方法 }
	 */
	// 2015年1月30日测试，校清样，正确，不需要重写。

	// 【思考题2-4】习题解答
	// public void addAll(SeqList<? extends T> list) //继承

	// public SeqList<T> union(SeqList<? extends T> list) //继承
	public SortedSeqList<T> union(SeqList<? extends T> list) // 覆盖，返回值类型不同但赋值相容，包含参数SortedSeqList<?
																// extends T>
	{
		SortedSeqList<T> result = new SortedSeqList<T>(this); // 创建子类实例，深拷贝父类实例。只此一句不同
		result.addAll(list); // 排序顺序表合并，按值插入
		return result; // 返回SortedSeqList<T>对象
	}	

}
