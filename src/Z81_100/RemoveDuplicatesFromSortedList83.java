package Z81_100;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/28 20:01
 **/
public class RemoveDuplicatesFromSortedList83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ptr = head;
        int lastValue = head.val;
        while (ptr.next != null) {
            if (ptr.next.val == lastValue) {
                ptr.next = ptr.next.next;
            } else {
                lastValue = ptr.next.val;
                ptr = ptr.next;
            }
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
