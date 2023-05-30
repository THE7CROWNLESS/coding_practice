package leetcode;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode res = new ListNode();
        ListNode tmp = res;

        while(p !=null && q != null){
            if(p.val<q.val){
                tmp.next = p;
                tmp = tmp.next;
                p = p.next;
            }else{
                tmp.next = q;
                tmp = tmp.next;
                q = q.next;
            }

        }
        System.out.println(123);
        if(p != null){
            tmp.next = p;
        }
        if(q != null){
            tmp.next = q;
        }

        return res.next;
    }
}
