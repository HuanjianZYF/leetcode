package Z441_460;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/20 10:33
 **/
public class RepeatStringPattern459 {

    public static void main(String[] args) {
        System.out.println(new RepeatStringPattern459().repeatedSubstringPattern("ababc"));
    }

    /**
     * 看一个字符串是不是某一个子串重复了很多次
     * 就看第一个字符的位置都出现在哪里，然后看看次数的约数为界的长度的字符串是不是那个重复的子串
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        char ch = s.charAt(0);
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) == ch) {
                indexList.add(i);
            }
        }

        int size = indexList.size();
        for (int i = size / 2; i >= 1; i--) {
            if (checkSubStr(s, indexList.get(i))) {
                return true;
            }
        }

        return false;
    }

    private boolean checkSubStr(String s, int index) {
        String subStr = s.substring(0, index);
        int len = s.length();
        if (len % subStr.length() != 0) {
            return false;
        }

        int times = len / subStr.length();
        String haha = "";
        for (int i = 0; i < times; i++) {
            haha += subStr;
        }

        return haha.equalsIgnoreCase(s);
    }
}
