package Z21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 14:43
 **/
public class CombinationSumII40 {

    public static void main(String[] args) {
        System.out.println(new CombinationSumII40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        for (int i = 0; i <= candidates.length - 1; i++) {
            int each = candidates[i];
            if (each < target) {
                if (i == candidates.length - 1) {
                    break;
                }
                int[] subArray = new int[candidates.length - i - 1];
                for (int j = i + 1; j <= candidates.length - 1; j++) {
                    subArray[j - i - 1] = candidates[j];
                }
                List<List<Integer>> subResult = combinationSum2(subArray, target - each);
                for (List<Integer> subList : subResult) {
                    subList.add(each);
                    result.add(subList);
                }
                //递归出口
            } else if (each == target) {
                List<Integer> list = new ArrayList<>();
                list.add(each);
                result.add(list);
                break;
            }
        }

        result = result.stream()
            .distinct()
            .collect(Collectors.toList());

        return result;
    }
}
