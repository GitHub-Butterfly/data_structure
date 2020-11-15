package old.code_teacher_0.sep_list;

public class SeqList<T> {
    protected /*static*/ Object[] element; // ��������
    protected Object[] element_different; // Ԫ�ز�ͬ�Ķ�������
    protected static int n; // elementԪ�ظ��������ȣ�
    protected static int n1 = 0; // element_differentԪ�ظ��������ȣ�

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

    //ȥ�أ���2�⣩

    /**
     * ȥ�ص�˼·��
     *  ʹ��˫��forѭ�������forѭ��ָ��һ��Ԫ�����ڲ�forѭ���е�ÿһ��Ԫ�ؽ��жԱȣ�
     *                  �����ǰһ�ֵ����forѭ��ָ����Ԫ�����ڲ���û����ͬԪ�أ���ֵ���½���������ȥ
     *                  ��ע����������������󳤶ȵ���ԭ�����Ԫ�ظ���
     *                             ����������Ҫһ���µı�������ʾ���е�Ԫ�ظ���
     *                   ��
     * @param a
     */
    public void different1(Object[] a) {//true����Ԫ�ظ�����ͬ
        element_different = new Object[element.length];
        copyArray_different1(a, element_different);
    }

    private void copyArray_different1(Object[] a, Object[] element_different) {
        int t = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                if (i != i1 && a[i] == (a[i1])) {
                    /*element_different[t] = element[i];
                    t++;*/
                    flag = true;
                }
            }
            if (!flag) {
                element_different[t] = element[i];
                n1++;
                t++;
                flag = false;
            }
        }
    }

    public void different(Object[] a, boolean flag) {//true����Ԫ�ظ�����ͬ
        if (flag) {
            copyArray_different(a);
        }
    }

    private void copyArray_different(Object[] a) {
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                if (i != i1 && a[i] == a[i1]) {
                    this.remove(i);
                }
            }
        }
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
        if (this.n > 0) {
            str += this.element[0].toString();
            for (int i = 1; i < this.n; i++) {
                str += (", " + this.element[i].toString());
            }
        }
        // ִ��T���toString()����������ʱ��̬
        return str + ") "; // �ձ���()
    }

    public String toS(Object[] element_different) {
        String str = this.getClass().getName() + "(";// ��������
        if (this.n1 > 0) {
            str += this.element_different[0].toString();
            for (int i = 1; i < this.n1; i++) {
                str += (", " + this.element_different[i].toString());
            }
        }
        // ִ��T���toString()����������ʱ��̬
        return str + ") " + "____________different"; // �ձ���()
    }

    //i������뵽�ڼ���λ�ã�ע�⣺�����±�������λ�ã�
    public void insert(int i, T x) {
        if (i <= 0) {
            throw new RuntimeException("ԓλ�ò�����");
        } else if (i >= n) {
            if (n == element.length) {
                addSize();
            }
            element[this.n] = x;
        } else {//����һ�����⣺������Ԫ�ظ���n=element.lenghtʱ���÷�֧���費���������
            //����
            addSize();
            //��λ�����������i��Ԫ�ؽ���Ԫ����λ
            for (int j = n - 1; j >= i - 1; j--) {
                element[j + 1] = element[j];//�����е�ǰһ��Ԫ�ظ�ֵ����һ��
            }
            element[i - 1] = x;
        }
        this.n++;
    }

    private void copyArray_0(Object[] element, int i, Object[] newElement) {

    }

/*
	public void insert(int i, T x){
		if (n == element.length - 2){//Ԫ�ظ���n��2����������element���ȣ��������ݣ����Ҳ���Ԫ��
			addSize_0();
		}

	}
*/

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
        i--;
        if (i >= 0 && i < this.n) {
            T old = (T) element[i];
            for (int j = i; j < this.n - 1; j++) {
                element[j] = element[j + 1];
            }
            element[this.n - 1] = null;
            this.n--;
            if (checkSize()) {//����������ռ��С�����������ѹ���ռ��С����1�⣩
                releaseSpace();
            }
            return old;
        }
        return null;
    }

    private boolean checkSize() {
        boolean flag = false;
        if (n < (element.length * 0.4)) {
            flag = true;
        }
        return flag;
    }

    private void releaseSpace() {
        Object[] newElement = new Object[(int) (element.length * 0.5)];
        copyArray(newElement, element);
        element = newElement;
    }

    public boolean isEmpty() { // �ж�˳����Ƿ��
        return this.n > 0 ? false : true;
    }

    public int size() {
        return this.n;
    }

    //һ�������������Ϊint��double������float�͵ģ���3�⣩
    public int max_element() {
        char[] element1 = element.toString().toCharArray();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if ((int) element1[i] > max) {
                max = element1[i];
            }
        }
        return max;
    }

    //�����4�⣩
    //���⣺�������ʹ�þ�̬static�Ļᱨ�����Ҳ�̫���static��ʹ�ã��Լ�Ϊʲô��ʹ��static�����ķ���
    public static double[] differentSet(double[] a, double[] b) {
        double[] dSet = new double[a.length > b.length ? a.length : b.length];
        for (int i = 0; i < (a.length > b.length ? a.length : b.length); i++) {
            dSet[i] = a[i] - b[i];
        }

        return dSet;
    }
}
