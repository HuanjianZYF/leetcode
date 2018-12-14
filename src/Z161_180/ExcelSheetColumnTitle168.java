package Z161_180;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/14 15:23
 **/
public class ExcelSheetColumnTitle168 {

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            n = n - 1;
            result.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return result.reverse().toString();
    }
}
