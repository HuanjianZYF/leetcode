package Z1_20;

import java.util.Arrays;

/**
 * @author zyf
 * @date 2018/9/20 上午10:12
 */
public class ThreeSumClosest16 {
	
	public static void main(String[] args) {
		System.out.println(new ThreeSumClosest16().threeSumClosest(new int[]{1,-3,3,5,4,1},1));
	}
	
	public int threeSumClosest(int[] nums, int target) {
		int result = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		
		if (nums == null || nums.length < 3) {
			return result;
		}

		//将问题归约至求两数和最小的那个
		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 3; i ++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int subResult = findTwoSumClosest(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
				int nowDiff = Math.abs(target - subResult - nums[i]);
				if (nowDiff < diff) {
					diff = nowDiff;
					result  = subResult + nums[i];
				}
			}
		}
		
		return result;
	}
	
	private int findTwoSumClosest(int[] nums, int sum) {
		int result = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		
		for (int i = 0; i <= nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int subResult = findOneClosest(nums, i + 1, sum - nums[i]);
				int nowDiff = Math.abs(sum - subResult - nums[i]);
				if (nowDiff < diff) {
					diff = nowDiff;
					result = subResult + nums[i];
				}
			}
		}
		
		return result;
	}
	
	private int findOneClosest(int[] nums, int start, int target) {
		int diff = Integer.MAX_VALUE;
		boolean flag = false; //表示比target大还是小 false表示小
		
		int end = nums.length;
		if (nums[start] >= target) {
			return nums[start];
		}
		if (nums[end - 1] <= target) {
			return nums[end - 1];
		}
		
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return target;
			} else if (nums[mid] < target) {
				int nowDiff = target - nums[mid];
				if (nowDiff < diff) {
					diff = nowDiff;
					flag = false;
				}
				start = mid + 1;
			} else {
				int nowDiff = nums[mid] - target;
				if (nowDiff < diff) {
					diff = nowDiff;
					flag = true;
				}
				end = mid;
			}
		}
		
		return flag ? target + diff : target - diff;
	}
	
}
