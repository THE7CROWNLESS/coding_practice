package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GennerateParathesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
       // Stack<String> stack = new Stack<>();

        backtrack(0, 0, n, res, new StringBuilder());

        return res;
    }


    //dfs过程
    public void backtrack(int leftdepth, int rightdepth, int n, List<String> res, StringBuilder stringBuilder){
        //遍历结束，通过stringbuild记录成功路上的点，用res将所有记录保存
        if(leftdepth == n){
            StringBuilder s = new StringBuilder(stringBuilder.toString()); //尽量new，不然可能保存的节点是一个地址值，后续又被改动
                                                                            //String类型可能不会出错，因为添加(string+"")整个对象其实背后新建了一个
            for (int i = stringBuilder.length(); i < n; i++) {
                s.append(")");
            }
            res.add(s.toString());
            return;
        }
        //剪枝，不符合时及时舍弃，回溯到上一层重新遍历
        if(leftdepth < rightdepth){
            return;
        }


        //遍历左树前的操作
        stringBuilder.append("(");
        backtrack(leftdepth+1, rightdepth, n, res, stringBuilder);

        //遍历完左树，回溯的上一层根节点后的操作，
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        // 也可以加入遍历右子树前的操作
        stringBuilder.append(")");

        backtrack(leftdepth, rightdepth+1, n, res, stringBuilder);

        //遍历完右树，回溯的上一层根节点后的操作，
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

    }

}
