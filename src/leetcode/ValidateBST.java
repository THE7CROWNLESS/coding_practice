package leetcode;
//中序遍历
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        long[] pre = new long[2];
        pre[0] = Long.MIN_VALUE;
        dfs(root,pre);
        return pre[1] != -1;
    }


    public void dfs(TreeNode root, long[] pre) {
        if (root.left != null){
            dfs(root.left, pre);
        }


        if (pre[0] < root.val){
            pre[0] = root.val;
        }else {
            pre[1] = -1;
        }

        if (root.right != null) {
            dfs(root.right, pre);
        }
    }
}
