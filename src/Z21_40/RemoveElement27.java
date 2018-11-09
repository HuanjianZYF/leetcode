package Z21_40;

/**
 * @author zyf
 * @date 2018/9/15 上午8:16
 */
public class RemoveElement27 {

	public int removeElement(int[] nums, int val) {
		int ptr = 0;
		for (int value : nums) {
			if (value != val) {
				nums[ptr] = value;
				ptr++;
			}
		}
		
		return ptr;
	}
}
