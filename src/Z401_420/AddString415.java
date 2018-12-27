package Z401_420;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/27 17:26
 **/
public class AddString415 {

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int len1 = num1.length();
        int len2 = num2.length();
        int index1 = len1 - 1;
        int index2 = len2 - 1;
        char up = '0';
        while (index1 >= 0 || index2 >= 0) {
            char a = index1 >= 0 ? num1.charAt(index1) : '0';
            char b = index2 >= 0 ? num2.charAt(index2) : '0';
            char[] haha = doAdd(a, b, up);
            result.append(haha[0]);
            up = haha[1];
            index1--;
            index2--;
        }
        if (up == '1') {
            result.append("1");
        }

        return result.reverse().toString();
    }

    private char[] doAdd(char a, char b, char up) {
        char[] result = new char[2];

        int haha = a - '0' + b - '0';
        if (up == '1') {
            haha++;
        }
        result[0] = (char) (haha % 10 + '0');
        result[1] = (char) (haha / 10 + '0');

        return result;
    }
}
