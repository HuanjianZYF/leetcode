package Z21_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2019/7/26 11:40
 **/
public class ValidSudoku36 {

    /**
     * 判断一个数独的题是不是合理的
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        // 检查横的
        if (!checkRow(board)) {
            return false;
        }

        // 检查纵的
        if (!checkCol(board)) {
            return false;
        }

        // 检查9个格子
        return check999(board);
    }

    private boolean check999(char[][] board) {
        return checkOne(board,0, 0) && checkOne(board,0, 3) && checkOne(board,0, 6)
            && checkOne(board,3, 0) && checkOne(board,3, 3) && checkOne(board,3, 6)
            && checkOne(board,6, 0) && checkOne(board,6, 3) && checkOne(board,6, 6);
    }

    private boolean checkOne(char[][] board, int row, int col) {
        List<Character> list = new ArrayList<>();
        list.add(board[row][col]);
        list.add(board[row + 1][col]);
        list.add(board[row + 2][col]);
        list.add(board[row][col + 1]);
        list.add(board[row + 1][col + 1]);
        list.add(board[row + 2][col + 1]);
        list.add(board[row][col + 2]);
        list.add(board[row + 1][col + 2]);
        list.add(board[row + 2][col + 2]);

        return isValid9(list);
    }

    private boolean checkCol(char[][] board) {
        for (int i = 0; i <= 8; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j <= 8; j++) {
                list.add(board[j][i]);
            }
            if (!isValid9(list)) {
                return false;
            }
        }
        return true;
    }


    private boolean checkRow(char[][] board) {
        for (int i = 0; i <= 8; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j <= 8; j++) {
                list.add(board[i][j]);
            }
            if (!isValid9(list)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断9个字符是不是符合
     * @param list
     * @return
     */
    private boolean isValid9(List<Character> list) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : list) {
            if (ch != '.') {
                if (map.get(ch) != null) {
                    return false;
                }
                map.put(ch, 1);
            }
        }

        return true;
    }
}
