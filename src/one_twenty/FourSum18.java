package one_twenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyf
 * @date 2018/9/19 下午12:58
 */
public class FourSum18 {
	public static void main(String[] args) {
		System.out.println(new FourSum18().fourSum(new int[]{1,0,-1,0,-2,2}, 0));
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();

		if (nums == null || nums.length < 4) {
			return result;
		}

		//先排序
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 4; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int value = nums[i];
				
				List<List<Integer>> subList = findThreeSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - value);
				for (List<Integer> each : subList) {
					each.add(value);
					result.add(each);
				}
			}
		}
		
		return result;
	}


	/**
	 * 寻找数组中，三个数和为sum的组合
	 * @param nums 待搜索的数组，需要从小到大排列，且数量是大于3的
	 * @param sum 和
	 * @return 返回的是list的list，里面的list是和为sum的加数
	 */
	private List<List<Integer>> findThreeSum(int[] nums, int sum) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i <= nums.length - 3; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int value = nums[i];

				List<List<Integer>> subList = findTwoSum(Arrays.copyOfRange(nums, i + 1, nums.length), sum - value);
				for (List<Integer> each : subList) {
					each.add(value);
					result.add(each);
				}
			}
		}

		return result;
	}

	/**
	 * 寻找数组中有没有两个数的和为sum
	 * @param nums 待搜索的数组，需要是从小到大排列的
	 * @param sum 和
	 * @return 返回的是list的list，里面的list是和为sum的加数
	 */
	private List<List<Integer>> findTwoSum(int[] nums, int sum) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i <= nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int value = nums[i];
				Integer a = searchOne(nums, i, sum - value);
				if (a != null) {
					List<Integer> list = new ArrayList<>();
					list.add(value);
					list.add(a);
					result.add(list);
				}
			}
		}

		return result;
	}

	/**
	 * 寻找数组中有没有一个数等于target，从i开始寻找
	 * @param nums 搜索的数组
	 * @param i 起始下标
	 * @param target 目标值
	 * @return 如果找到了，返回target，找不到则返回null
	 */ 
	private Integer searchOne(int[] nums, int i, int target) {
		int index = Arrays.binarySearch(nums, i + 1, nums.length, target);

		return index >= 0 ? target : null;
	}
}
