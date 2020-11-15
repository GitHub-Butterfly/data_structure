package old.code_teacher_0.node;

/**
 * 节点类  T：表示是节点类型
 * @param <T>
 */

public class Node<T> {
    public T data;//数据域，保存数据元素
    public Node<T> next;//地址域，引用后继节点

    public Node() {
        this.data  = null;
        this.next = null;
    }
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
