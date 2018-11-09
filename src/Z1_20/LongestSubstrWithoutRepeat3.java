package Z1_20;

import java.util.*;

/**
 * @author zyf
 * @date 2018/9/6 上午8:54
 */
public class LongestSubstrWithoutRepeat3 {

	public static void main(String[] args) {
		System.out.println(new LongestSubstrWithoutRepeat3().lengthOfLongestSubstring("abcdefgabcdefg"));
	}

	/**
	 * 获取最长子串
	 * 可以遍历一遍字符串，统计每个字符在字符串中的位置，放到一个map里
	 * 然后我们可以获取一个禁区list，一个禁区指 譬如（2，6）从2不能到 6 
	 * 我们获取的禁区列表可能不是最简约的，譬如同时存在（2，6）（4，5），进行化简，并用左界从小到大排序
	 * 之后就从字符串从左到右遍历即可
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		long t1 = System.nanoTime();
		//将字符串变成一个字符出现的位置信息的map
		Map<Character, List<Integer>> map = getStrCharacterPositionMap(s);
		long t2 = System.nanoTime();

		//当出现某一个字符，在字符串中出现3次或以上时，可以把字符串分割成两个，为两半部分中最长的那个
		List<Part> parts = splitPart(new Part(s, map));
		long t3 = System.nanoTime();

		int max = 0;
		for (Part part : parts) {
			int val = getMaxLengthFromOnePart(part);
			if (val > max) {
				max = val;
			}
		}
		long t4 = System.nanoTime();

		System.out.println(t2 - t1);
		System.out.println(t3 - t2);
		System.out.println(t4 - t3);

		return max;
	}

	private int getMaxLengthFromOnePart(Part part) {
		Map<Character, List<Integer>> map = part.map;
		String s = part.s;

		//将字符位置信息的map变成一个禁区list
		List<ForbiddenArea> forbiddenAreas = transCharMap2ForbiddenAreaList(map);

		//化简禁区list
		simplifiedForbiddenAreaList(forbiddenAreas);

		long t4 = System.nanoTime();
		//遍历字符串 得到最大子串长度
		int max = 0;
		int lastStart = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i < lastStart) {
				continue;
			}

			boolean hasForbidden = false;
			for (ForbiddenArea area : forbiddenAreas) {
				if (area.start >= i) { //第一个禁区
					int len = area.end - i;
					if (len > max) {
						max = len;
					}
					hasForbidden = true;
					lastStart = area.start;
					break;
				}
			}

			if (!hasForbidden) {
				int len = s.length() - i;
				if (len > max) {
					max = len;
				}
			}
		}

		return max;
	}

	/**
	 * 将大字符串找最长不重复子串的问题分解，递归成找子串的最长不重复子串
	 * @param part
	 * @return
	 */
	private List<Part> splitPart(Part part) {
		//只要有某一个字符能够出现3次或以上，就可以把字符串分解
		for (Map.Entry<Character, List<Integer>> entry : part.map.entrySet()) {
			List<Integer> value = entry.getValue();

			if (value.size() > 2) { //有重复次数超过2的字符，将问题分成两部分
				return doSplit(value, part.s, part.map);
			}
		}

		List<Part> resultList = new ArrayList<>();
		resultList.add(part);
		return resultList;
	}

	/**
	 * 当某一个字符重复超过3个时，它可以分解为 n - 1 个字符串 
	 */
	private List<Part> doSplit(List<Integer> value, String s, Map<Character, List<Integer>> map) {
		List<Part> resultList = new ArrayList<>();
		
		for (int i = -1; i < value.size() - 1; i++) { //左闭右开
			int start = 0;
			int end = 0;
			if (i < value.size() - 2) {
				end = value.get(i + 2);
			} else {
				end = s.length();
			}
			
			if (i == -1) {
				start = 0;
			} else {
				start = value.get(i);
			}
			
			String subStr = s.substring(start, end);
			Map<Character, List<Integer>> subMap = getSubMap(map, start, end);
			resultList.addAll(splitPart(new Part(subStr, subMap)));
		}
		
		return resultList;
	}

	/**
	 * 获取一个子map
	 */
	private Map<Character, List<Integer>> getSubMap(Map<Character, List<Integer>> map, int start, int end) {
		Map<Character, List<Integer>> resultMap = new HashMap<>();
						
		for (Map.Entry<Character, List<Integer>> entry1 : map.entrySet()) {
			Character key = entry1.getKey();
			List<Integer> value = entry1.getValue();
			List<Integer> subList = new ArrayList<>();
			
			for (Integer a : value) {
				if (a >= start && a < end) {
					subList.add(a - start);
				}
			}

			if (subList.size() > 0) {
				resultMap.put(key, subList);
			}
		}
		
		return resultMap;
	}


	/**
	 * 将禁区list进行化简，最后会返回一个左界从小到大排列的禁区列表 o(n^2)
	 */
	private void simplifiedForbiddenAreaList(List<ForbiddenArea> list) {
		if (list == null || list.size() == 0) {
			return;
		}
		List<ForbiddenArea> listCopy = new ArrayList<>(list);

		//遍历化简..
		int index = 0;
		for (Iterator<ForbiddenArea> iterator = list.iterator(); iterator.hasNext(); ) {
			ForbiddenArea area1 = iterator.next();

			for (int j = 0; j < listCopy.size(); j++) {
				if (index == j) {
					continue;
				}
				ForbiddenArea area2 = listCopy.get(j);
				if (isSupset(area1, area2)) { //如果第一个集合是第二个的超集，那么第一个集合是多余的
					iterator.remove();
					break;
				}
			}
			index++;
		}

		//排序
		Collections.sort(list, (a, b) -> {
			int diff = a.start - b.start;
			return (diff) > 0 ? 1 : diff == 0 ? a.end - b.end : -1;
		});
	}

	private boolean isSupset(ForbiddenArea area1, ForbiddenArea area2) {
		return area1.start <= area2.start && area1.end >= area2.end;
	}

	/**
	 * 将字符出现位置的map转化为一个禁区list o(n)
	 */
	private List<ForbiddenArea> transCharMap2ForbiddenAreaList(Map<Character, List<Integer>> map) {
		List<ForbiddenArea> resultList = new ArrayList<>();

		for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			if (list.size() < 2) {
				continue;
			}
			for (int i = 0; i < list.size() - 1; i++) {
				resultList.add(new ForbiddenArea(list.get(i), list.get(i + 1)));
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

	//禁区
	private class ForbiddenArea {
		int start;
		int end;

		ForbiddenArea(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	private class Part {
		String s;
		Map<Character, List<Integer>> map;

		Part(String s, Map<Character, List<Integer>> map) {
			this.s = s;
			this.map = map;
		}
	}

}
