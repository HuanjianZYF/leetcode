package Z441_460;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/30 14:49
 **/
public class ArrangingCoins441 {

    public int arrangeCoins(int n) {
        long sum = 0;
        int i = 1;
        while (sum <= n) {
            sum += i++;
        }
        return i - 2;
    }
}
