package leetcode;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        //Map<int[], int[]> hash = new HashMap<>();
        //int[][] res = new  int[intervals.length][2];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if(intervals[i][0] == -1 ||  intervals[j][0] == -1|| intervals[i][0] > intervals[j][1] || intervals[i][1] < intervals[j][0]){
                    continue;
                }else {
                    intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[j][0] = -1;
                }
            }
        }

=======
//两次循环
//哈希按归类处理时，归类的键无法统一
//双指针，可以先按start排序，这样指针的移动可以说明该处的结果已经找全。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int left = 0;
        int right = left + 1;

        while (right < intervals.length){
            if(intervals[left][1] < intervals[right][0]){
                left = right;
                right = left + 1;
            }else {
                intervals[left][1] = Math.max(intervals[right][1],intervals[left][1]); //按start排序，可能前面的完全覆盖end，所以要取max
                intervals[right][0] = -1;
                right++;
            }
        }
        List<int[]> res = new ArrayList<>();
>>>>>>> origin/java
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] != -1){
                res.add(intervals[i]);
            }
        }
<<<<<<< HEAD
        return  res.toArray(new int[res.size()][2]);
=======

        return res.toArray(new int[0][]);
>>>>>>> origin/java
    }
}
