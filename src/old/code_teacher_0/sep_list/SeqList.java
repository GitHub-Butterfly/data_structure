package old.code_teacher_0.sep_list;

public class SeqList<T> {
    protected /*static*/ Object[] element; // 对象数组
    protected Object[] element_different; // 元素不同的对象数组
    protected static int n; // element元素个数（长度）
    protected static int n1 = 0; // element_different元素个数（长度）

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

    //去重（第2题）

    /**
     * 去重的思路：
     *  使用双重for循环，外层for循环指定一个元素与内层for循环中的每一个元素进行对比，
     *                  如果当前一轮的外层for循环指定的元素在内层中没有相同元素，则赋值给新建的数组中去
     *                  （注意事项：①新数组的最大长度等于原数组的元素个数
     *                             ②新数组需要一个新的变量来表示其中的元素个数
     *                   ）
     * @param a
     */
    public void different1(Object[] a) {//true代表元素各不相同
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

    public void different(Object[] a, boolean flag) {//true代表元素各不相同
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
        if (this.n > 0) {
            str += this.element[0].toString();
            for (int i = 1; i < this.n; i++) {
                str += (", " + this.element[i].toString());
            }
        }
        // 执行T类的toString()方法，运行时多态
        return str + ") "; // 空表返回()
    }

    public String toS(Object[] element_different) {
        String str = this.getClass().getName() + "(";// 返回类名
        if (this.n1 > 0) {
            str += this.element_different[0].toString();
            for (int i = 1; i < this.n1; i++) {
                str += (", " + this.element_different[i].toString());
            }
        }
        // 执行T类的toString()方法，运行时多态
        return str + ") " + "____________different"; // 空表返回()
    }

    //i代表插入到第几个位置（注意：不是下标索引的位置）
    public void insert(int i, T x) {
        if (i <= 0) {
            throw new RuntimeException("該位置不存在");
        } else if (i >= n) {
            if (n == element.length) {
                addSize();
            }
            element[this.n] = x;
        } else {//存在一个问题：当数组元素个数n=element.lenght时，该分支步骤不会进行扩容
            //扩容
            addSize();
            //移位，从最后往第i个元素进行元素移位
            for (int j = n - 1; j >= i - 1; j--) {
                element[j + 1] = element[j];//数组中的前一个元素赋值给后一个
            }
            element[i - 1] = x;
        }
        this.n++;
    }

    private void copyArray_0(Object[] element, int i, Object[] newElement) {

    }

/*
	public void insert(int i, T x){
		if (n == element.length - 2){//元素个数n差2个超出数组element长度，进行扩容，并且插入元素
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
            if (checkSize()) {//检查数组空余空间大小，如果过大，则压缩空间大小（第1题）
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

    public boolean isEmpty() { // 判断顺序表是否空
        return this.n > 0 ? false : true;
    }

    public int size() {
        return this.n;
    }

    //一般针对数据类型为int，double，或者float型的（第3题）
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

    //差集（第4题）
    //问题：这个方法使用静态static的会报错，而我不太理解static的使用，以及为什么会使用static这样的方法
    public static double[] differentSet(double[] a, double[] b) {
        double[] dSet = new double[a.length > b.length ? a.length : b.length];
        for (int i = 0; i < (a.length > b.length ? a.length : b.length); i++) {
            dSet[i] = a[i] - b[i];
        }

        return dSet;
    }
}
