package Z201_220;

import java.util.Stack;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/16 13:49
 **/
public class ReverseLinkedList206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 把链表的值放在栈里
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        // 2. 再组装
        ListNode result = new ListNode(stack.pop());
        ListNode ptr = result;
        while (!stack.empty()) {
            ptr.next = new ListNode(stack.pop());
            ptr = ptr.next;
        }

        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
