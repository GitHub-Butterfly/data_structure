package old.classmates;


import java.util.Scanner;

    public class HworkServen {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //n = 6, m = 3，k = 1）
            //n---总数,m--数到m出列,k--从1或0开始数
            while (sc.hasNext()){
                int n=sc.nextInt();
                int m=sc.nextInt();
                int k=sc.nextInt();
                if(k==0){
                    remove1(n,m,k);

                }
                if(k==1){
                    remove2(n,m,k);
                }
            }
        }

        //从0开始计数
        private static void remove1(int n,int m,int k){
            int [] number=new int[n];
            //活人为0,死人为-1
            int mark=-1;//活人标识
            int count=0;//死亡计数
            for (int i = 0; i < n; i++) {
                if(number[i] ==0){
                    mark++;//活人数目
                }
                if(mark==m){
                    number[i]=-1;
                    count++;
                    mark=-1;
                    if(count==n){
                        System.out.println("幸存者编号为"+i);
                    }else {
                        System.out.println("编号"+i+"的人死亡");
                    }
                }
                //继续进入下一轮循环
                if(i==n-1){
                    i=-1;
                }
            }

        }
        //从1开始计数
        private static void remove2(int n, int m, int k) {
            int[] number = new int[n];
            //活人为0,死人为-1
            int mark = 0;//活人标识
            int count = 0;//死亡计数
            for (int i = 0; i < n; i++) {
                if (number[i] == 0) {
                    mark++;//活人数目
                }
                if (mark == m) {
                    number[i] = -1;
                    count++;
                    mark = 0;
                    if (count == n) {
                        System.out.println("幸存者编号为" + (i+1));
                    } else {
                        System.out.println("编号" + (i+1) + "的人死亡");
                    }
                }
                if (i == n - 1) {
                    i = -1;
                }
            }
        }

    }

