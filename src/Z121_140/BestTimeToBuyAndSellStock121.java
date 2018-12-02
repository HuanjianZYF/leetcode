package Z121_140;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/2 17:32
 **/
public class BestTimeToBuyAndSellStock121 {

    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int size = prices.length;
        for (int i = 0; i <= size - 2; i++) {
            for (int j = i + 1; j <= size - 1; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }

        return max > 0 ? max : 0;
    }
}
