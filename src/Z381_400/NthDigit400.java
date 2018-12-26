package Z381_400;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/26 15:41
 **/
public class NthDigit400 {

    public static void main(String[] args) throws Exception {
        System.out.println(new NthDigit400().findNthDigit(10000000));
    }

    public int findNthDigit(int n) {
        long pos = 0;
        int start = 1;
        while (true) {
            int num = decimalBitNum(start);
            pos += num;
            if (pos >= n) {
                pos -= num;
                int wei = (int)(n - pos);
                return getNumWei(start, wei, num);
            }
            start++;
        }
    }

    private int getNumWei(int start, int wei, int num) {
        start /= Math.pow(10, num - wei);
        return start % 10;
    }

    /**
     * 倒着排性能更好
     * @param n
     * @return
     */
    private int decimalBitNum(int n)  {
        if (n >= 10000000 && n < 100000000) {
            return 8;
        } else if (n >= 100000000 && n < 1000000000) {
            return 9;
        } else if (n >= 1000000000 && n <= Integer.MAX_VALUE) {
            return 10;
        } else if (n >= 1000000 && n < 10000000) {
            return 7;
        } else if (n < 10) {
            return 1;
        } else if (n >= 10 && n < 100) {
            return 2;
        } else if (n >= 100 && n < 1000) {
            return 3;
        } else if (n >= 1000 && n < 10000) {
            return 4;
        } else if (n >= 10000 && n < 100000) {
            return 5;
        } else if (n >= 100000 && n < 1000000) {
            return 6;
        }
        return 0;
    }
}
