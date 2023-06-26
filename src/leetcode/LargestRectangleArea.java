package leetcode;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int res = heights[0];

        for (int i = 0; i < len; i++) {
            if (heights[i] * len <= res) {
                continue;
            } else {
                int left = i;
                int right = i;
                while (left >= 0) {
                    if (heights[left] >= heights[i]) {
                        left--;
                    } else {
                        break;
                    }
                }
                while (right <= len - 1) {
                    if (heights[right] >= heights[i]) {
                        right++;
                    } else {
                        break;
                    }
                }
                int tmp = (right - left - 1) * heights[i];
                if (res<tmp){
                    res = tmp;
                }
            }
        }
        return res;
    }
}
