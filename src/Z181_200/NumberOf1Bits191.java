package Z181_200;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/22 14:16
 **/
public class NumberOf1Bits191 {

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits191().hammingWeight(2147483647));
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
