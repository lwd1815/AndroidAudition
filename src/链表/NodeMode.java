package 链表;

public class NodeMode {
    //链表的增删改查
    public static void main(String[] args) {
        NodeAr nodeAr = new NodeAr();
        nodeAr.insert(0, 1);
        nodeAr.insert(1, 3);
        nodeAr.insert(2, 7);
        nodeAr.insert(3, 0);
        nodeAr.insert(4, 2);
        nodeAr.insert(5, 9);
        nodeAr.insert(2, 5);
        nodeAr.output();
        nodeAr.reverseList();
        System.out.println("---------------------------------------");
        nodeAr.output();
        nodeAr.reverseList2(nodeAr.getNode());
        System.out.println("****************************************");
        nodeAr.output();
    }
}


class NodeAr {
    private Node head;
    private Node last;
    private int size;
    private Node insertNode;

    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        insertNode = new Node(data);
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            insertNode.next = head;
            head = insertNode;
        } else if (index == size - 1) {
            last.next = insertNode;
            last = insertNode;
        } else {
            Node pro = get(index - 1);
            insertNode.next = pro.next;
            pro.next = insertNode;
        }
        size++;
    }

    public Node getNode() {
        return head;
    }

    public Node remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node remove = null;
        if (index == 0) {
            remove = head;
            head = head.next;
        } else if (index == size - 1) {
            Node pro = get(index - 1);
            remove = pro.next;
            pro.next = null;
            last = pro;
        } else {
            Node pro = get(index - 1);
            remove = pro.next;
            pro.next = pro.next.next;
        }
        size--;
        return remove;
    }

    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node output() {
        Node temp = head;
        while (temp != null) {
            System.out.println("temp===" + temp.data);
            temp = temp.next;
        }

        return temp;
    }

    //链表非递归形式反转
    public Node reverseList() {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head = pre;
        return pre;
    }

    //链表递归形式反转

    public Node reverseList2(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        this.head = newHead;
        return newHead;
    }
}
