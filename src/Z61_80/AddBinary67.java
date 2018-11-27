package Z61_80;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/27 20:17
 **/
public class AddBinary67 {

    public static void main(String[] args) {
        System.out.println(new AddBinary67().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        int i = 0;
        boolean up = false;
        while (i < len2 || i < len1) {
            char ch1 = i < len1 ? a.charAt(len1 - 1 - i) : '0';
            char ch2 = i < len2 ? b.charAt(len2 - 1 - i) : '0';
            sb.append(addOneBit(ch1, ch2, up));
            up = isUpgrade(ch1, ch2, up);
            i++;
        }
        if (up) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    private char addOneBit(char a, char b, boolean up) {
        if (!up) {
            return a == b ? '0' : '1';
        } else {
            return a == b ? '1' : '0';
        }
    }

    private boolean isUpgrade(char a, char b, boolean up) {
        if (up) {
            return !(a == '0' && b == '0');
        } else {
            return a == '1' && b == '1';
        }
    }
}
