package Z441_460;

import java.util.*;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/18 15:15
 **/
public class SortCharactersByFrequency451 {

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency451().frequencySort("atee"));
    }

    /**
     * 将字符串变成按字符数量倒序排列的
     * 显然只要记住每个字符出现了多少次，就可以重新生成结果字符串
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        Map<Character, Node> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            Character c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, new Node(c, 1));
            } else {
                map.put(c, new Node(c, map.get(c).num +1));
            }
        }

        List<Node> list = new ArrayList<>();
        map.forEach((key, value) -> list.add(value));

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.num - o1.num;
            }
        });

        StringBuilder result = new StringBuilder();
        for (Node node : list) {
            for (int i = 0; i < node.num; i++) {
                result.append(node.ch);
            }
        }

        return result.toString();
    }

    private class Node {
        char ch;
        int num;

        public Node(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }
    }
}
