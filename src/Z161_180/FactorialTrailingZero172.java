package Z161_180;

import java.math.BigDecimal;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/19 17:15
 **/
public class FactorialTrailingZero172 {

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZero172().trailingZeroes(800));
    }

    /**
     * 求出阶乘的最后带的0的个数
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal accumulate = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            BigDecimal subAccu = accumulate.multiply(new BigDecimal(i));
            BigDecimal[] divide = divideZero(subAccu);
            result = result.add(divide[0]);
            accumulate = divide[1];
        }

        return result.intValue();
    }

    private BigDecimal[] divideZero(BigDecimal x) {
        BigDecimal[] result = new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO};
        while (true) {
            BigDecimal[] divideRes = x.divideAndRemainder(new BigDecimal(10));
            if (divideRes[1].intValue() == 0) {
                result[0] = result[0].add(BigDecimal.ONE);
                x = divideRes[0];
            } else {
                break;
            }
        }
        result[1] = x;

        return result;
    }
}
