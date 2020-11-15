package old.start_1;

public class ZhiShu {
    public static void main(String[] args) {
        boolean a=true;
        for (int i = 2; i < 100; i++) {
            if (i == 2) {
                System.out.print(i+" ");
            } else{
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        a=false;
                        break;
                    }

                }
                if (a) {
                    System.out.print(i+" ");
                }
                a=true;

        }
        }
    }
}
