package old.teaching_material_h;

import java.util.Scanner;

public class P13_3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        System.out.println(calculateI(in));
        System.out.println("时间复杂度为O(n)。");
    }

    private static int calculateI(int in) {
        int sum = 0;
        for (int i = 1; i <= in; i++) {
                    sum += i;
        }

        return sum;
    }
}
