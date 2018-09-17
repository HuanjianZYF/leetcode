package one_twenty;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author zyf
 * @date 2018/9/15 上午8:34
 */
public class IntToRoman12 {
	
	public static void main(String[] args) {
		System.out.println(new IntToRoman12().intToRoman(1994));
	}
	
	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		
		//初始化罗马数字与数字的map
		TreeMap<Integer, String> map = new TreeMap<>((a, b) -> b - a);
		initMap(map);
		
		while (num > 0) {
			for (Map.Entry<Integer, String> entry : map.entrySet()) {
				int key = entry.getKey();
				if (num >= key) {
					result.append(map.get(key));
					num -= key;
					break;
				}
			}
		}
		
		return result.toString();
	}
	
	private void initMap(Map<Integer, String> map) {
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
	}
}
