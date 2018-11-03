package sixty_eighty;

/**
 * @Author zyf
 * @Date 下午9:42
 **/
public class PlusOne66 {

    public static void main(String[] args) {
        int[] result = new PlusOne66().plusOne(new int[]{9});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int len = digits.length;
        int[] result = new int[len];

        // 1. 把数组分成两部分，右边一部分是需要+1的
        int toAdd = 1;
        int index = len - 1;
        while (toAdd > 0 && index >= 0) {
            result[index] = (digits[index] + 1) % 10;
            toAdd = digits[index] == 9 ? 1 : 0;
            index--;
        }

        // 2. 如果全部都要+1，且还进位,结果是1拼上上面的结果
        if (toAdd > 0) {
            int[] newResult = new int[len + 1];
            newResult[0] = 1;
            System.arraycopy(result, 0, newResult,1, len);
            return newResult;
        }

        // 3.把剩余不动的部分补上
        for (int i = index; i >= 0; i--) {
            result[i] = digits[i];
        }

        return result;
    }
}
