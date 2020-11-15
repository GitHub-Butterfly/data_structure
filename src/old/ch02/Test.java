package old.ch02;

public class Test {

	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "E" };
		SeqList<String> lista = new SeqList<String>(values);
		System.out.println(lista);
		lista.insert(15, "XXX");
		System.out.println(lista);
		lista.remove(0);
		System.out.println(lista);
	}

}
