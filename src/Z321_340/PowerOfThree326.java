package Z321_340;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/23 13:38
 **/
public class PowerOfThree326 {

    public boolean isPowerOfThree(int n) {

        long num = 1;
        while (true) {
            if (n == num) {
                return true;
            }
            if (n < num) {
                return false;
            }
            num *= 3;
        }
    }
}
