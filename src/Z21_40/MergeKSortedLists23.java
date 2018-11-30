package Z21_40;


/**
 * @Author wb-zyf471922
 * @Date 2018/11/30 10:14
 **/
public class MergeKSortedLists23 {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        listNodes[0] = listNode1;
        listNodes[1] = listNode2;
        listNodes[2] = listNode3;

        new MergeKSortedLists23().mergeKLists(listNodes);
    }

    /**
     * 合并k个链表
     * 名不符实的hard题
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length != 1) {
            lists = lianglianghebing(lists);
        }

        return lists[0];
    }

    private ListNode[] lianglianghebing(ListNode[] listNodes) {
        boolean isOdd = listNodes.length % 2 == 1;
        int size = isOdd ? listNodes.length / 2 + 1 : listNodes.length / 2;
        ListNode[] result = new ListNode[size];
        for (int i = 0; i <= size - 2; i++) {
            result[i] = mergeTwoList(listNodes[2 * i], listNodes[2 * i + 1]);
        }
        if (isOdd) {
            result[size - 1] = listNodes[listNodes.length - 1];
        } else {
            result[size - 1] = mergeTwoList(listNodes[listNodes.length - 2], listNodes[listNodes.length - 1]);
        }

        return result;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode result = new ListNode(0);
        ListNode ptr = result;
        while (list1 != null || list2 != null) {

            if (list1 == null) {
                ptr.next = new ListNode(list2.val);
                list2 = list2.next;
                ptr = ptr.next;
                continue;
            }
            if (list2 == null) {
                ptr.next = new ListNode(list1.val);
                list1 = list1.next;
                ptr = ptr.next;
                continue;
            }

            if (list1.val < list2.val) {
                ptr.next = new ListNode(list1.val);
                ptr = ptr.next;
                list1 = list1.next;
            } else {
                ptr.next = new ListNode(list2.val);
                ptr = ptr.next;
                list2 = list2.next;
            }
        }

        return result.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
