package 面试题;

public class 闭环入环点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        System.out.println(isCycle(node1).val);
    }

    private static ListNode p1;
    private static ListNode p2;

    public static ListNode isCycle(ListNode head) {
        //在慢指针与快指针相遇的时候，慢指针与闭环起点的距离其实跟链表起点和闭环起点的距离是一样的。
        //思考一下：慢指针走了x步，通过上面的阅读，我们知道闭环的长度也是x，这也就意味着我们已经走了一个闭环的长度但是我们没走完一个闭环是因为链表的起点与闭环的起点有一定距离，
        //那么慢指针与闭环起点的距离就是链表头与闭环起点的距离。
        //
        p1 = head;
        p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }

        ListNode root=head;
        while (root!=p1){
            root=root.next;
            p1=p1.next;
        }
        return root;
    }
}
