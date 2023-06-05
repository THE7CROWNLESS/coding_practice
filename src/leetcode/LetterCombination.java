package leetcode;

import java.util.ArrayList;
import java.util.List;
//回溯法：递归+剪枝（及时退回）
//递归：很难确定循环次数，或者说循环次数与结果/输入深度有关系，可以用递归法，只用明确结束条件，递归调用即可。

//集合求子集：1、每次添加当前元素（很好统一处理）。2、每一轮是一种长度子集，在上轮子集结果中添加包含外的元素（包含外的判断很难，用hash解决？？？）
//eg:[1,2,3]-->方法一 [1]; [1,2],[2]; [1,2,3],[2,3],[3] 总和是所有子集，最后一轮是len长的结果
//             方法二 [1],[2],[3]; [1,2],[1,3],[2,3]; [1,2,3]
public class LetterCombination {

    //队列求解（其实就是非递归的方法，易懂的解释命名）
    //任何递归形式的算法都能通过栈、队列等数据结构转化为非递归的形式。
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        List<String> dig2str = dig2letter(digits);

        //给定初始值：使res具有后续进入循环的可能
        for (int k = 0; dig2str.size() > 0  && k < dig2str.get(0).length(); k++) {
            res.add(dig2str.get(0).substring(k, k + 1));
        }

        for (int i = 1; i < dig2str.size(); i++) {
            List<String> tmp = new ArrayList<>();   //tmp和res的组合相当于队列，tmp是当前需要出队的上一层结果，res则保存tmp加完当前结果后的入队元素。
            for (int j = 0; j < res.size(); j++) {
                for (int k = 0; k < dig2str.get(i).length(); k++) {
                    tmp.add(res.get(j) + dig2str.get(i).charAt(k));
                }
            }
            res = tmp;
            }

            return res;

    }

    //digits 2 letters
    public List<String> dig2letter(String digits){
        List<String> dig2str = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2' -> dig2str.add("abc");
                case '3' -> dig2str.add("def");
                case '4' -> dig2str.add("ghi");
                case '5' -> dig2str.add("jkl");
                case '6' -> dig2str.add("mno");
                case '7' -> dig2str.add("pqrs");
                case '8' -> dig2str.add("tuv");
                case '9' -> dig2str.add("wxyz");
            }
        }
        return dig2str;
    }

    //回溯法
    public void backtrack(String s, List<String> res){
        if(s.length() == 0){
            res.add(" ");
        }
        backtrack(s.substring(1, s.length()), res);
    }
}


