package old.code_teacher_0.sep_list;

public class Test {

	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "E", "E"};
		SeqList<String> lista = new SeqList<String>(values);
		System.out.println("��ʼ��" + lista);
		lista.insert(2, "XXX");//�������i����ڼ���Ԫ��
		System.out.println("�����" + lista);
		System.out.println("�ռ��С = " + lista.element.length);
		System.out.println("Ԫ�ظ��� = " + lista.n);
		lista.remove(1);//ɾ����������ɾ���ڼ���
		System.out.println("ɾ����" + lista);
		System.out.println("�ռ��С = " + lista.element.length);
		System.out.println("Ԫ�ظ��� = " + lista.n);

		lista.different1(lista.element);
		System.out.println("�����Ƶģ���ͬԪ��Ϊ��" + lista.toS(lista.element_different));

		System.out.println("��ǰԪ��Ϊ��" + lista);
		/*lista.different(lista.element, true);
		System.out.println("ȥ�غ�" + lista);*/
//		System.out.println("element[2] = " + (int)'c');
		System.out.println("���ֵ = " + lista.max_element());

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
