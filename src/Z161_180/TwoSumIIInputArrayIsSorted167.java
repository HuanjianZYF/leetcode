package Z161_180;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/14 15:14
 **/
public class TwoSumIIInputArrayIsSorted167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i <= numbers.length - 2; i++) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                } else if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return result;
    }
}
