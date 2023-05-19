package leetcode;

public class Run {
    public static void main(String[] args) {
        int [] test =new int[] {1,2,5,8};
        int target = 7;
        TwoSum solution = new TwoSum();
        int[] res = solution.twoSum(test,target);

        System.out.println(res[0] + " " + res[1]);
    }
}
