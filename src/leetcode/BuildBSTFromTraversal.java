package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BuildBSTFromTraversal {
    Map<Integer,Integer> hash = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i],i);
        }
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight){
            return null;
        }

        TreeNode node = new TreeNode(preorder[preLeft]);
        int leftLen = hash.get(preorder[preLeft]) - inLeft;

        node.left = build(preorder,inorder,preLeft+1,preLeft+leftLen,inLeft,inLeft+leftLen-1);
        node.right = build(preorder,inorder,preLeft+leftLen+1,preRight,leftLen+inLeft+1,inRight);
        return node;
    }
}
