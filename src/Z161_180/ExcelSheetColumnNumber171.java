package Z161_180;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/19 17:07
 **/
public class ExcelSheetColumnNumber171 {

    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            sum += Math.pow(26, s.length() - i - 1) * (ch - 'A' + 1);
        }

        return sum;
    }
}
