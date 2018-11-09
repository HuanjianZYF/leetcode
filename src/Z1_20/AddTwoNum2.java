package Z1_20;

/**
 * @author zyf
 * @date 2018/9/5 下午5:57
 */
public class AddTwoNum2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0); 
		ListNode point = result;
		
		int lastBit = 0;
		while (l1 != null || l2!= null || lastBit == 1) { //只有两个列表都空了才终止
			lastBit = mergeTwoNode(l1, l2, lastBit, point);
			point = point.next;
			if (l1 != null) {
				l1 = l1.next;
			} 
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		
		return result.next;
	}
	
	//结合两个节点，将他们的值相加，留下个位数成为result的下一个节点，并返回进位
	private int mergeTwoNode(ListNode node1, ListNode node2, int addBit, ListNode resultNode) {
		int value1 = 0;
		int value2 = 0;
		if (node1 != null) {
			value1 = node1.val;
		}
		if (node2 != null) {
			value2 = node2.val;
		}
		
		int sum = value1 + value2 + addBit;
		if (sum >= 10) {
			ListNode node = new ListNode(sum % 10);
			resultNode.next = node;
			return 1;
		} else {
			ListNode node = new ListNode(sum);
			resultNode.next = node;
			return 0;
		}
	}

	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

} 
