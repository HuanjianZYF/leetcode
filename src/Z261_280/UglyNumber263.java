package Z261_280;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/20 15:03
 **/
public class UglyNumber263 {

    /**
     * 因子只有 2,3,5
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (true) {
            boolean flag = false;
            if (num % 2 == 0) {
                num /= 2;
                flag = true;
            }
            if (num % 3 == 0) {
                num /= 3;
                flag = true;
            }
            if (num % 5 == 0) {
                num /= 5;
                flag = true;
            }
            if (!flag) {
                break;
            }
        }

        return num == 1;
    }
}
