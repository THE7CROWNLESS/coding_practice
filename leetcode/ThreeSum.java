package leetcode;

import java.time.chrono.MinguoDate;
import java.util.*;

//双指针：减少遍历次数。
// 在两次遍历是数字需要满足一定的关系时，可以用双指针将两次for循环转化为一次遍历，指针的双向移动。
//要求：有序；遍历的两数满足一定数量关系，如=target。
//注意：遍历边界处下标越界，每次要移动指针，防止死循环。

//当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法
//本题：三重循环，在进入循化前去重-->用双指针优化一层循环
public class ThreeSum {

    public List<List<Integer>> threeSum_2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length-1;
            if(i >=1 && nums[i] == nums[i-1]){
                continue; //直接舍弃外层循环的重复
            }
            while (left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    --right;           //大于0说明加上最小的left，依然无法满足，即该right不会与之后的满足条件，直接移动指针即可。
                } else if (sum < 0) {
                    ++left;
                }else {
                    if(left >= 1 && right < nums.length-1 && nums[right] == nums[right+1] && nums[left] == nums[left-1]){
                        ++left;                                                                 //边界处越界问题
                        ++right;       //如果都相等，则舍弃重复；一个相等，之后会在前面代码情况中移动。
                        continue;
                    }
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    --right;
                    ++left;
                }
            }
        }
        return res;
    }

    //三重循环写法（补充，主要为了逐步推导出双指针、排出重复的思路）
    public List<List<Integer>> threeSum_3(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if(i >= 1 && nums[i] == nums[i-1]){
                continue;
            }else {
                for (int j = i+1; j < len; j++) {
                    if(nums[j] != nums[i] && nums[j] == nums[j-1]){
                        continue;
                    }else {
                        for (int k = j+1; k < len; k++) {
                            if(k > j + 1 && nums[k] == nums[k-1]){  //k > j + 1,保证去除的重复是k已经取过的值，而不是j后一个（虽然相等，但k还未取过）
                                continue;
                            }else {
                                if(nums[i] + nums[j] +nums[k] == 0){
                                    List<Integer>  tmp = new ArrayList<>();
                                    tmp.add(nums[i]);
                                    tmp.add(nums[j]);
                                    tmp.add(nums[k]);
                                    res.add(tmp);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;

    }



//hash方法，去重困难，且key，value的重复会使得很难得到应有的hash表，而且存在一对多的对应关系
    public List<List<Integer>> threeSum_1(int[] nums) {

        //获取hash映射key=下标数组，value为两数和
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Map<int[], Integer> hash = new HashMap<>();

        //Map<Integer,Integer> index = new HashMap<>();

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {

                int[] index = new int[2];
                index[0] = i;
                index[1] = j;
                //Character character = (char) (nums[i] + nums[j]);
                hash.put(index, nums[i]+nums[j]);
            }
        }

        //判断hash是否存在和为0的value，取其key，得到ij下标，存下和为0的三数。
        for (int i = 0; i < len; i++) {
           // Character tmp = (char) (-nums[i]);
            if (hash.containsValue(-nums[i])) {
                int[][] key = getKey(hash,-nums[i]);
                for (int i1 = 0; i1 < key.length; i1++) {
                    int j = key[i1][0];
                    int k = key[i1][1];

                    if(i != k && j != k && i != j ){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }

        removeSame(res);

        return res;
    }

    //hash由value得到key
    public int[][] getKey(Map<int[],Integer> hash,int value){
        int[][] key = new int[][]{};
        for (Map.Entry<int[],Integer> entry:hash.entrySet()) {
            int i = 0;
            if(entry.getValue() == value){
                key[i] = entry.getKey();
                i++;
            }
        }
//        if(key.length>1){
//            for (int i = 0; i < key.length; i++) {
//                for (int j = i+1; j < key.length; j++) {
//                    if (key[i].equals())
//                }
//            }
//        }
        return key;
    }

    //去除重复
    public void removeSame(List<List<Integer>> res){
        for (int i = 0; i < res.size(); i++) {
            for(int j = i+1; j<res.size(); j++){

                boolean same = Arrays.equals(res.get(i).toArray(),res.get(j).toArray());

                if(same){
                    res.remove(res.get(i));
                }
            }
        }
    }


}