package Z161_180;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/7 17:02
 **/
public class LargestestNumber179 {

    public static void main(String[] args) {
        System.out.println(new LargestestNumber179().largestNumber(new int[]{3,30,34,5,9}));
    }

    /**
     * 给一个数组，将数组里的数重排序连一起，返回最大的
     * 能找到一个头，就能得到所有
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0 || !hasNotZero(nums)) {
            return "0";
        }

        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        StringBuilder result = new StringBuilder();

        while (list.size() > 0) {
            int index = getHead(list);
            result.append(list.get(index));
            list.remove(index);
        }

        return result.toString();
    }

    private boolean hasNotZero(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return true;
            }
        }
        return false;
    }

    private int getHead(List<String> list) {
        String head = list.get(0);
        int index = 0;
        for (int i = 1; i <= list.size() - 1; i++) {
            if (frontThan(list.get(i), head, i, index, list)) {
                head = list.get(i);
                index = i;
            }
        }

        return index;
    }

    /**
     * 比较两个字符串谁在前面
     *
     * @param s1        字符串1
     * @param s2        字符串2
     * @param index1 字符串1的下标
     * @param index2 字符串2的下标
     * @param list      列表
     * @return
     */
    private boolean frontThan(String s1, String s2, int index1, int index2, List<String> list) {

        for (int i = 0; i <= s1.length() - 1 && i <= s2.length() - 1; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return false;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return true;
            }
        }

        // 其中一个是另一个的子串
        int len1 = s1.length();
        int len2 = s2. length();
        if (len1 == len2) {
            return false;
        }

        if (len1 > len2) {
            String newStr = s1.substring(s2.length(), s1.length());
            List<String> newList = new ArrayList<>();
            newList.addAll(list);
            newList.set(index1, newStr);
            return isSubstrFrontThanAll(newStr, index1, newList);
        } else {
            String newStr = s2.substring(s1.length(), s2.length());
            List<String> newList = new ArrayList<>();
            newList.addAll(list);
            newList.set(index2, newStr);
            return !isSubstrFrontThanAll(newStr, index2, newList);
        }

    }

    /**
     * 遇到有两个字符串 其中一个是另一个的子串时，谁在前面还由列表里的其他数字决定
     * s 更靠前时返回true
     *
     * @param s 母串超出的部分
     * @param index
     * @param list 列表
     * @return
     */
    private boolean isSubstrFrontThanAll(String s, int index, List<String> list) {
        for (int i = 0; i <= list.size() - 1; i++) {
            if (frontThan(list.get(i), s, i, index, list)) {
                return false;
            }
        }

        return true;
    }

}
