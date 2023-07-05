package leetcode;

import java.util.*;

class MinStack2 {

    private Deque<Integer> stack;
    private Deque<Integer> min;
    //重点理解
//    只要栈顶的元素是 a，那么我们就可以确定栈里面现在的元素一定是 a, b, c, d。
//
//    那么，我们可以在每个元素 a 入栈时把当前栈的最小值 m 存储起来。在这之后无论何时，如果栈顶元素是 a，我们就可以直接返回存储的最小值 m。

    //优化：（一个栈），问题在于最小元素出栈时，丢失了当前的最小值
    //1、入栈时，如果更新了当前的最小值，则将旧的旧的最小值存入栈中；出栈时，元素等于最小值时，再次出栈，获取最小元素
    //2、入栈：栈内保存与最小元素的差值，若遇到更小的值，则保存为负数，并且更换最小值，即当前元素；出栈：弹出 栈内元素+min，若为负数，弹出min，且更新min = min - 栈内元素(负数)
    public MinStack2() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        min.push(Math.min(val, min.peek()));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}


//一个栈记录，另一个栈排序，复杂度高
public class MinStack {

    private List<Integer> stack;
    private List<Integer> min;

    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int val) {
        stack.add(val);
        min.add(val);
        //min.sort(((o1, o2) -> o1- o2)); 相减操作导致越界，负数减正数越界，符号被改变，反而大于0
        min.sort((Comparator.comparingInt(o -> o)));
    }

    public void pop() {
        int a = top();
        stack.remove(stack.size() - 1);
        min.remove((Object) a);
        min.sort((Comparator.comparingInt(o -> o)));
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min.get(0);
    }

}
