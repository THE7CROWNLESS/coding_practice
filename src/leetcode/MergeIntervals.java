package leetcode;

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

        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] != -1){
                res.add(intervals[i]);
            }
        }
        return  res.toArray(new int[res.size()][2]);
    }
}
