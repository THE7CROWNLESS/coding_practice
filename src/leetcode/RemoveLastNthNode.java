package leetcode;

public class RemoveLastNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode lastNode = head;
        ListNode tmp = newHead;
        for (int i = 0; i < n; i++) {
            lastNode = lastNode.next;
        }
        while (lastNode != null){
            tmp= head;
            head = head.next;
            lastNode = lastNode.next;
        }
        tmp.next = head.next;
        return newHead.next;
    }
}
