package code.list;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
	// ���췽��
	public SortedSeqList() // ���������˳���
	{
		super(); // Ĭ�ϵ��ø��๹�췽��SeqList()
	}

	public SortedSeqList(int length) // ���������˳�������Ϊlength
	{
		super(length); // ���ø��๹�췽��SeqList(length)����ʡ�ԣ�Ĭ�ϵ���super()
	}

	public SortedSeqList(T[] values) // ��������˳�����values�����ṩԪ�أ�O(n2)
	{
		super(values.length); // ����������˳���ָ������
		for (int i = 0; i < values.length; i++) // ֱ�Ӳ�������ÿ�˲���1��Ԫ�أ�//9.5.1 ˳���������㷨��
			this.insert(values[i]); // ����Ԫ�أ����ݶ����Сȷ������λ�ã�O(n)
	}

	// �������췽��
	// ��˳���list��������˳���ֱ�Ӳ��������㷨��O(n*n)�� //SeqList<T>�е�T������SortedSeqList<T>�е�T���ɱȽϴ�С
	public SortedSeqList(SeqList<? extends T> list) {
		super(); // ����������˳���Ĭ�ϵ��ø��๹�췽��SeqList()
		for (int i = 0; i < list.n; i++) // 2.2.3
			this.insert(list.get(i)); // �������า�ǵ�insert(T)��������ֵ���룬O(n)
		// this.addAll(list); //forҲ��д�ɣ��̲Ĵ�ʱ��û�н���addAll()��
	}

	public SortedSeqList(SortedSeqList<? extends T> list) // ����˳���Ŀ������췽���������O(n)
	{
		super(list); // ����SeqList(SeqList<T>)��list��������ʵ�����������͸�ֵ����
	}
	// ����toPreviousString()�����õ�������������Ա�

	// ��֧�ָ���������������������串�ǲ��׳��쳣
	public void set(int i, T x) {
		throw new UnsupportedOperationException("set(int i, T x)");
	}

	// ������Ҫ�ã������ǣ�����������׳��쳣����
	public int insert(int i, T x) {
		throw new UnsupportedOperationException("insert(int i, T x)");
	}

	// ˳������״γ��ֵ���key���Ԫ�أ�����Ԫ�����i��0��i<n���������Ҳ��ɹ�����-1��O(n)������
	public int search(T key) {
		// System.out.print(this.getClass().getName()+".indexOf("+key+","+start+")��");
		for (int i = 0; i < this.n && key.compareTo(this.get(i)) >= 0; i++)// ������
		{
			// System.out.print(this.element[i]+"��");
			if (key.compareTo(this.get(i)) == 0) // ������ȣ�����ʱ��̬
				return i;
		}
		return -1; // �ձ��δ�ҵ�ʱ
	}

	// ����x��x!=null������x�����С˳�����ȷ������λ�ã����򣩣������ڵ�ֵ���֮ǰ������x��ţ�O(n)��
	// ����T��compareTo()�����Ƚ϶����С�����Ǹ���insert(x)�������б�ͷ���ֵ��ͬ
	public int insert(T x) {
		int i = 0;
		if (this.isEmpty() || x.compareTo(this.get(this.n - 1)) > 0)// compareTo(T)�Ƚϴ�С
			i = this.n; // ���ֵβ���룬O(1)
		else
			while (i < this.n && x.compareTo(this.get(i)) > 0) // Ѱ�Ҳ���λ�ã�����
				i++;
		super.insert(i, x); // ���ø��౻���ǵ�insert(i,x)����������x��Ϊ��i��Ԫ��
		return i;
	}

	// �̳У�����ʱ��̬
	/*
	 * public T remove(T key) //ɾ���״γ��ֵ���key���Ԫ�أ����ر�ɾ��Ԫ�أ����Ҳ��ɹ�����null������ { return
	 * this.remove(this.search(key)); //�Ȳ��ң���remove(i)�������ҷ���-1����ɾ��
	 * //����this.search(key)��������Ĳ��ҷ��� }
	 */
	// 2015��1��30�ղ��ԣ�У��������ȷ������Ҫ��д��

	// ��˼����2-4��ϰ����
	// public void addAll(SeqList<? extends T> list) //�̳�

	// public SeqList<T> union(SeqList<? extends T> list) //�̳�
	public SortedSeqList<T> union(SeqList<? extends T> list) // ���ǣ�����ֵ���Ͳ�ͬ����ֵ���ݣ���������SortedSeqList<?
																// extends T>
	{
		SortedSeqList<T> result = new SortedSeqList<T>(this); // ��������ʵ�����������ʵ����ֻ��һ�䲻ͬ
		result.addAll(list); // ����˳���ϲ�����ֵ����
		return result; // ����SortedSeqList<T>����
	}	

}
