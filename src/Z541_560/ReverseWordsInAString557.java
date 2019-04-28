package Z541_560;

/**
 * @Author wb-zyf471922
 * @Date 2019/4/28 15:44
 **/
public class ReverseWordsInAString557 {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String each : strs) {
            result.append(reverse(each));
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
