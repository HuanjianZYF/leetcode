package Z361_380;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/23 14:22
 **/
public class ValidPerfectSquare367 {

    public boolean isPerfectSquare(int num) {
        int a = 1;
        while (true) {
            long square = (long) a * a;
            if (square == num) {
                return true;
            }
            if (num < square) {
                return false;
            }
            a++;
        }
    }
}
