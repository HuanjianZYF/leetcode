package Z741_760;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/14 13:52
 **/
public class NetworkDelayTime743 {

    /**
     * 求出从这个节点到所有节点中最大的时间
     *
     * @param times 表示一个定向边的数组
     * @param N 表示节点的个数
     * @param K 表示起点
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        int max = -1;
        for (int i = 1; i <= N; i++) {
            int time = timeToNode(times, K);
            if (time == -1) {
                return -1;
            }
            if (time > max) {
                max = time;
            }
        }

        return max;
    }

    private int timeToNode(int[][] times, int start) {
        return 0;
    }
}
