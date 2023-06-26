package leetcode;
//层序遍历
//可以利用变量值记录时刻在变化的长度。
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return new ArrayList<>(); //返回值可以如此声明，则会返回[],而非[[]]，同时满足编译要求
        }else {
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            List<Integer> path = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                path.add(queue.poll().val);
            }
            res.add(path);
        }
        return res;
    }
}
