package Z441_460;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/30 15:35
 **/
public class NumberOfBoomeranges447 {

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        int num = points.length;
        if (num <= 2) {
            return 0;
        }

        for (int i = 0; i <= num - 3; i++) {
            for (int j = i + 1; j <= num - 2; j++) {
                for (int k = j + 1; k <= num - 1; k++) {
                    if (sameDistance(points[i], points[j], points[k])) {
                        result += 2;
                    }
                    if (sameDistance(points[j], points[i], points[k])) {
                        result += 2;
                    }
                    if (sameDistance(points[k], points[i], points[j])) {
                        result += 2;
                    }
                }
            }
        }

        return result;
    }

    private boolean sameDistance(int[] point1, int[] point2, int[] point3) {
        return squareSum(point1, point2) == squareSum(point1, point3);
    }

    private int squareSum(int[] point1, int[] point2) {
        return square(point2[0] - point1[0]) + square(point2[1] - point1[1]);
    }

    private int square(int a) {
        return a * a;
    }
}
