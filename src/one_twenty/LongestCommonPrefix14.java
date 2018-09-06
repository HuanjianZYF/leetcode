package one_twenty;

/**
 * @author zyf
 * @date 2018/9/5 下午7:35
 */
public class LongestCommonPrefix14 {
	
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String nowCommonStr = strs[0];
		for (int i = 1; i < strs.length; i++) {
			nowCommonStr = getTwoStrCommonStr(nowCommonStr, strs[i]);
			if ("".equals(nowCommonStr)) {
				return "";
			}
 		}
		return nowCommonStr;
	}
	

	/**
	 * 获得两个字符串的公共部分
	 */
	private String getTwoStrCommonStr(String s1, String s2) {
		if ("".equals(s1) || "".equals(s2)) {
			return "";
		}
		
		int length1 = s1.length();
		int length2 = s2.length();
		int length = length1 < length2 ? length1 : length2;

		int i = 0;
		for (; i < length; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			}
		}
		
		return s1.substring(0, i);
	}
}
