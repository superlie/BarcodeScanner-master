public class reverseListNode {

    public static ListNode reverse(ListNode head,int from,int to){
        int len =0;
        ListNode node1 = head;

        ListNode pre = null;
        ListNode last =null;


        while(node1 !=null){
                len++;
                pre = len ==from-1?node1:pre;
                last = len == to+1?node1:last;
                node1= node1.next;
        }
        if(from>to||from<1||to>len) {
            return head;
        }
        node1 = pre == null?head:pre.next;

        ListNode node2 =node1.next;
        node1.next = last;
        while(node2!=last){
            ListNode temp = node2.next;
            node2.next = node1;
            node1 = node2;
            node2  = temp;
        }
        if(pre!=null){
            pre.next = node1;
            return head;
        }
        return node1;



    }
    public static ListNode reverseList(ListNode head) {

        //递归解法
        /*if(head == null || head.next ==null)
            return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;*/
        //非递归解法
        ListNode listNode = head;
        if(head==null){
            return null;
        }
        while(listNode.next!=null){
            ListNode temp = listNode.next;

            listNode.next =temp.next;
            temp.next =head;
            head=temp;
        }
        return head;
    }
    public static ListNode reverse2(ListNode head,int from,int to) {
        int len = 0;
        ListNode node1 = head;
        ListNode pre = null;
        ListNode last = null;
        while(node1!=null){
            len++;
            pre = len==from-1?node1:pre;   //如果在len++的过程中，找到了from前一个，那就将pre定为此时累加到的这个节点
            last = len==to+1?node1:last;    //同理，如果在len++过程中找到了to后面的一个，就赋值为当前点，否则均为null
            node1 = node1.next;
        }
        if(from>to||from<1||to>len) {
            return head;
        }
        node1 = pre==null?head:pre.next;    //看是否需要换头，如果pre==null的时候，头结点要换了，就是从原头开始换
        ListNode node2 = node1.next;
        node1.next = last;       //将原来的头连至to+1
        ListNode next = null;
        while(node2!=last) {     //下一位依次指向前
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(pre!=null) {          //如果pre存在的时候，接到pre（from-1）后面
            pre.next = node1;
            return head;
        }
        return node1;     //否则不用拼接，直接是倒转之后的新头结点
    }

    public  static  void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode temp =head;
        for(int i =2;i<=6;i++){
            if(temp.next ==null)
                temp.next = new ListNode(i);

            temp = temp.next;
        }
        ListNode newHead = reverse(head,3,5);
        while(newHead!=null){
            System.out.print(newHead.val+" -> ");
            newHead = newHead.next;
        }

    }

}
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }