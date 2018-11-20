package Z701_720;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/20 10:59
 **/
public class DesignHashSet705 {

    private class MyHashSet {

        private Set<Integer> set;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            set = new HashSet<>();
        }

        public void add(int key) {
            set.add(key);
        }

        public void remove(int key) {
            set.remove(key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return set.contains(key);
        }
    }
}
