package Z121_140;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/19 21:58
 **/
public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length() - 1; i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }
        s = sb.toString();

        s = s.toUpperCase();

        return ZisPalindrome(s);
    }

    private boolean ZisPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return true;
        }
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
