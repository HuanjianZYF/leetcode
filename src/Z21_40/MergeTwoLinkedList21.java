package Z21_40;

/**
 * @author zyf
 * @date 2018/9/14 下午5:54
 */
public class MergeTwoLinkedList21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode ptr = result;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				ptr.next = new ListNode(l2.val);
				ptr = ptr.next;
				l2 = l2.next;
				continue;
			}
			if (l2 == null) {
				ptr.next = new ListNode(l1.val);
				ptr = ptr.next;
				l1 = l1.next;
				continue;
			}
			
			int val1 = l1.val;
			int val2 = l2.val;
			
			if (val1 <= val2) {
				ptr.next = new ListNode(val1);
				ptr = ptr.next;
				l1 = l1.next;
			} else {
				ptr.next = new ListNode(val2);
				ptr = ptr.next;
				l2 = l2.next;
			}
		}
		
		return result.next;
	}

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
