package one_twenty;

/**
 * problem1
 * @author zyf
 * @date 2018/9/5 下午5:47
 */
public class TwoSum1 {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) { //没有nums或者只有一个肯定没有结果
			return null;
		}
		
		//遍历二维点
		int length = nums.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j ++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			} 
		}
		
		return null;
	}
}
