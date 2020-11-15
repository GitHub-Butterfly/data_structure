package old.classmates;

public class HworkSerevnO {
    public static void count(int n){
        //数到3出局，中间间隔两个人
        int k = 3;
        //头结点不存储数据
        Nod head = new Nod();
        Nod cur = head;
        //循环构造这个链表
        for(int i=1;i<=n;i++){
            Nod nod = new Nod(i);
            cur.next = nod;
            cur = nod;
        }
        //链表有数据的部分首尾相连形成一个环。
        cur.next = head.next;
        //统计开始的时候，刨去头结点，然后从第一个有数据的结点开始报数
        Nod p = head.next;
        //循环退出的条件是最后只剩一个结点，也就是这个结点的下一个结点是它本身
        while(p.next!=p){
            //正常报数的遍历逻辑
            for(int i=1;i<k-1;i++){
                p = p.next;
            }
            //当数到3的时候，出局
            System.out.print(p.next.data+"->");
            p.next = p.next.next;
            p = p.next;
        }
        //最后剩下的一个结点
        System.out.println("(left:"+p.data+")");
    }

    public static void main(String[] args) {
        //以4个人为例，1234 : 最先出局的是3，然后剩下412,接着2出局，剩下41，这时候就是4出局，最后剩下1.
        count(4);
        //41个人为例，就是约瑟夫环的本身了，最后剩下的是31
        count(41);
    }

}

class Nod{
    int data;
    Nod next;
    public Nod(){}
    public Nod(int data){this.data = data;}
}

