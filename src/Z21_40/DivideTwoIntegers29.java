package Z21_40;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/2 21:15
 **/
public class DivideTwoIntegers29 {

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers29().divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        long result = (long) dividend / (long) divisor;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
