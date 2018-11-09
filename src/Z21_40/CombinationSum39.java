package Z21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyf
 * @date 2018/9/18 下午2:22
 */
public class CombinationSum39 {
	
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		
		for (int i = 0; i <= candidates.length - 1; i++) {
			int each = candidates[i];
			if (each < target) {
				int[] subArray = new int[candidates.length - i];
				for (int j = i; j <= candidates.length - 1; j++) {
					subArray[j - i] = candidates[j];
				}
				List<List<Integer>> subResult = combinationSum(subArray, target - each);
				for (List<Integer> subList : subResult) {
					subList.add(each);
					result.add(subList);
				}
			} else if (each == target) { //递归出口
				List<Integer> list = new ArrayList<>();
				list.add(each);
				result.add(list);
				break;
			}
		}

		return result;
	}
	
}
