package code.ch02;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		String values[] = { "A", "B", "C", "D", "E" };
		SeqList<String> lista = new SeqList<String>(values);
		lista.insert(15, "XXX");
		System.out.println(lista);
	}

}
