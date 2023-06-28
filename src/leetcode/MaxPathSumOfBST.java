package leetcode;
public class MaxPathSumOfBST {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }


    public int maxGain(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = maxGain(root.left);
        int right = maxGain(root.right);
        int curr = root.val + Math.max(0,left) + Math.max(0,right);
        max = Math.max(curr,max);

        return root.val + Math.max(Math.max(0,left), Math.max(0,right));

    }
}
