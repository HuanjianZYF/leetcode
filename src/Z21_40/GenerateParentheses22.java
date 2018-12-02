package Z21_40;

import java.util.*;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/2 13:30
 **/
public class GenerateParentheses22 {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses22().generateParenthesis(4));
    }

    /**
     * 输入括号的对数，输出合理括号的组合
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        Set<String> resultList = new HashSet<>();
        for (int i = 1; i <= n ; i++) {
            resultList = getNext(resultList);
        }

        return new ArrayList<>(resultList);
    }

    private Set<String> getNext(Set<String> list) {
        Set<String> resultSet = new HashSet<>();
        if (list.size() == 0) {
            resultSet.add("()");
            return resultSet;
        }

        for (String each : list) {
            resultSet.add("()" + each);
            int start = 0;
            while (true) {
                int index = each.indexOf(")", start);
                if (index < 0) {
                    break;
                }

                resultSet.add(each.substring(0, index) + "()" + each.substring(index, each.length()));
                start = index + 1;
            }
        }

        return resultSet;
    }

}
