package leetcode;

//栈结构 + hashmap作为匹配用

import java.util.Calendar;
import java.util.Stack;

//做括号就入栈/递归，
//右括号就出栈/递归当前匹配
//匹配结束且栈空/未提前结束，成功
public class BraceIsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '（' ){
                stack.push(s.charAt(i));
            }else if(!stack.empty()){
                 char left = stack.pop();
                 char right = s.charAt(i);
                 if((left == '[' && right == ']') || (left == '{' && right == '}') || (left == '(' && right == ')')){
                     continue;
                 }else {
                     return false;
                 }
            }else {
                return false;
            }
        }
        //避免if(stack.empty())else语句 哈哈哈哈
        return stack.empty();

    }
}
