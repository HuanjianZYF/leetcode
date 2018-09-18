package twenty_forty;

/**
 * @author zyf
 * @date 2018/9/18 上午11:44
 */
public class SearchInsertPosition35 {

	public int searchInsert(int[] nums, int target) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		
		int start = 0;
		int end = length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		if (nums[start] == target) {
			return start;
		} else if (nums[start] > target){
			return start;
		} else {
			return start + 1;
		}
	}
}
