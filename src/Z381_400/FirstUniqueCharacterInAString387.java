package Z381_400;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/26 15:29
 **/
public class FirstUniqueCharacterInAString387 {

    public int firstUniqChar(String s) {
        Set<Character> notUniqueChar = new HashSet<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            if (!notUniqueChar.contains(s.charAt(i))) {
                if (isUnique(s, i)) {
                    return i;
                } else {
                    notUniqueChar.add(s.charAt(i));
                }
            }
        }
        return -1;
    }

    private boolean isUnique(String s, int pos) {
        return s.indexOf(s.charAt(pos), pos + 1) < 0;
    }
}
