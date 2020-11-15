package old.code_teacher_0.sep_list;

public class Test {

	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "E", "E"};
		SeqList<String> lista = new SeqList<String>(values);
		System.out.println("初始：" + lista);
		lista.insert(2, "XXX");//插入参数i代表第几个元素
		System.out.println("插入后：" + lista);
		System.out.println("空间大小 = " + lista.element.length);
		System.out.println("元素个数 = " + lista.n);
		lista.remove(1);//删除参数代表删除第几个
		System.out.println("删除后：" + lista);
		System.out.println("空间大小 = " + lista.element.length);
		System.out.println("元素个数 = " + lista.n);

		lista.different1(lista.element);
		System.out.println("（复制的）不同元素为：" + lista.toS(lista.element_different));

		System.out.println("当前元素为：" + lista);
		/*lista.different(lista.element, true);
		System.out.println("去重后：" + lista);*/
//		System.out.println("element[2] = " + (int)'c');
		System.out.println("最大值 = " + lista.max_element());

		double[] a = {1, 2, 3.0};
		double[] b = {3, 2.0, 1};
		double[] c = lista.differentSet(a, b);
		for (int i = 0; i < c.length; i++) {
			System.out.print("===" + c[i]);
		}
        System.out.println();
        /*System.out.println(lista.element_different[4]);
        System.out.println(lista.element_different[5]);
        System.out.println(lista.element[4]);
        System.out.println(lista.element[5]);
        if (lista.element_different[4]==(lista.element[5])) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }*/
	}
}
