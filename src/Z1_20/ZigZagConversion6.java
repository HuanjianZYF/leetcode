package Z1_20;


/**
 * @Author wb-zyf471922
 * @Date 2018/11/30 16:47
 **/
public class ZigZagConversion6 {

    /**
     * 像是在开发游戏
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }

        int len = s.length();
        // 奢侈
        char[][] table = new char[numRows][len];
        Position pos = new Position(0 , 0, true);
        for (int i = 0; i <= len - 1; i++) {
            pos = set2Position(table, pos, s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= numRows - 1; i++) {
            for (int j = 0; j <= len - 1; j++) {
                if (table[i][j] != 0) {
                    sb.append(table[i][j]);
                }
            }
        }

        return sb.toString();
    }

    private Position set2Position(char[][] table, Position pos, char ch) {
        table[pos.row][pos.col] = ch;
        int totalRow = table.length;

        if (pos.down) {
            if (pos.row != totalRow - 1) {
                return new Position(pos.row + 1, pos.col, true);
            } else {
                return new Position(pos.row - 1, pos.col + 1, false);
            }
        } else {
            if (pos.row == 0) {
                return new Position(1, pos.col, true);
            } else {
                return new Position(pos.row - 1, pos.col + 1, false);
            }
        }
    }

    private class Position {
        int row;
        int col;
        boolean down;

        public Position(int row, int col, boolean down) {
            this.row = row;
            this.col = col;
            this.down = down;
        }
    }
}
