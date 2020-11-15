package old.teaching_material_h;

import java.util.Scanner;

public class Particular_Multiplication_Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printMultiplicationTable(n);
        System.out.println("时间复杂度为O(n²)。");
    }

    private static void printMultiplicationTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print(" i * j = " + i * j + "\t");
            }
            System.out.println();
        }
    }
}
