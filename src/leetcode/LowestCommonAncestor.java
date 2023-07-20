package leetcode;

import java.util.ArrayList;
import java.util.List;

//非递归后序遍历
//真正理解栈的用处，帮助回退使用，相当于递归时的回溯。
// 递归中一个函数退出，有外层函数中的变量保存的了环境，而非递归则需要栈辅助恢复上一层的环境
//同时先序和中序，访问右子树，不需要保存根的信息，直接出栈，可以保证右子树访问结束，直接回溯到正确的地方
//后序遍历需要保存根节点，所以需要记录上一次访问的节点，来判断回溯时该节点是否为正确的地方，否则继续回溯（出栈）。
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        list1.add(root);
        list2.add(root);
        findNode(list1,p);
        findNode(list2,q);

        int len1 = list1.size();
        int len2 = list2.size();

        if (len1 >= len2){
            for (int i = list2.size() - 1; i >= 0; i--) {
                if (list1.contains(list2.get(i))){
                    return list2.get(i);
                }
            }
        }else {
            for (int i = list1.size() - 1; i >= 0; i--) {
                if (list2.contains(list1.get(i))){
                    return list1.get(i);
                }
            }
        }
        return root;
    }
    public void findNode(List<TreeNode> list, TreeNode r){
        TreeNode cur = list.get(0);
        TreeNode pre = new TreeNode();
        list.remove(cur);
        while (cur!=null || !list.isEmpty()){

            while (cur!=null){
                list.add(cur);
                if (cur == r){
                    return;
                }
                cur = cur.left;
            }
            cur = list.get(list.size()-1);
            if (cur.right == null || cur.right == pre){
                pre = cur;
                list.remove(cur);
                cur = null;
            }else{
                cur = cur.right;
            }

        }
    }
}
