package Z481_500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/2 17:31
 **/
public class KeyboardRaw500 {

    public String[] findWords(String[] words) {

        final Set<Character> FIRST_ROW = new HashSet<>();
        final Set<Character> SECOND_ROW = new HashSet<>();
        final Set<Character> THIRD_ROW = new HashSet<>();

        char[] chars = "QWERTYUIOP".toCharArray();
        for (char ch : chars) {
            FIRST_ROW.add(ch);
        }
        chars = "ASDFGHJKL".toCharArray();
        for (char ch : chars) {
            SECOND_ROW.add(ch);
        }
        chars = "ZXCVBNM".toCharArray();
        for (char ch : chars) {
            THIRD_ROW.add(ch);
        }

        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (allFirstRow(word, FIRST_ROW) || allFirstRow(word, SECOND_ROW) || allFirstRow(word, THIRD_ROW)) {
                list.add(word);
            }
        }

        String[] result = new String[list.size()];
        for (int i = 0; i <= list.size() - 1; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private boolean allFirstRow(String s, Set<Character> FIRST_ROW) {
        for (int i = 0; i <= s.length() - 1; i++) {
            if (!FIRST_ROW.contains(Character.toUpperCase(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
