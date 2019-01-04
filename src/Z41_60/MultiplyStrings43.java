package Z41_60;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 16:09
 **/
public class MultiplyStrings43 {

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings43().multiply("0", "52"));
    }

    /**
     * 大数乘，只能写一次了
     */
    public String multiply(String num1, String num2) {
        String result = "0";
        for (int i = 0; i <= num2.length() - 1; i++) {
            result = bigAdd(result, multi2SingleMult(num1, num2.charAt(num2.length() - i - 1) - '0', i));
        }

        return result;
    }

    private String bigAdd(String s1, String s2) {
        if ("0".equals(s1)) {
            return s2;
        }
        if ("0".equals(s2)) {
            return s1;
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int up = 0;
        while (index <= s1.length() - 1 || index <= s2.length() - 1) {
            int ch1 = index > s1.length() - 1 ? 0 : s1.charAt(s1.length() - 1 - index) - '0';
            int ch2 = index > s2.length() - 1 ? 0 : s2.charAt(s2.length() - 1 - index) - '0';
            int[] bitAddResult = getBitAdd(ch1, ch2, up);
            up = bitAddResult[1];
            sb.append(bitAddResult[0]);
            index++;
        }

        if (up > 0) {
            sb.append(up);
        }
        return sb.reverse().toString();
    }

    private int[] getBitAdd(int ch1, int ch2, int up) {
        int[] result = new int[2];
        result[0] = (ch1 + ch2 + up) % 10;
        result[1] = (ch1 + ch2 + up) / 10;
        return result;
    }

    private String multi2SingleMult(String s, int ch, int shift) {
        if (ch == 0) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();
            int up = 0;
            for (int i = 0; i <= s.length() - 1; i++) {
                int[] multRes = single2SingleMult(s.charAt(s.length() - 1 - i) - '0', ch, up);
                up = multRes[1];
                sb.append(multRes[0]);
            }
            if (up > 0) {
                sb.append(up);
            }
            sb.reverse();

            if (!"0".equals(sb.toString())) {
                for (int i = 0; i <= shift - 1; i++) {
                    sb.append('0');
                }
            }
            return sb.toString();
        }
    }

    private int[] single2SingleMult(int a, int b, int up) {
        int[] result = new int[2];
        int value = a * b + up;
        result[0] = value % 10;
        result[1] = value / 10;
        return result;
    }

}
