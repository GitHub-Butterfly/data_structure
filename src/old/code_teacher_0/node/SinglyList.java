package old.code_teacher_0.node;

/**
 * ��������headһ��ָ��ͷ�ڵ㣿����
 *
 * @param <T>
 */

public class SinglyList<T> {
    public Node<T> head;
    public int length;

    //��������
    public SinglyList() {
        head = new Node(null, null);
    }

/*
    public SinglyList(T values[]) {
        if (values != null && values.length > 0) {
            for (T data :
                    values) {
                Node node = new Node<T>(data, null);
                insert(0, node, true);
            }
        }
    }
*/

    public int getLength() {
        length = 0;
/*
        Node<T> node = head;
*/
        Node<T> node = head.next;//��headһ��ָ��ͷ�ڵ㣿����
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /*
        ��̫���ײ���Ĵ���ʵ�֣����������߼��һ��ǱȽ�������
     */
    //����ķ���Ϊʲô��Ҫ������ֵ����ΪNode�ڵ����͵ģ���������Ϊvoid���͵��أ�
    public void insert(int i, Node<T> node, boolean order) {
        if (i == 0 && !order) {//���뵽������ͷ
            node.next = head;
            head = node;
        } else if (order) {
            if (head == null) {//���뵽������ͷ
                node.next = head;
                head = node;
            } else {//���뵽������β�������м䲿λ
                /*Node<T> temp = head;
                for (int j = 0; j < i; j++) {
                    if (temp.next != null) {
                        temp = temp.next;
                    }
                }
                temp.next = node;
                if (i >= getLength()) {
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    temp.next = node;
                }*/

                Node<T> temp = head;
                while (temp.next != null) {//�жϽڵ��ַ��Ϊ��
                    temp = temp.next;
                }
                temp.next = node;
            }
        }
    }


    //����P28����ͷ�ڵ�
    public void insert(int i, Object x) {
        //ʹ��head.next;
        Node<T> p = head.next;
        int j = -1;
        while (true) {

        }
    }

/*

    //  i�������ڵ������λ�ã�n�������Ľڵ㱾��order�������ڵ��˳��true��������Ҳ��룬false�������������룩
    public void insert(int i, Node n, boolean order){

    }
*/

    @Override
    public String toString() {
        //Ĭ�ϵ���ÿ���ڵ��toString����
        String str = this.getClass().getName() + "(";// ��������
        /*Node<T> node = head;*/
        Node<T> node = head.next;
        while (node != null) {
            if (null == node.next) {
                str += node.data.toString();//--------
            } else {
                str += node.data.toString() + ", ";
            }
            node = node.next;//------
        }

        return str + ")";
    }

    public static void main(String[] args) {
        /*String values[] = {"A", "B", "C", "D", "E"};*/
        SinglyList<String> sl = new SinglyList<>();//�����������
        for (int i = 0; i < 5; i++) {//����0-4�⼸����
            sl.insert(0, i);//����ڵ�
        }
        System.out.println("������ģ��ο���Ԫ�ر�Ϊ��" + sl.toString());
        System.out.println("������ĳ��ȣ�����Ԫ�ظ�����Ϊ��" + sl.getLength());
        sl.insert(3, new Node("G", null), true);//false�����������
        System.out.println("������ģ��ο���Ԫ�ر�Ϊ��" + sl.toString());
        System.out.println("������ĳ��ȣ�����Ԫ�ظ�����Ϊ��" + sl.getLength());
    }
}

