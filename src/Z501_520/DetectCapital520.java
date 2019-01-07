package Z501_520;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/7 14:17
 **/
public class DetectCapital520 {

    public boolean detectCapitalUse(String word) {
        int allLen = word.length();
        int upcaseLen = 0;
        for (int i = 0; i <= word.length() - 1; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upcaseLen++;
            }
        }
        if (upcaseLen == allLen || upcaseLen == 0) {
            return true;
        }
        if (upcaseLen == 1) {
            return Character.isUpperCase(word.charAt(0));
        }
        return false;
    }
}
