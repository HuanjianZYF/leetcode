package Z421_440;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/28 13:31
 **/
public class FindAllAnagramsInAString438 {

    /**
     * TLE了 晚点优化
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();
        for (int i = 0; i <= len1 - len2; i++) {
            if (isAnagram(s.substring(i, i + p.length()), p)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isAnagram(String s, String t) {
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
