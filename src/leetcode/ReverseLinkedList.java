package leetcode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return new ListNode();
        }
        if (head.next == null){
            return head;
        }

        ListNode tail = head;
        ListNode cur = head.next;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = head;
            tail.next = tmp;

            head = cur;
            cur = tmp;
        }
        return head;
    }
}
