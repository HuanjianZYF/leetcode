package Z481_500;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/1 18:01
 **/
public class LicenseKeyFormatting482 {

    public String licenseKeyFormatting(String S, int K) {
        String fullStr = getFullStr(S);
        int firstLen = fullStr.length() % K;
        int num = fullStr.length() / K;

        StringBuilder result = new StringBuilder();
        int index = 0;
        if (firstLen > 0) {
            result.append(fullStr.substring(0, firstLen));
            result.append('-');
            index = firstLen;
        }
        for (int i = 0; i <= num - 1; i++) {
            result.append(fullStr.substring(index, index + K));
            result.append('-');
            index += K;
        }

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        StringBuilder hah = new StringBuilder();
        for (int i = 0; i <= result.length() - 1; i++) {
            hah.append(Character.toUpperCase(result.charAt(i)));
        }
        return hah.toString();
    }

    private String getFullStr(String S) {
        return S.replaceAll("-", "");
    }
}
