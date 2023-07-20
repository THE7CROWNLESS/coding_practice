package leetcode;

import java.util.Arrays;

public class ProductExceptSelf {
    //    左右累乘，巧妙记录每个元素的左右乘积
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        int left = 1, right = 1;

        for (int i = 0; i < len; i++) {
            res[i] = res[i] * left;
            left = left * nums[i];     //左边累积，且计算完res[i]才将nums[i]累乘上

            res[len - 1 - i] = res[len - 1 - i] * right;
            right = right * nums[len - 1 - i];    //右侧对称累积，因此res中每个元素都会与左右各乘一次
        }
        return res;
    }
}
