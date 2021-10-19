package 面试题;

public class 环链表环的长度 {
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
        node5.next = node2;
        System.out.println(isCycle(node1));
        System.out.println(isCycle1(node1));
    }

    private static ListNode p1;
    private static ListNode p2;

    public static int isCycle(ListNode listNode) {
        p1 = listNode;
        p2 = listNode;
        int n = 0;
        int l = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            l++;
            if (p1 == p2) {
                n++;
                if (n == 2) {
                    return l;
                } else {
                    l = 0;
                }
            }
        }
        return l;
    }

    //如果慢指针走了x步，那么快指针走了2x步。已知快指针比慢指针多走了一个闭环链表的长度。所以闭环长度就是指针移动的步数。
    public static int isCycle1(ListNode listNode) {
        p1 = listNode;
        p2 = listNode;
        int l = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            l++;
            if (p1 == p2) {
                break;
            }
        }
        return l;
    }
}
