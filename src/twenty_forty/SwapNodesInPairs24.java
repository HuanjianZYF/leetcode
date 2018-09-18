package twenty_forty;

import one_twenty.AddTwoNum2;

/**
 * @author zyf
 * @date 2018/9/18 上午11:58
 */
public class SwapNodesInPairs24 {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node1 = head;
		ListNode node2 = head.next;
		node1.next = swapPairs(node2.next);
		node2.next = node1;
		
		return node2;
	}

	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
