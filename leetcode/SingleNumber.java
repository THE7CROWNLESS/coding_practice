package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber{

    //将数值和出现次数作为键值对存进hash，再遍历hash得到答案（没法通过值直接得到键）
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<Integer,Integer>();
        int len = nums.length;

        for(int i=0;i<len;i++){
            if(hash.containsKey(nums[i])){
                hash.put(nums[i],2);
            }else {
                hash.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer, Integer> entries:hash.entrySet()){
            if(entries.getValue() == 1){
                return entries.getKey();
            }

        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<Integer,Integer>();
        int len = nums.length;

        //第一次出现：结果或者第一次非结果值，将其存进hash中
        //第二次出现，改变nums[i]，和hash中存的第一次的num[hash.get(nums[i])]
        //再遍历修改后的nums数组得到答案
        for(int i=0;i<len;i++){
            if(hash.containsKey(nums[i])){
                nums[i] = 3001; //3001为边界值
                nums[hash.get(nums[i])] = 3001;
            }else {
                hash.put(nums[i],i);
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i] == 3001){
                continue;
            }else {
                return nums[i];
            }

        }
        return 0;
    }

    //位运算
    /*
    运算规则：相同为0，不同为1，
    由运算规则可知，任何二进制数与零异或，都会等于其本身，即 A ^ 0 = A。
    自反性： A ^ B ^ B = A （由结合律可推： A ^ B ^ B = A ^ ( B ^ B ) = A ^ 0 = A）
    -->变量交换、排除偶次重复
    */
    public int singleNumber3(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
