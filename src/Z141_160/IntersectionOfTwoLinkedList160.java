package Z141_160;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/14 14:35
 **/
public class IntersectionOfTwoLinkedList160 {

    /**
     * 找到两个链表的交叉的部分
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
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
