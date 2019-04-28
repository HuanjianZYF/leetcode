package Z541_560;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/14 14:00
 **/
public class StudentAttendanceRecord551 {

    // 学生超过1次缺席或者超过2次连续迟到，就过不了了
    public boolean checkRecord(String s) {

        return checkAbsent(s) && checkLate(s);
    }

    private boolean checkLate(String s) {
        int num = 0;

        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) == 'L') {
                num++;
                if (num >= 3) {
                    return false;
                }
            } else {
                num = 0;
            }
        }

        return true;
    }

    private boolean checkAbsent(String s) {
        int num = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) == 'A') {
                num++;
                if (num >= 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
