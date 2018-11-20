package Z701_720;

import java.util.Arrays;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/20 10:54
 **/
public class BinarySearch704 {

    public static void main(String[] args) {
        System.out.println(new BinarySearch704().search(new int[]{5}, 5));
    }

    public int search(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        return result >= 0 ? result : -1;
    }
}
