package Z701_720;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/20 11:05
 **/
public class DesignHashMap706 {

    private class MyHashMap {

        private Map<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            map = new HashMap<>();
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            map.put(key, value);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            Integer result = map.get(key);
            if (result == null) {
                return -1;
            }

            return result;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            map.remove(key);
        }
    }
}
