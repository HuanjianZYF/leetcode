package Z341_360;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/23 13:41
 **/
public class PowerOfFour342 {

    public boolean isPowerOfFour(int num) {
        long haha = 1;
        while (true) {
            if (haha == num) {
                return true;
            }
            if (num < haha) {
                return false;
            }
            haha *= 4;
        }
    }
}
