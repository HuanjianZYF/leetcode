package one_twenty;

import java.util.*;

/**
 * @author zyf
 * @date 2018/9/6 下午5:06
 */
public class LongestPalindromicSubstring5 {
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring5().longestPalindrome("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
	}
	
	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		Map<Character, List<Integer>> map = getStrCharacterPositionMap(s);
		List<Block> blocks = transCharMap2BlockList(map);
		Collections.sort(blocks, (a, b) -> b.length - a.length);
		for (Block block : blocks) {
			String subStr = s.substring(block.start, block.end + 1);
			if (isPalindrome(subStr)) {
				return subStr;
			}
		}
		return s.substring(0, 1);
	}

	private boolean isPalindrome(String x) {
		StringBuilder sb = new StringBuilder(x);
		sb.reverse();
		String s2 = sb.toString();

		return x.equals(s2);
	}

	/**
	 * 将字符出现位置的map转化为一个禁区list o(n)
	 */
	private List<Block> transCharMap2BlockList(Map<Character, List<Integer>> map) {
		List<Block> resultList = new ArrayList<>();

		for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() < 2) {
				continue;
			}
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 1; j < list.size(); j++) {
					resultList.add(new Block(list.get(i), list.get(j), list.get(j) - list.get(i)));
				}
			}
		}

		return resultList;
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
	
	private class Block {
		private int start;
		private int end;
		private int length;

		public Block(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}
	}
}
