package Z701_720;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/20 11:16
 **/
public class DesignLinkedList707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(4);
        linkedList.get(-1);
        linkedList.addAtHead(7);
        linkedList.addAtTail(1);
        linkedList.addAtIndex(1, 7);
    }

    private static class MyLinkedList {

        List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            list = new ArrayList<>();
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index > list.size() - 1 || index < 0) {
                return -1;
            }
            return list.get(index);
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will
         * be the first node of the linked list.
         */
        public void addAtHead(int val) {
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i <= list.size() - 1; i++) {
                newList.add(list.get(i));
            }

            list.clear();
            list.add(val);
            list.addAll(newList);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            list.add(val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
         * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
         * not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > list.size() || index < 0) {
                return;
            }
            List<Integer> temp = new ArrayList<>();
            int size = list.size();
            for (int i = index; i <= size - 1; i++) {
                temp.add(list.get(index));
                list.remove(index);
            }
            list.add(val);
            list.addAll(temp);
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= list.size() || index < 0) {
                return;
            }
            List<Integer> temp = new ArrayList<>();
            int size = list.size();
            for (int i = index ; i <= size - 1; i++) {
                temp.add(list.get(index));
                list.remove(index);
            }

            temp.remove(0);
            list.addAll(temp);
        }
    }
}
