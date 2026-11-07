class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int current=0;

        for(int item:nums){
            current+=item;
            max=Math.max(current,max);
            if(current<0)current=0;
        }
        return max;
    }
}