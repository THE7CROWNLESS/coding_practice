package leetcode;

public class MaxDepthOfBST {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 1;
        }

        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;

        return Math.max(leftDepth,rightDepth);
    }

}
