package Z261_280;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/21 17:25
 **/
public class FirstBadVersion278 {

    public int firstBadVersion(int n) {
        return findFirstBadVersion(1, n);
    }

    private int findFirstBadVersion(int start, int end) {
        if (start == end) {
            return start;
        }

        int mid = (end - start) / 2 + start;
        boolean bad = isBadVersion(mid);
        if (bad) {
            return findFirstBadVersion(start, mid);
        } else {
            return findFirstBadVersion(mid + 1, end);
        }
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
