package Z461_480;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/31 19:22
 **/
public class IslandPerimeter463 {

    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int result = 0;
        for (int i = 0; i <= row - 1; i++) {
            for (int j = 0; j <= col - 1; j++) {
                if (grid[i][j] == 1) {
                    // 上
                    if (i == 0 || grid[i - 1][j] == 0) {
                        result++;
                    }
                    // 下
                    if (i == row - 1 || grid[i + 1][j] == 0) {
                        result++;
                    }
                    // 左
                    if (j == 0 || grid[i][j - 1] == 0) {
                        result++;
                    }
                    // 右
                    if (j == col - 1 || grid[i][j + 1] == 0) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
