package Z1_20;

/**
 * @Author wb-zyf471922
 * @Date 2019/4/28 16:22
 **/
public class String2Integer8 {

    public int myAtoi(String str) {
        str = str.trim();
        if ("".equals(str)) {
            return 0;
        }

        char first = str.charAt(0);
        if (first != '-' && first != '+' && !Character.isDigit(first)) {
            return 0;
        }

        if (!Character.isDigit(first)) {
            if (str.length() == 1 || !Character.isDigit(str.charAt(1))) {
                return 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(first);

        for (int i = 1; i <= str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                break;
            }
        }
        String numberStr = sb.toString();

        boolean negative = str.charAt(0) == '-';
        int n;
        try {
            n = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            if (negative) {
                n = Integer.MIN_VALUE;
            } else {
                n = Integer.MAX_VALUE;
            }
        }

        return n;
    }
}
