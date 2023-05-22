package leetcode;

public class Run {
    public static void main(String[] args) {
//        int [] test =new int[] {1,2,5,8};
//        int target = 7;
//        TwoSum solution = new TwoSum();
//        int[] res = solution.twoSum(test,target);
//
//        System.out.println(res[0] + " " + res[1]);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        MergeList mergeList = new MergeList();
        ListNode res = mergeList.mergeTwoLists(l1,l2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;

        }
    }
}
