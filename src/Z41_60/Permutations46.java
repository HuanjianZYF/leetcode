package Z41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 15:13
 **/
public class Permutations46 {

    public static void main(String[] args) {
        System.out.println(new Permutations46().permute(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length == 0) {
            return resultList;
        }
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
            List<List<Integer>> subResult = permute(newNum);
            for (List<Integer> each : subResult) {
                each.add(nums[i]);
                resultList.add(each);
            }
        }

        return resultList;
    }
}
