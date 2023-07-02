package leetcode;
//借助链表存储节点的顺序，在遍历链表将节点连接（要理解地址值，只是将指向的节点地址改了，并不是修改了节点的内容）

//不借助链表：递归时用tmp保存了会被覆盖的右指针指向，再去用tmp遍历原右子树。
// 递归理解：遍历左右 + 操作。 对于操作来说，是以该节点为根的子树的操作，即该树的子树都是已操作过的形式

import java.util.ArrayList;
import java.util.List;

public class FlattenBST {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preTraversal(root,list);
        TreeNode pre = root;
        for (int i = 0; i < list.size()-1; i++) {
            pre = list.get(i);
            pre.right = list.get(i+1);
            pre.left = null;
        }

    }

    public void preTraversal(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        preTraversal(root.left,list);
        preTraversal(root.right,list);
    }
}
