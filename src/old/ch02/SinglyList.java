package old.ch02;

public class SinglyList<T> {
    public Node<T> head; // ͷָ��
    int t;//����������һ����Ҫ

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
        int n = 0;
        Node<T> p = head.next;
        String str = "";
        while (p != null) {
            n++;
//            System.out.println("..........");//����
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

	public T remove(int i) { // ɾ����i��Ԫ��
		Node<T> p = head;
		for (int j = 0; j < i && p.next.next != null; j++) {
			p = p.next;
		}
		T data = p.next.data;
		p.next = p.next.next;

		//�������ռ�

		return data;
	}

	public void clear() {
		head.next = null;
	}

	//Լɪ�򻷣�
	// n����ʼ�μӱ�����������m��Ϊ��һ��Ҫ���е�����������������ţ�sΪ�ʼ�������Ǹ��˵ı��  5, 3, 1
	//��5��
	public void losephus(int n, int m, int s) {
        /*for (int i = 0; i < 5; i++) {
            insert(1, (T)("" + i));//��Ϊʲô������insert(2, "" + i);
        }*/
        //��������β����
//        System.out.println(head.data);
        Node<T> p = head;
        for (int i = 0; i < n && p.next.next != null; i++) {
            p = p.next;
        }
        /*if (p.next.next == null) {
            p.next = head;
        }else{
            throw new RuntimeException("Ԫ�ظ���Ϊ0");
        }*/
        p = p.next;
        p.next = head.next;

        //��ָ��ָ��s��λ��
        Node<T> p1 = head;
        for (int i = 0; i < s; i++) {
            p1 = p1.next;
        }
        System.out.println("-------");

//        t = 5;//����������ֵ
        //��ѭ����ֱ��ֻʣ��һ�����ˡ�
        while (n > 1) {
            //�Ƴ���m��λ��
            for (int i = 0; i < m - 1; i++) {
                p1 = p1.next;
            }
            T data = p1.next.data;
            p1 = p1.next.next;
            n--;
            System.out.println("ɾ���˵�" + data + "��Ԫ��");
        }
        System.out.println("ʣ�������ǣ�" + p1.next.next.data);


        /*
        //����
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
//        sl.set(1, "100");//1��������±�λ��
        System.out.println(sl);//���Զ�����toString����

		// n����ʼ�μӱ�����������m��Ϊ��һ��Ҫ���е�����������������ţ�sΪ�ʼ�������Ǹ��˵ı��
        sl.losephus(6, 2, 1);
        System.out.println(sl);
    }
}
