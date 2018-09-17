package one_twenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyf
 * @date 2018/9/15 上午8:52
 */
public class LetterCombinationsOfPhoneNumber17 {

	public List<String> letterCombinations(String digits) {
		//先初始化每个数字可以代表的字母
		Map<Integer, String> digitLetterMap = new HashMap<>();
		initDigitLetterMap(digitLetterMap);
		
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		for (int i = 0; i < digits.length(); i++) {
			
		}
		return result;
	}
	
	private void initDigitLetterMap(Map<Integer, String> map) {
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}
	
}
