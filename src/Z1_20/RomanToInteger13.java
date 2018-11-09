package Z1_20;

/**
 * @author zyf
 * @date 2018/9/5 下午7:16
 */
public class RomanToInteger13 {
	
	public int romanToInt(String s) {
		int sum = 0;
		
		boolean jmp = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (jmp) { //是否跳过这个字符
				jmp = false;
				continue;
			}
			
			char c = s.charAt(i);
			switch (c) {
				case 'I' :{
					sum += 1;
					break;
				}
				case 'V' :{
					if (i != 0) {
						char lastChar = s.charAt(i - 1);
						if ('I' == lastChar) {
							jmp = true;
							sum += 4;
							break;
						}
					}
					
					sum += 5;
					break;
				}
				case 'X' :{
					if (i != 0) {
						char lastChar = s.charAt(i - 1);
						if ('I' == lastChar) {
							jmp = true;
							sum += 9;
							break;
						}
					}

					sum += 10;
					break;
				}
				case 'L' :{
					if (i != 0) {
						char lastChar = s.charAt(i - 1);
						if ('X' == lastChar) {
							jmp = true;
							sum += 40;
							break;
						}
					}

					sum += 50;
					break;
				}
				case 'C' :{
					if (i != 0) {
						char lastChar = s.charAt(i - 1);
						if ('X' == lastChar) {
							jmp = true;
							sum += 90;
							break;
						}
					}

					sum += 100;
					break;
				}
				case 'D' :{
					if (i != 0) {
						char lastChar = s.charAt(i - 1);
						if ('C' == lastChar) {
							jmp = true;
							sum += 400;
							break;
						}
					}

					sum += 500;
					break;
				}
				case 'M' :{
					if (i != 0) {
						char lastChar = s.charAt(i - 1);
						if ('C' == lastChar) {
							jmp = true;
							sum += 900;
							break;
						}
					}

					sum += 1000;
					break;
				}
			}
		}
		
		return sum;
	}
	
	
}
