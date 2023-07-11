package leetcode;


//头插法反转链表，找中点时可以用快慢指针
//递归法，递归到末尾时，与全局变量比较，成功则改变全局变量并回退，再次比较
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        ListNode q = p;
        int len = 0;

        while (p != null) {
            p = p.next;
            len++;
        }
        p = q;
        int count = len/2;
        while(count > 0){
            q = q.next;
            count--;
        }
        if (len% 2 !=0){
            q = q.next;
        }

        p =  headInsert(head, len / 2);

        while (q != null){
            if (p.val != q.val){
                return false;
            }else {
                p = p.next;
                q = q.next;
            }
        }
        return true;
    }


    public ListNode headInsert(ListNode node, int len) {
        ListNode head = new ListNode();
        ListNode cur = node;
        ListNode next = cur;
        while (len>0){
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
            len--;
        }

        return head;
    }
}
