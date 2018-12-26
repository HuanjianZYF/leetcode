package Z381_400;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/26 15:35
 **/
public class FindTheDifference389 {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            map1.merge(s.charAt(i), 1, Math::addExact);
        }
        for (int i = 0; i <= t.length() - 1; i++) {
            map2.merge(t.charAt(i), 1, Math::addExact);
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (map1.get(key) == null || map1.get(key) < value) {
                return key;
            }
        }
        return ' ';
    }
}
