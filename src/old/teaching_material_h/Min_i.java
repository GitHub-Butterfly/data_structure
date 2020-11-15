package old.teaching_material_h;

import java.util.Scanner;

public class Min_i {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("最小的i值为：" + least_i(n));
        System.out.println("时间复杂度为O(n)。");
    }

    private static int least_i(int n) {
        int sum = 0;
        int num = 1;
        for (int i = 1; i < n; i++) {
            sum += i;
            if (sum >= n){
                return i;
            }
        }
        return num;
    }
}
