package Z361_380;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/23 14:31
 **/
public class GuessNumberHigherOrLower374 {

    public int guessNumber(int n) {
        long value = n;
        if (n <= 0) {
            value = Integer.MAX_VALUE * 2 + 2 + n;
        }
        return guess(1, value);
    }

    private int guess(long start, long end) {
        long mid = (start + end) / 2;
        int result = guess((int) mid);
        if (result == 0) {
            return (int) mid;
        } else if (result < 0) {
            return guess(start, mid - 1);
        } else {
            return guess(mid + 1, end);
        }
    }

    private int guess(int n) {
        return 0;
    }
}
