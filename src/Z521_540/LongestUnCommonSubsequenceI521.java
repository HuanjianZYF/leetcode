package Z521_540;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/7 14:29
 **/
public class LongestUnCommonSubsequenceI521 {

    public int findLUSlength(String a, String b) {
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        if (a.length() != b.length()) {
            return b.length();
        } else {
            if (isAnagram(a, b)) {
                return -1;
            } else {
                return a.length();
            }
        }
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

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
