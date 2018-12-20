package Z221_240;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/20 14:24
 **/
public class PalindromeLinkedList234 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return isPalindrome(list);
    }

    private boolean isPalindrome(List<Integer> list) {
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 0; i <= list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
