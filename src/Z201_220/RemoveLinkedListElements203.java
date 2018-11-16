package Z201_220;

import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/16 11:38
 **/
public class RemoveLinkedListElements203 {

    public ListNode removeElements(ListNode head, int val) {

        //1. 找到第一个不为val的头结点
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }

        // 2. 去掉之后的值为val的节点
        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.next != null && ptr.next.val == val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
