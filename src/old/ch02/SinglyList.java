package old.ch02;

public class SinglyList<T> {
    public Node<T> head; // 头指针
    int t;//计数器？不一定需要

    public SinglyList() { // 构造空表
        head = new Node<T>(null, null);
    }

    public SinglyList(T[] values) {
    }

    public boolean isEmpty() {
        return head.next == null ? true : false;
    }

    // 返回第i个元素
    public T get(int i) {
        Node<T> p = head.next;
        for (int j = 0; j < i && p != null; j++) {
            p = p.next;
        }
        return p.data;
    }

    public void set(int i, T x) { // 设置第i个元素为x
        Node<T> p = head.next;
        for (int j = 0; j < i && p != null; j++) {
            p = p.next;
        }
        p.data = x;
    }

    public int size() { // 长度
        Node<T> p = head.next;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        return size;
    }

    public String toString() {
        int n = 0;
        Node<T> p = head.next;
        String str = "";
        while (p != null) {
            n++;
//            System.out.println("..........");//测试
            if (n == 50) {
                break;
            }
            str += p.toString() + ",";
            p = p.next;
        }
        return str;
    }

    public Node<T> insert(int i, T x) {
        if (x == null) {
            throw new RuntimeException("不能插入NULL！");
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

    // 插入x作为第i个元素
    public Node<T> insert(T x) { // 尾插入
        return insert(Integer.MAX_VALUE, x);
    }

	public T remove(int i) { // 删除第i个元素
		Node<T> p = head;
		for (int j = 0; j < i && p.next.next != null; j++) {
			p = p.next;
		}
		T data = p.next.data;
		p.next = p.next.next;

		//检查数组空间

		return data;
	}

	public void clear() {
		head.next = null;
	}

	//约瑟夫环，
	// n代表开始参加报数的人数，m是为下一次要出列的人所报出的数字序号，s为最开始报数的那个人的编号  5, 3, 1
	//第5题
	public void losephus(int n, int m, int s) {
        /*for (int i = 0; i < 5; i++) {
            insert(1, (T)("" + i));//？为什么不能用insert(2, "" + i);
        }*/
        //让链表首尾相连
//        System.out.println(head.data);
        Node<T> p = head;
        for (int i = 0; i < n && p.next.next != null; i++) {
            p = p.next;
        }
        /*if (p.next.next == null) {
            p.next = head;
        }else{
            throw new RuntimeException("元素个数为0");
        }*/
        p = p.next;
        p.next = head.next;

        //将指针指向s的位置
        Node<T> p1 = head;
        for (int i = 0; i < s; i++) {
            p1 = p1.next;
        }
        System.out.println("-------");

//        t = 5;//给计数器赋值
        //死循环，直到只剩下一个“人”
        while (n > 1) {
            //移除第m个位置
            for (int i = 0; i < m - 1; i++) {
                p1 = p1.next;
            }
            T data = p1.next.data;
            p1 = p1.next.next;
            n--;
            System.out.println("删除了第" + data + "个元素");
        }
        System.out.println("剩到最后的是：" + p1.next.next.data);


        /*
        //测试
        System.out.println("======>");
        System.out.println(head.next);
        System.out.println("toString()");*/
	}

    public static void main(String[] args) {
        SinglyList<String> sl = new SinglyList<>();
        for (int i = 1; i <= 6; i++) {
            sl.insert(5, "" + i);
        }
        System.out.println(sl);
//        sl.set(1, "100");//1代表的是下标位置
        System.out.println(sl);//会自动调用toString方法

		// n代表开始参加报数的人数，m是为下一次要出列的人所报出的数字序号，s为最开始报数的那个人的编号
        sl.losephus(6, 2, 1);
        System.out.println(sl);
    }
}
