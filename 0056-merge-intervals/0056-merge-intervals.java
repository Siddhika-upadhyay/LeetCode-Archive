import java.util.*;
class Solution {
    public int[][] merge(int[][] arr) {
     int n = arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> ans = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{arr[i][0], arr[i][1]});
            }
            
            else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], arr[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}