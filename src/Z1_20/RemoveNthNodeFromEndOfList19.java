package Z1_20;

/**
 * @Author wb-zyf471922
 * @Date 2019/4/28 15:52
 **/
public class RemoveNthNodeFromEndOfList19 {

    /**
     * 移除链表倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = caculateLen(head);
        if (n == len) {
            return head.next;
        }

        ListNode ptr = head;
        int ord = len - n ;
        for (int i = 0; i <= ord - 2; i++) {
            ptr = ptr.next;
        }

        ptr.next = ptr.next.next;

        return head;
    }

    private int caculateLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }

        return len;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
