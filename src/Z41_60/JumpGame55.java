package Z41_60;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/18 14:35
 **/
public class JumpGame55 {

    public static void main(String[] args) {
        System.out.println(new JumpGame55().canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
    }

    /**
     * 跳跳乐游戏：给你一个数组，刚开始你在第0位，数组上的值表示你最多可以向前走多少步，你要返回最后能不能跳到终点
     * 一个显然的递推，如果你能到这里，那么就能从这里到目的地。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return false;
        }

        return canJumpStep(nums, nums.length, set);
    }

    private boolean canJumpStep(int[] nums, int len, Set<Integer> set) {
        if (len == 1) {
            return true;
        }

        if (set.contains(len)) {
            return false;
        }

        for (int i = len - 2; i >= 0; i--) {

            // 达到这个条件的话，能到这里就直接到终点了
            if (nums[i] >= len - i - 1) {
                boolean subResult = canJumpStep(nums, i + 1, set);
                if (subResult) {
                    return true;
                } else {
                    set.add(len);
                }
            }
        }

        return false;
    }
}
