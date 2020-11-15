package old.start_1;

import java.util.Scanner;

public class IsPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number_int = sc.nextInt();
        System.out.println(isPrimeNumber(number_int));
    }

    private static boolean isPrimeNumber(int number_int) {
        /**
         * 条件判断的其它形式：i < number_int / 2 或 i * i < number_int
         */
        for (int i = 2; i < number_int - 1; i++) {
            if (number_int % i == 0) {
                return false;
            }
        }

        return true;
    }
}
