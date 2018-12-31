package Z441_460;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/31 17:20
 **/
public class FindAllDisappearedInArray448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            if (Arrays.binarySearch(nums, i) < 0) {
                resultList.add(i);
            }
        }

        return resultList;
    }
}
