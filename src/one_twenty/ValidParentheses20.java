package one_twenty;

import sun.security.provider.MD5;

import java.util.Map;
import java.util.Stack;

/**
 * @author zyf
 * @date 2018/9/6 下午4:27
 */
public class ValidParentheses20 {
	
	public static void main(String[] args) {
		System.out.println(new ValidParentheses20().isValid("("));
	}
	
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack stack = new Stack();
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
				case '(':
				case '[':
				case '{': {
					stack.push(ch);
					break;
				}
				case ')':
				case ']':
				case '}': {
					char stackInfo = '0';
					try {
						stackInfo = (char) stack.pop();
					} catch (Exception e) {
					}
					if (notMatch(ch, stackInfo)) {
						return false;
					}
					break;
				}
				default:{
					return false;
				}
			}
		}
		
		return stack.empty();
	}
	
	private boolean notMatch(char ch1, char ch2) {
		if (ch1 == ')') {
			return ch2 != '(';
		}
		if (ch1 == ']') {
			return ch2 != '[';
		}
		if (ch1 == '}') {
			return ch2 != '{';
		}
		return true;
	}
}
