package Z61_80;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/28 19:07
 **/
public class SqrtX69 {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long result = 0;

        while (result * result <= x) {
            result++;
        }
        return (int) result - 1;
    }
}
