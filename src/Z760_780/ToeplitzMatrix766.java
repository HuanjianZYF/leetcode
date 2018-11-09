package Z760_780;

/**
 * @Author wb-zyf471922
 * @Date 15:08
 **/
public class ToeplitzMatrix766 {

    /**
     * 从左上角到右下 每个元素都相等的矩阵是 toeplitz矩阵
     *  1 2 3 4 5
     *  2 3 4 5 6
     *  3 4 5 6 7
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null) {
            return false;
        }
        int rowNum = matrix.length;
        if (rowNum == 0) {
            return true;
        }
        int colNum = matrix[0].length;

        /**
         * 关键在于得到 所有的对角的的元素组成的列表，判断这些列表里的元素是不是都相等
         * 1. 遍历上边界和左边界，得到所有的列表
         * 2. 从第一个元素开始连，直到下一个元素的行和列还在矩阵内
         */
        for (int i = 0; i <= colNum - 1; i++) {
            if (!checkCurrent(0, i, matrix, rowNum, colNum)) {
                return false;
            }
        }

        for (int i = 1; i <= rowNum - 1; i++) {
            if (!checkCurrent(i, 0, matrix, rowNum, colNum)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCurrent(int row, int col, int[][] matrix, int rowNum, int colNum) {
        Integer value = matrix[row][col];
        while (row < rowNum && col < colNum) {
            if (matrix[row][col] != value) {
                return false;
            }
            row++;
            col++;
        }

        return true;
    }

}
