package leetcode;

//双指针
//
public class IntersectionOfTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a.next != null && b.next != null){
            a = a.next;
            b = b.next;
        }

        //计算多出的长度
        int a_more = 0;
        int b_more = 0;
        while (a.next != null || b.next != null){
            if (a.next != null){
                a = a.next;
                a_more++;
            }else {
                b = b.next;
                b_more++;
            }
        }

        //移动到相同起始的地方
        a = headA;
        b = headB;
        for (int i = 0; i < a_more; i++) {
            a = a.next;
        }
        for (int i = 0; i < b_more; i++) {
            b = b.next;
        }

        //判断是否相遇
        while (a != null && b != null){
            if (a == b){
                return a;
            }else {
                a = a.next;
                b = b.next;
            }
        }

        return null;
    }
}
