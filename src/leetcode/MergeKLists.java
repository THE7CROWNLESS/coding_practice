package leetcode;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(lists.length == 0){
            return null;
        }else {
            return mergeTwo(lists, 0, lists.length-1);
        }

    }


    public ListNode mergeTwo(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }

        int mid = (right + left) / 2;
        ListNode l1 = mergeTwo(lists, left, mid);
        ListNode l2 = mergeTwo(lists, mid+1, right);
        return merge(l1, l2);
    }

    public ListNode  merge(ListNode l1, ListNode l2){
        ListNode l12 = new ListNode();
        ListNode tmp = l12;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else {
                tmp.next =l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        if(l1 == null){
            tmp.next = l2;
        }else{
            tmp.next =l1;
        }
        //l1 = l12; 变量l1只是存了实际参数的地址值，修改l1的存的地址值改变并不影响实际参数，但是用地址值去修改该处对象中的内容时，会有影响。
        return l12;
    }
}
