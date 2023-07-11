package leetcode;

import java.util.*;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode p = head;

        //计算长度和mid
        while (p != null) {
            p = p.next;
            len++;
        }

        //归并段的长度
        for (int subLen = 0; subLen < len / 2; subLen++) {
             for (int i = 0; i + 2 * subLen + 1 < len; i = i + 2 * subLen + 1){

             }
        }

        return head;

    }
}
