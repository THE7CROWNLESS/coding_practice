package leetcode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        //最大跳跃范围，这个范围内，别管是怎么跳的，反正一定可以跳过来，并且范围内的点也都可以访问达到。
        //担心跳跃最大导致无法返回问题：for循环会扫描最大范围内的所有点，虽然记录了最远，但并未跨过中间点。
        //范围的理解：最远和最远以内，也就是能到达的点都去遍历，再更新最远范围。
        int maxEnd = 0;
        for (int i = 0; i < nums.length && i <= maxEnd; i++) {
            if((i+nums[i])>maxEnd){
                maxEnd = i + nums[i];
            }
            if(maxEnd >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
