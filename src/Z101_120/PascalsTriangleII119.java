package Z101_120;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/2 17:29
 **/
public class PascalsTriangleII119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i <= rowIndex ; i++) {
            resultList = generateNext(resultList);
        }

        return resultList;
    }

    private List<Integer> generateNext(List<Integer> list) {
        List<Integer> resultList = new ArrayList<>();

        int size = list.size();
        if (size == 0) {
            resultList.add(1);
            return resultList;
        }
        if (size == 1) {
            resultList.add(1);
            resultList.add(1);
            return resultList;
        }
        resultList.add(1);
        for (int i = 1; i <= size - 1; i++) {
            resultList.add(list.get(i - 1) + list.get(i));
        }
        resultList.add(1);

        return resultList;
    }
}
