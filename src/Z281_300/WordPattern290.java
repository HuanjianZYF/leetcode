package Z281_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/21 17:46
 **/
public class WordPattern290 {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i <= pattern.length() - 1; i++) {
            String s = map.get(pattern.charAt(i));
            if (s == null) {
                if (hasThisStr(map, strs[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
            } else {
                if (!s.equals(strs[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasThisStr(Map<Character, String> map, String s) {
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            if (s.equals(entry.getValue())) {
                return true;
            }
        }

        return false;
    }
}
