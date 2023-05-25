package leetcode;

import javax.jws.soap.SOAPBinding;

public class Run {
    public static void main(String[] args) {
        int [] test =new int[] {0,1,2,1,2,1,2,0,0,0};
        int target = 1;
        HelanFlag solution = new HelanFlag();
        solution.helanFlagV1(test,target);


    }
}
