package code.ch02;

public interface IList {

	public void clear();// 将线性表置成空表

	public boolean isEmpty();// 判断线性表是否为空表

	public int length();// 返回线性表的长度

	public Object get(int i) throws Exception;// 读取并返回线性表中第i个数据元素

	public void insert(int i, Object x) throws Exception;// 插入x作为第i个元素

	public void remove(int i) throws Exception; // 删除第i个元素

	public int indexOf(Object x);// 返回元素x首次出现的位序号

	public void display();// 输出线性表中各个数据元素的值

}
