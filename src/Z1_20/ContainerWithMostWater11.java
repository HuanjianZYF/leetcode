package Z1_20;

/**
 * @Author wb-zyf471922
 * @Date 2019/4/28 16:41
 **/
public class ContainerWithMostWater11 {

    // 可以优化，但是没有必要
    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i <= height.length - 2; i++) {
            for (int j = i + 1; j <= height.length - 1; j++) {
                int vol = (j - i) * Math.min(height[i], height[j]);
                if (vol > max) {
                    max = vol;
                }
            }
        }

        return max;
    }
}
