package Z61_80;


public class RotateList61 {

    /**
     * 旋转链表，先找到需要前进多少个节点，再修改联表结构，返回
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = len(head);

        // 原先的第一个节点到哪个位置,假设下标从0开始
        int first2Pos = k % len;
        ListNode ptr = head;
        ListNode end = ptr;
        for (int i = first2Pos; i <= len - 2; i++) {
            ptr = ptr.next;
            end = ptr;
        }

        for (int i = 0; i <= first2Pos - 1; i++) {
            end = end.next;
        }

        end.next = head;
        head = ptr.next;
        ptr.next = null;

        return head;
    }

    private int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


