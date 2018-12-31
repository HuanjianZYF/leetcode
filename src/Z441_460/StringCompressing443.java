package Z441_460;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/30 14:56
 **/
public class StringCompressing443 {

    public static void main(String[] args) {
        System.out.println(new StringCompressing443().compress("aabbccc".toCharArray()));
    }

    public int compress(char[] chars) {
        int targetIndex = 0;

        int lastNum = 0;
        char lastChar = ' ';
        for (int i = 0; i <= chars.length - 1; i++) {
            if (chars[i] == lastChar) {
                lastNum++;
            } else {
                targetIndex = dealRest(chars, targetIndex, lastChar, lastNum);
                lastChar = chars[i];
                lastNum = 1;
            }
        }

        return dealRest(chars, targetIndex, lastChar, lastNum);
    }

    private int dealRest(char[] chars, int targetIndex, char lastChar, int lastNum) {
        if (lastNum <= 0) {
            return targetIndex;
        }
        chars[targetIndex++] = lastChar;
        if (lastNum >= 2) {
            String s = Integer.toString(lastNum);
            for (int j = 0; j <= s.length() - 1; j++) {
                chars[targetIndex++] = s.charAt(j);
            }
        }
        return targetIndex;
    }

}
