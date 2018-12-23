package Z341_360;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/23 13:50
 **/
public class ReverseVowelsOfAString345 {

    /**
     * reverse字符串里的元音字母
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        StringBuilder vowelStr = new StringBuilder();
        for (int i = 0; i <= s.length() - 1; i++) {
            if (isVowel(s.charAt(i))) {
                vowelStr.append(s.charAt(i));
            }
        }
        String haha = vowelStr.reverse().toString();

        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (isVowel(s.charAt(i))) {
                result.append(haha.charAt(index));
                index++;
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i'
            || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U';
    }
}
