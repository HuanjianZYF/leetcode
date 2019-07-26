package Z21_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数独外挂
 * @Author wb-zyf471922
 * @Date 2019/7/26 16:34
 **/
public class SodokuSolver37 {

    public static void main(String[] args) {
        char[][] sudu =
           {{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        new SodokuSolver37().solveSudoku(sudu);
    }

    public void solveSudoku(char[][] board) {
        System.out.println("需要解的数独是\n" + printArray(board));
        long t1 = System.currentTimeMillis();
        qianjin(board);
        long t2 = System.currentTimeMillis();
        System.out.println("t2 - t1 = " + (t2 - t1) + "ms");
        System.out.println("费劲千辛万苦接出来的数独结果是\n" + printArray(board));
    }

    private String printArray(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                sb.append(board[i][j]).append(',');
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    private boolean qianjin(char[][] board) {

        // 如果数独已经不对了，需要回溯
        if (!isValidSudoku(board)) {
            return false;
        }

        // 圆满
        if (full(board)) {
            return true;
        }

        // 找到第一个没填的格子，try
        int i = 0;
        int j = 0;
        a:for (i = 0; i <= 8; i++) {
            for (j = 0; j <= 8; j++) {
                if ('.' == board[i][j]) {
                    break a;
                }
            }
        }
        for (int k = 1; k <= 9; k++) {
            char[][] copy = arrayCopy(board);
            copy[i][j] = (char) (k + '0');
            if (qianjin(copy)) {
                deepCopy(copy, board);
                return true;
            }
        }

        return false;
    }

    private void deepCopy(char[][] in, char[][] out) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                out[i][j] = in[i][j];
            }
        }
    }

    private char[][] arrayCopy(char[][] in) {
        char[][] result = new char[9][9];
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                result[i][j] = in[i][j];
            }
        }
        return result;
    }

    private boolean full(char[][] board) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

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
