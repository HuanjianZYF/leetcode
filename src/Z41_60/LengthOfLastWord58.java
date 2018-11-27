package Z41_60;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/27 20:14
 **/
public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }

        return strings[strings.length - 1].length();
    }
}
