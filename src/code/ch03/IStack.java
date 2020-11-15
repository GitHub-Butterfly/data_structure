package code.ch03;

public interface IStack<T> {
	public void clear();// 将栈置空

	public boolean isEmpty();// 判断栈是否为空

	public int length();// 返回栈的数据元素个数

	public T peek();// 返回栈顶元素

	public void push(T x) throws Exception;// 将数据元素x入栈

	public Object pop();// 将栈顶元素出栈并返回

	public void display();// 输出栈中的所有元素

}
