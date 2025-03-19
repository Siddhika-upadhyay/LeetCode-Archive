import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
          int[] result = new int[2];
        result[0] = result[1] = -1;
 HashMap<Integer,Integer> mpp= new HashMap<>();
 for(int i=0;i<nums.length;i++){
    int num=nums[i];
    int more=target-num;
    if(mpp.containsKey(target-nums[i])){
        result[0]=mpp.get(more);;
        result[1]=i;
        return result;
    }
    mpp.put(nums[i],i);
 }
 return result;
}
}