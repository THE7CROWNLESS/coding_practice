package leetcode;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null){
            return  true;
        }else {
            return backtrack(root.left,root.right);
        }
    }

    public boolean backtrack(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 ==null){
            return true;
        }
        if(root1 == null || root2 ==null || root2.val != root1.val){
            return false;
        }

       return (backtrack(root1.left,root2.right) && backtrack(root1.right,root2.left));
    }
}
