package leetcode;
//利用边界值或者hash判断是否访问过
//快慢指针判断是否有环
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        while (head != null && head.val!= 100001){
            head.val = 100001;
            head = head.next;
        }
        return head == null;
    }


    public ListNode doubleReference(ListNode head){
        if (head == null || head.next ==null){
            return null;
        }
        ListNode quick = head.next;
        ListNode slow = head;

        while (quick != null){
            if(quick == slow){
                break;
            }else {
                if (quick.next == null){
                    return null;
                }else {
                    quick = quick.next.next;
                    slow = slow.next;
                }
            }
        }
        if(quick == null){
            return null;
        }
        ListNode p = head;
        while(p != slow.next){
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}
