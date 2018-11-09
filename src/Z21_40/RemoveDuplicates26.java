package Z21_40;

/**
 * @author zyf
 * @date 2018/9/15 上午8:26
 */
public class RemoveDuplicates26 {

	public int removeDuplicates(int[] nums) {
		int ptr = 0;
		for (int value : nums) {
			boolean join = true;

			for (int i = 0; i < ptr; i++) {
				if (value == nums[i]) {
					join = false;
				}
			}
			
			if (join) {
				nums[ptr] = value;
				ptr++;
			}
		}
		
		return ptr;
	}
}
