package Z461_480;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/31 19:30
 **/
public class NumberComplement475 {

    public static void main(String[] args) {
        System.out.println(new NumberComplement475().findComplement(2));
    }

    public int findComplement(int num) {
        String binaryStr = Integer.toBinaryString(num);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= binaryStr.length() - 1; i++) {
            sb.append(binaryStr.charAt(i) == '0' ? '1' : '0');
        }
        String newBinaryStr = sb.toString();

        int result = 0;
        for (int i = newBinaryStr.length() - 1; i >= 0; i--) {
            result += Math.pow(2, newBinaryStr.length() - 1 - i) * (newBinaryStr.charAt(i) - '0');
        }

        return result;
    }
}
