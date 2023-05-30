package leetcode;


import java.util.Map;

public class Run {
    public static void main(String[] args) {
        int [] test = new int[] {0,1,2,1,2,1,2,0,0,0,1,1,1,1,1,1};
        int [] test2 = new int [] {5,56,897,8,90,12};
        int [] test3 = new int [] {7,6,4,3,1};
        int [] test4 = new int [] {-2,3,-1,0,1,2,-1,-4};

        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum_1(test4));

    }
}
