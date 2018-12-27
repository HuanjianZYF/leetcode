package Z421_440;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/27 17:44
 **/
public class N_aryTreeLevelOrderTraversal429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        resultList.add(first);

        List<Node> lastList = root.children;
        while (lastList != null && lastList.size() > 0) {
            List<Integer> element = new ArrayList<>();
            for (Node node : lastList) {
                element.add(node.val);
            }
            resultList.add(element);

            List<Node> tmp = new ArrayList<>();
            for (Node node : lastList) {
                tmp.addAll(node.children);
            }

            lastList.clear();
            lastList.addAll(tmp);
        }

        return resultList;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
