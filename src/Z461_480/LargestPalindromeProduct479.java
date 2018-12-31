package Z461_480;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/31 19:56
 **/
public class LargestPalindromeProduct479 {

    public static void main(String[] args) {
        System.out.println(new LargestPalindromeProduct479().largestPalindrome(7));
    }

    /**
     * 求n位数乘积的最大回文数 模 1337
     * 咋优化啊
     *
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        long max = 0L;

        long maxNum = (long) (Math.pow(10, n) - 1);
        long minNum = (long) (Math.pow(10, n - 1));
        for (long i = maxNum; i >= minNum; i--) {
            if (i * i < max) {
                break;
            }

            for (long j = i; j >= minNum; j--) {
                long product = i * j;
                if (product <= max) {
                    break;
                }
                if (isPalindrome(product)) {
                    max = product;
                }
            }
        }

        return (int) (max % 1337);
    }

    private boolean isPalindrome(long n) {
        String s = String.valueOf(n);
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
