package leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int [] {1,3,4,7,11,14,16,22,25,30,33,41,67,77,89,99,190,666,900};
        int mid,high,low = 0;
        high = arr.length-1;
        low = 0;
        mid = (low+high) / 2;
        int target = 901;
        while (low <= high){
            if(arr[mid] > target){
                high = mid-1;
                mid = (high+low) / 2;
            }else if(arr[mid] < target){
                low = mid+1;
                mid = (high+low) / 2;
            }else {
                break;
            }
        }
        if(low > high && arr[mid] != target){
            System.out.println("不存在");
        }else {
            System.out.println(arr[mid] + "  at  " + mid);
        }

    }
}
