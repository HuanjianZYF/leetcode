package Z461_480;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/31 17:34
 **/
public class HammingDistance461 {

    public static void main(String[] args) {
        System.out.println(new HammingDistance461().hammingDistance(3, 1));
    }

    public int hammingDistance(int x, int y) {
        int result = 0;
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);

        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;

            int tmp2 = len1;
            len1 = len2;
            len2 = tmp2;
        }

        for (int i = 0; i <= len2 - len1 - 1; i++) {
            s1 = "0" + s1;
        }

        for (int i = 0; i <= len2 - 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result++;
            }
        }

        return result;
    }
}
