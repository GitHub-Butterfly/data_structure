package code.ch03;

public interface IQueue<T> {
	public void clear();// 将队列置空

	public boolean isEmpty();// 判断队列是否为空

	public int length();// 返回队列的数据元素个数

	public T peek();// 返回队首元素

	public void offer(T x) throws Exception;// 将数据元素x插入到队列成为队尾元素

	public T poll();// 将队首元素删除并返回其值

	public void display();// 输出队列中的所有数据元素

}
