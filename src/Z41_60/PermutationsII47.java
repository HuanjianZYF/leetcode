package Z41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 15:30
 **/
public class PermutationsII47 {

    public static void main(String[] args) {
        System.out.println(new PermutationsII47().permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length == 0) {
            return resultList;
        }

        Arrays.sort(nums);
        return permuteUniqueSub(nums);
    }

    private List<List<Integer>> permuteUniqueSub(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            resultList.add(list);
            return resultList;
        }

        for (int i = 0; i <= nums.length - 1; i++) {
            int[] newNum = new int[nums.length - 1];
            System.arraycopy(nums, 0, newNum, 0, i);
            System.arraycopy(nums, i + 1, newNum, i, nums.length - 1 - i);
            List<List<Integer>> subResult = permuteUnique(newNum);
            for (List<Integer> each : subResult) {
                each.add(nums[i]);
                resultList.add(each);
            }
        }

        resultList = resultList.stream().distinct().collect(Collectors.toList());
        return resultList;
    }
}
