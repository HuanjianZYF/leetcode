package Z501_520;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/7 13:59
 **/
public class PerfectNumber507 {

    public static void main(String[] args) {
        System.out.println(new PerfectNumber507().checkPerfectNumber(28));
    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 2) {
            return false;
        }

        int target = 1;

        int small = 2;
        int big = num / 2;

        while (small < big) {
            if (num % small == 0) {
                target += small;
                big = num / small;
                if (big != small) {
                    target += big;
                }
            }
            small++;
        }

        return num == target;
    }
}
