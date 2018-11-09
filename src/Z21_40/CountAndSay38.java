package Z21_40;

/**
 * @author zyf
 * @date 2018/9/20 下午1:45
 */
public class CountAndSay38 {
	
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		return parse(countAndSay(n - 1));
	}
	
	private String parse(String s) {
		StringBuilder result = new StringBuilder();
		
		char c = s.charAt(0);
		int count = 1;
		for (int i = 1; i <= s.length() - 1; i++) {
			char each = s.charAt(i);
			if (c == each) {
				count ++;
			} else {
				result.append(count).append(c);
				count = 1;
				c = each;
			}
		}
		result.append(count).append(c);
		
		return result.toString();
	}
}
