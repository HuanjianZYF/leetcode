package Z401_420;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/27 17:10
 **/
public class LongestPalindrome409 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            map.merge(s.charAt(i), 1, Math::addExact);
        }

        int result = 0;
        int extra = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            boolean even = value % 2 == 0;
            if (!even) {
                extra = 1;
            }
            result +=  even ? value : value - 1;
        }

        return result + extra;
    }
}
