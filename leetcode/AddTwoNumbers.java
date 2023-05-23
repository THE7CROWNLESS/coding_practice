package leetcode;

//链表操作：
//        1、返回类型
//        2、用tmp指针暂时操作链表，保证头节点的存在
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode tmp = res;
        int flag = 0;
        while (l1 != null && l2 != null){
            tmp.next = new ListNode();
            tmp = tmp.next;
            tmp.val = (l1.val + l2.val + flag) % 10;
            flag = (l1.val + l2.val + flag) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            tmp.next = new ListNode();
            tmp = tmp.next;
            tmp.val = (l1.val + flag) % 10;
            flag = (l1.val + flag) / 10;
            l1 =l1.next;
        }
        while (l2 != null){
            tmp.next = new ListNode();
            tmp = tmp.next;
            tmp.val = (l2.val + flag) % 10;
            flag = (l2.val + flag) / 10;
            l2 = l2.next;
        }
        if(flag == 1){
            tmp.next = new ListNode(1);
        }
        return  res.next;
    }
}
