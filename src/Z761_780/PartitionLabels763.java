package Z761_780;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/21 16:54
 **/
public class PartitionLabels763 {

    public static void main(String[] args) {
        System.out.println(new PartitionLabels763().partitionLabels("ababcbacadefegdehijhklij"));
    }

    /**
     * 将一个字符串分割成很多个字符串，使得一个字符只能出现在其中的一个字符串中，分割出来的块数应当尽可能多
     * 找出第一个字母的所有位置，然后找出从第一个字母到最后一个字母之间的所有字母的位置，继续下去.....
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 1) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        doPatition(S, result);
        return result;
    }

    private void doPatition(String s, List<Integer> list) {
        if (s == null || s.length() == 0) {
            return;
        }

        int nowIndex = 0;

        Character ch = s.charAt(0);
        Set<Character> set = new HashSet<>();
        set.add(ch);
        while (true) {
            int farIndex = findFarIndex(s, set);
            if (farIndex == nowIndex) {
                break;
            }

            set = getCharsFromStr(s.substring(0, farIndex));
            nowIndex = farIndex;
        }

        list.add(nowIndex + 1);
        doPatition(s.substring(nowIndex + 1, s.length()), list);
    }

    /**
     * 从一个字符串中拿到所有的字符
     * @return
     */
    private Set<Character> getCharsFromStr(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            set.add(s.charAt(i));
        }

        return set;
    }

    /**
     * 找到一个字符集合在字符串的最远的位置
     * @param s
     * @param set
     * @return
     */
    private int findFarIndex(String s, Set<Character> set) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (set.contains(s.charAt(i))) {
                return i;
            }
        }
        return 0;
    }
}
