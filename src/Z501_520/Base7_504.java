package Z501_520;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/7 13:28
 **/
public class Base7_504 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean fu = false;
        if (num < 0) {
            fu = true;
            num = -num;
        }
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (fu) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
