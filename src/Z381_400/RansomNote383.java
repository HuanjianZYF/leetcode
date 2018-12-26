package Z381_400;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/25 17:32
 **/
public class RansomNote383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i <= ransomNote.length() - 1; i++) {
            map1.merge(ransomNote.charAt(i), 1, Math::addExact);
        }
        for (int i = 0; i <= magazine.length() - 1; i++) {
            map2.merge(magazine.charAt(i), 1, Math::addExact);
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.get(key) == null || map2.get(key) < value) {
                return false;
            }
        }

        return true;
    }
}
