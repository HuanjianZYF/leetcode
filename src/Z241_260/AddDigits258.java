package Z241_260;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/16 18:38
 **/
public class AddDigits258 {

    public static void main(String[] args) {
        System.out.println(new AddDigits258().addDigits(55));
    }

    public int addDigits(int num) {
        while (num >= 10) {
            num = addAllDigits(num);
        }

        return num;
    }

    private int addAllDigits(int num) {
        int result = 0;
        while (num != 0) {
            int a = num % 10;
            result += a;
            num /= 10;
        }

        return result;
    }
}
