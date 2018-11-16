package Z201_220;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/16 10:59
 **/
public class HappyNumber202 {

    public static void main(String[] args) {
        System.out.println(new HappyNumber202().isHappy(2));
    }

    /**
     * 求一个数的各位的平方和，重复做，能够得到1的数字是happy的
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while(true) {
            n = getSquareSum(n);
            if (n == 1) {
                return true;
            } else if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
    }

    private int getSquareSum(int n) {
        int result = 0;
        while (n != 0) {
            int a = n % 10;
            result += a * a;
            n = n / 10;
        }

        return result;
    }
}
