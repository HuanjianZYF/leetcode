package one_twenty;

/**
 * @author zyf
 * @date 2018/9/5 下午7:12
 */
public class PalindromeNumber9 {
	public boolean isPalindrome(int x) {
		String s = Integer.toString(x);
		
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		String s2 = sb.toString();
		
		return s.equals(s2);
	}
}
