package Z1_20;

import java.util.*;

/**
 * @author zyf
 * @date 2018/9/15 上午8:52
 */
public class LetterCombinationsOfPhoneNumber17 {

	public List<String> letterCombinations(String digits) {
		//先初始化每个数字可以代表的字母
		Map<Character, String> digitLetterMap = new HashMap<>();
		initDigitLetterMap(digitLetterMap);
		
		Set<String> result = new HashSet<>();
		if (digits == null || digits.length() == 0) {
			return new ArrayList<>(result);
		}
		
		for (int i = digits.length() - 1; i >= 0; i--) {
			result = getResultSet(digits.charAt(i), result, digitLetterMap);
		}
		return new ArrayList<>(result);
	}
	
	private Set<String> getResultSet(char c, Set<String> set, Map<Character, String> map) {
		char[] chs = map.get(c).toCharArray();
		if (set.size() == 0) {
			for (char each : chs) {
				set.add("" + each);
			}
			return set;
		}
		
		Set<String> result = new HashSet<>();
		for (String each : set) {
			for (char character : chs) {
				result.add(character + each);
			}
		}
		return result;
	}
	
	private void initDigitLetterMap(Map<Character, String> map) {
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}
	
}
