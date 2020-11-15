package old.code_teacher_0.node.test;

public class SinglyList<T> {
    public Node<T> head;
    public int length;

    public SinglyList(T values[]) {
        if (values != null && values.length > 0) {
            for (T data :
                    values) {
                Node node = new Node<T>(data, null);
                insert(0, node, true);
            }
        }
    }

    public int getLength() {
        length = 0;
        Node<T> node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    /*
        不太明白插入的代码实现，不过它的逻辑我还是比较能理解的
     */
    //插入的方法为什么需要将返回值设置为Node节点类型的，而不设置为void类型的呢？
    public Node<T> insert(int i, Node<T> node, boolean order) {
        if (i == 0 && !order) {//插入到单链表头，直接将头节点
            node.next = head;
            head = node;
            return node;
        } else if (order) {
            if (head == null) {
                node.next = head;
                head = node;
            } else {
                Node<T> temp = head;
                while (temp.next != null) {//判断节点地址域不为空
                    temp = temp.next;
                }
                temp.next = node;
            }
        }

        return null;
    }
/*

    //  i代表插入节点的索引位置，n代表插入的节点本身，order代表插入节点的顺序（true代表从左到右插入，false代表从右往左插入）
    public void insert(int i, Node n, boolean order){

    }
*/

    @Override
    public String toString() {
        //默认调用每个节点的toString方法
        String str = this.getClass().getName() + "(";// 返回类名
        Node<T> node = head;
        while (node != null) {
            if(null == node.next){
                str += node.data.toString();
            }else{
                str += node.data.toString() + ", ";
            }
            node = node.next;
        }

        return str + ")";
    }

    public static void main(String[] args) {
        String values[] = {"A", "B", "C", "D", "E"};
        SinglyList<String> sl = new SinglyList<>(values);
        System.out.println("单链表的（参考）元素表为：" + sl.toString());
        System.out.println("单链表的长度（或者元素个数）为：" + sl.getLength());
        sl.insert(3, new Node("G", null), true);//false代表逆序插入
        System.out.println("单链表的（参考）元素表为：" + sl.toString());
        System.out.println("单链表的长度（或者元素个数）为：" + sl.getLength());
    }
}
