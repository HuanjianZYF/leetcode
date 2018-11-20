package Z861_880;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/20 10:19
 **/
public class MiddleOfLinkedList876 {

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode ptr = head;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }

        if (count <= 1) {
            return head;
        }
        int mid = count / 2;
        for (int i = 0; i <= mid - 1; i++) {
            head = head.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
