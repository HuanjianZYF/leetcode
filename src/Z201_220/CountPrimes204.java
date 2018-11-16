package Z201_220;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/16 13:29
 **/
public class CountPrimes204 {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int result = 1;
        for (int i = 3; i < n; i += 2) {
            if (isPrime(i)) {
                result++;
            }
        }

        return result;
    }

    boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        if (x == 2) {
            return true;
        }
        if (x % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(x); i += 2) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
