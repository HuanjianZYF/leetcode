package Z141_160;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/14 14:11
 **/
public class LinkedListCycle141 {

    /**
     * 判断一个链表有没有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode outNode = new ListNode(0);
        ListNode ptr = head;

        while (true) {
            head = head.next;
            ptr.next = outNode;
            ptr = head;
            if (head == null) {
                return false;
            }
            if (head.next == outNode) {
                return true;
            }
        }
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
