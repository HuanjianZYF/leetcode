package Z1_20;

/**
 * @Author wb-zyf471922
 * @Date 2019/4/28 16:50
 **/
public class RegularExpressionMatching10 {

    public boolean isMatch(String s, String p) {
        int index = p.indexOf("*");

        // 没有*
        if (index < 0) {
            return isMatchWithoutXingxing(s, p);
        }

        // *在第一位
        if (index == 0) {
            return false;
        }

        // 匹配*之前的前半段
        if (s.length() < index - 1 || !isMatchWithoutXingxing(s.substring(0, index - 1), p.substring(0, index - 1))) {
            return false;
        }

        s = s.substring(index - 1);
        p = p.substring(index - 1);

        // 如果表达式只有两个字母了, 而且【如果表达式在*之后还有这个字母，需要合并到前面去】
        char repeat = p.charAt(0);
        if (p.length() == 2) {
            return allChar(s, repeat);
        }
        char first = p.charAt(2);



        return true;
    }

    private boolean allChar(String s, char ch) {
        if (ch == '.') {
            return true;
        }

        for (int i = 0; i <= s.length() - 1; i++) {
            if (ch != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isMatchWithoutXingxing(String s, String p) {
        if ("".equals(p)) {
            return "".equals(s);
        }
        char ch = p.charAt(0);

        switch (ch) {
            case '.':{
                if ("".equals(s)) {
                    return false;
                }
                return isMatchWithoutXingxing(s.substring(1), p.substring(1));
            }
            default:{
                if ("".equals(s) || ch != s.charAt(0)) {
                    return false;
                }
                return isMatchWithoutXingxing(s.substring(1), p.substring(1));
            }
        }
    }

}
