package Z1_20;

/**
 * @author zyf
 * @date 2018/9/5 下午6:57
 */
public class ReverseInteger7 {
	
	public int reverse(int x) {
		String resultStr = "";
		
		String s = Integer.toString(x);
		if ('-' == s.charAt(0)) { //如果是负数，把负号加入结果中
			resultStr += "-";
			s = s.substring(1, s.length());
		}
		
		//把正数字符串反转一下
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		s = sb.toString();
		
		//找到第一个非0的下标
		int i = 0;
		for (; i < s.length(); i++) {
			if(s.charAt(i) != '0') {
				break;
			}
		}
		
		s = s.substring(i, s.length());
		if (s.length() == 0) { //反转之后为0
			return 0;
		}
		resultStr += s;
		
		//判断反转之后是不是越界了
		Long a = Long.parseLong(s);
		if (a > Integer.MAX_VALUE || a < Integer.MIN_VALUE) {
			return 0;
		}
		
		return Integer.parseInt(resultStr);
	}
}
