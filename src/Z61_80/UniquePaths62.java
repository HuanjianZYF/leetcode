package Z61_80;

public class UniquePaths62 {

    /**
     * 解递归 想象矩阵，每个数字是左边的和上面数字的和 第一排和第一列都是1
     * 1111111111111111111
     * 1234 56789
     * 13610
     * 14
     * 15
     * 16
     * 17
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
