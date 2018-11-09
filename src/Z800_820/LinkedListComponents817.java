package Z800_820;

import java.util.*;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/9 15:56
 **/
public class LinkedListComponents817 {
    private static ListNode head ;

    static {
        head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);
    }

    public static void main(String[] args) {
        System.out.println(new LinkedListComponents817().numComponents(head , new int[]{3,0,2}));
    }

    /**
     * G是head的子集，找到G里所有的元素，在head里是连续的最大长度
     * 1. 最笨的办法：遍历链表，在G里面看每个元素是不是在里面，显然TLE了
     * 2. 遍历链表，把里面的元素信息拿出来，对比它的子集，在子集空出来的地方填上-1，再分析出最长的
     * @param head 链表的头结点
     * @param G 子集
     * @return
     */
    public int numComponents(ListNode head, int[] G) {
        // 1. 将链表的子集里面没有的元素替换成-1
        Arrays.sort(G);
        ListNode ptr = head;
        while (ptr != null) {
            int value = ptr.val;
            if (Arrays.binarySearch(G, value) < 0) {
                ptr.val = -1;
            }
            ptr = ptr.next;
        }

        // 2. 得到块数
        int result = 0;
        boolean last = true;
        ptr = head;
        while (ptr != null) {
            if (ptr.val != -1 && last) {
                result++;
            }
            last = ptr.val == -1;
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


