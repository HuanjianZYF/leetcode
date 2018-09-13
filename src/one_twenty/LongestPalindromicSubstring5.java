package one_twenty;

import java.util.*;

/**
 * @author zyf
 * @date 2018/9/6 下午5:06
 */
public class LongestPalindromicSubstring5 {
	
	public static void main(String[] args) {
		long t1 = System.nanoTime();
		System.out.println(new LongestPalindromicSubstring5().longestPalindrome("ccc"));
		long t2 = System.nanoTime();
		System.out.println(t2 - t1);
	}
	
	public String longestPalindrome(String s) {
		final int DIVIDE_SIZE = 30;
		final int MATCH_LENGTH = 5;

		int length = s.length();
		if (length == 0) {
			return "";
		}
		
		//对长度大于20的 想办法先做一些优化
		if (length > DIVIDE_SIZE) {
			//如果某5个字符的倒序都不存在，则可以以那五个字符为界分为两个字符串
			for (int i = 0; i < length - MATCH_LENGTH; i++) {
				String pattern = s.substring(i, i + MATCH_LENGTH);
				if (!isPalindrome(s)) {
					String reversePattern = new StringBuilder(pattern).reverse().toString();
					if (!s.contains(reversePattern)) {
						String s1 = longestPalindrome(s.substring(0, i + MATCH_LENGTH - 1));
						String s2 = longestPalindrome(s.substring(i + 1));

						return s1.length() > s2.length() ? s1 : s2;
					}
				}
			}
		}
		
		return doGetLongestPalindrome(s);
	}
	
	private String doGetLongestPalindrome(String s) {
		//先统计每个字符在字符串中的位置，组装成一个map
		Map<Character, List<Integer>> map = getStrCharacterPositionMap(s);
		
		int maxLength = 0;
		String subStr = null;
		for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() < 2) {
				continue;
			}
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 1; j < list.size(); j++) {
					if (list.get(j) - list.get(i) + 1 > maxLength) {
						String temp = s.substring(list.get(i), list.get(j) + 1);
						if (isPalindrome(temp)) {
							subStr = temp;
							maxLength = subStr.length();
						}
					}
				}
			}
		}
		
		if (maxLength >= 1) {
			return subStr;
		}
		return s.substring(0, 1);
	}

	private boolean isPalindrome(String x) {
		if (x.length() <= 1) {
			return true;
		}
		int length = x.length();
		for (int i = 0; i < length / 2; i ++) {
			if (x.charAt(i) != x.charAt(length - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 获取字符串中每个字符的位置的列表 o(n)
	 * @param s 字符串
	 * @return 一个map，key是字符，value是它出现的位置
	 */
	private Map<Character, List<Integer>> getStrCharacterPositionMap(String s) {
		Map<Character, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			List<Integer> list = map.get(c);
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(i);
			map.put(c, list);
		}

		return map;
	}

}
