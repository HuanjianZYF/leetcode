package Z221_240;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/16 15:02
 **/
public class DeleteNodeInlinkList237 {

    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
