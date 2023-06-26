package leetcode;
//HashMap的归类作用，一键对多值。

//对于题目，键的方式：1、排序，2、次数
import java.util.*;
import java.util.function.Consumer;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> hash = new HashMap<>();    //值设置成列表，可以往同一类添加。

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            //数组类型没有重写 hashcode() 和 equals() 方法，因此不能直接作为 HashMap 的 Key 进行聚合
            if (hash.containsKey(Arrays.toString(charArray))) {
                hash.get(Arrays.toString(charArray)).add(str);
            } else {
                List<String> path = new ArrayList<>();
                path.add(str);
                hash.put(Arrays.toString(charArray), path);
            }
        }
//        hash.values().forEach(new Consumer<List<String>>() {
//            @Override
//            public void accept(List<String> strings) {
//                res.add(strings);
//            }
//        });

        return  new ArrayList<List<String>>(hash.values());
    }
}
