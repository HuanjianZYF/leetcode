package Z541_560;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/10 18:46
 **/
public class ReverseStringII541 {

    public String reverseStr(String s, int k) {
        boolean reverse = true;
        StringBuilder result = new StringBuilder();
        while (s.length() != 0) {
            int len = k >= s.length() ? s.length() : k;

            String subStr = s.substring(0, len);
            if (reverse) {
                subStr = reverse(subStr);
            }
            result.append(subStr);

            reverse = !reverse;
            s = s.substring(len);
        }


        return result.toString();
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
