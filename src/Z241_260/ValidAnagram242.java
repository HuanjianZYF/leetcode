package Z241_260;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/14 15:36
 **/
public class ValidAnagram242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        // 写法是越来越骚了
        for (int i = 0; i <= s.length() - 1; i++) {
            map1.merge(s.charAt(i), 1, Math::addExact);
        }

        for (int i = 0; i <= t.length() - 1; i++) {
            map2.merge(t.charAt(i), 1, Math::addExact);
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if (!value.equals(map2.get(key))) {
                return false;
            }
        }

        return true;
    }
}
