package Z161_180;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/18 17:16
 **/
public class CompareVersionNumbers165 {

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers165().compareVersion("1.0", "1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        int minLen = array1.length < array2.length ? array1.length : array2.length;

        for (int i = 0; i <= minLen - 1; i++) {
            int subRes = compareSingle(array1[i], array2[i]);
            if (subRes > 0) {
                return 1;
            } else if (subRes < 0) {
                return -1;
            }
        }

        List<String> rest = new ArrayList<>();
        if (array1.length != minLen) {
            for (int i = minLen; i <= array1.length - 1; i++) {
                rest.add(array1[i]);
            }
            return checkRest(rest);
        }

        if (array2.length != minLen) {
            for (int i = minLen; i <= array2.length - 1; i++) {
                rest.add(array2[i]);
            }
            return -checkRest(rest);
        }
        return 0;
    }

    private int checkRest(List<String> list) {
        for (int i = 0; i <= list.size() - 1; i++) {
            if (!allZero(list.get(i))) {
                return 1;
            }
        }
        return 0;
    }

    private boolean allZero(String s) {
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private int compareSingle(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        String prefix = "";
        for (int i = 0; i <= Math.abs(len1 - len2) - 1; i++) {
            prefix += "0";
        }

        if (len1 < len2) {
            s1 = prefix + s1;
        } else {
            s2 = prefix + s2;
        }
        for (int i = 0; i <= s1.length() - 1; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }
}
