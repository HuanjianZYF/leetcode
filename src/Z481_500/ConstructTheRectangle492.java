package Z481_500;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/2 17:00
 **/
public class ConstructTheRectangle492 {

    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int small = (int) Math.sqrt(area);
        while (small >= 1) {
            if (area % small == 0) {
                result[0] = area / small;
                result[1] = small;
                break;
            }
            small--;
        }

        return result;
    }
}
