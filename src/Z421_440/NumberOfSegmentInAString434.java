package Z421_440;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/27 19:53
 **/
public class NumberOfSegmentInAString434 {

    public int countSegments(String s) {
        int result = 0;
        boolean blank = true;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) != ' ') {
                if (blank) {
                    result++;
                    blank = false;
                }
            } else {
                blank = true;
            }
        }

        return result;
    }
}
