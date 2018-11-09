package Z21_40;

/**
 * @author zyf
 * @date 2018/9/18 上午11:06
 */
public class ImplementsStrStr28 {
	
	public int strStr(String haystack, String needle) {
		if (needle == null || haystack == null) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		
		int length1 = haystack.length();
		int length2 = needle.length();
		if (length1 < length2) { //长度都不够
			return -1;
		}
		
		for (int i = 0; i <= length1 - length2; i++) {
			if (needle.equals(haystack.substring(i, i + length2))) {
				return i;
			}
		}
		return -1;
	}
}
