package leetcode;

import java.util.Map;
//dp动态规划
public class HouseRobber {
    public int rob(int[] nums) {

        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0],nums[1]);
        }

        int m = nums[0];
        int n = Math.max(nums[0],nums[1]);

        for (int i = 2; i < len; i++) {
            int tmp = Math.max(m, n + nums[i]);
            m = n;
            n = tmp;
        }

        return n;
    }
}
