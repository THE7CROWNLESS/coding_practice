package leetcode;

public class FindMidOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pre = 0;
        int post = 0;
        int k = 0;
        int i = 0;
        int j = 0;
        int index_i = (nums1.length + nums2.length + 1)/ 2;
        int index_j = (nums1.length + nums2.length + 2)/ 2;
        while (i < nums1.length || j < nums2.length){
            //每次只进入一个条件进行，防止边界处多个进入
            if(i == nums1.length){
                pre = nums2[j];
                j++;
            }else if (j == nums2.length){
                pre = nums1[i];
                i++;
            }else if (j < nums2.length && i < nums1.length && nums1[i] < nums2[j]){
                pre = nums1[i];
                i++;
            }else if (j < nums2.length && i < nums1.length) {
                pre = nums2[j];
                j++;
            }
            k++;

            if(k == index_i){
                if((nums1.length + nums2.length) % 2 == 0){
                    post = pre;
                }else {
                    return (double) pre;
                }
            }
            if (k == index_j){
                return (double) (pre + post) / 2;
            }
        }
        return -1.0;
    }
}
