package experiment;

import java.util.Scanner;

public class Լɪ�� {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("����������");
        int n = scanner.nextInt();
        int ring[] = new int[n];
        System.out.println("������ÿ�����˳���һ��");
        int m = scanner.nextInt();
        for (int i = 0; i < ring.length; i++) {
            ring[i] = i + 1;
        }
        int x = 0;
        int i = 0;
        int b = 0;//��������
        while (b < n - 1) {
            if ((x + 1) > ring.length) {
                x = x  % m;
            }if(i==ring.length){
                i=0;
            }
            if (ring[i] > 0) {
                x++;
                if (x  % m == 0) {
                    ring[i] = 0;
                    b++;
                    System.out.println("��"+(i+1)+"�˳���");
                }
            }
            i++;
        }
        for (int a = 0; a < ring.length; a++) {
            if (ring[a] != 0) {
                System.out.println(ring[a]);
                break;
            }
        }
    }
}