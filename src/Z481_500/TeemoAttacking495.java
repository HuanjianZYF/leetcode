package Z481_500;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/19 19:56
 **/
public class TeemoAttacking495 {

    public static void main(String[] args) {
        System.out.println(new TeemoAttacking495().findPoisonedDuration(new int[]{1,2,3,4,5}, 5));
    }

    /**
     * 提莫的攻击中毒是很多的线段的结合
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        List<Segment> list = new ArrayList<>();

        a:for (int each : timeSeries) {
            for (int i = 0; i <= list.size() - 1; i++) {
                if (inSegment(list.get(i), each, each + duration - 1)) {
                    list.set(i, mergeTwoSegment(list.get(i), new Segment(each, each + duration - 1)));
                    continue a;
                }
            }
            list.add(new Segment(each, each + duration - 1));
        }

        int result = 0;
        for (Segment segment : list) {
            result += segment.size();
        }

        return result;
    }

    private Segment mergeTwoSegment(Segment segment1, Segment segment2) {
        int start = segment1.start > segment2.start ? segment2.start : segment1.start;
        int end = segment1.end > segment2.end ? segment1.end : segment2.end;
        return new Segment(start, end);
    }

    private boolean inSegment(Segment segment, int start, int end) {
        return !(end < segment.start || start > segment.end);
    }

    private static class Segment {
        int start;
        int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int size() {
            return end - start + 1;
        }
    }
}
