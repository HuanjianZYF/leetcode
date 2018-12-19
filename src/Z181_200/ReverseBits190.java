package Z181_200;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/19 20:00
 **/
public class ReverseBits190 {

    public static void main(String[] args) {
        System.out.println(new ReverseBits190().reverseBits(0b10010110111001001101001111110101));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long result = 0;

        String s = Integer.toBinaryString(n);
        s = fillZero(s);
        s = reverse(s);

        for (int i = 0; i <= s.length() - 1; i++) {
            result += Math.pow(2, i) * (s.charAt(s.length() - 1 - i) - '0');
        }

        if (result > Integer.MAX_VALUE) {
            return -(int) (2 * Integer.MAX_VALUE + 2 - result);
        }
        return (int) result;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    private String fillZero(String s) {
        StringBuilder result = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < 32 - len; i++) {
            result.append('0');
        }
        return result.append(s).toString();
    }

}
