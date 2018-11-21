package Z221_240;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/20 14:39
 **/
public class PowerOfTwo231 {

    public boolean isPowerOfTwo(int n) {
        for (int i = 0; true; i++) {
            long v = (long) Math.pow(2, i);
            if (v == n) {
                return true;
            } else if (v > (long) n) {
                return false;
            }
        }
    }
}
