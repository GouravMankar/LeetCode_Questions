class Solution {
    private int maxSum(int []nums){
        int current=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            current+=nums[i];
            max=Math.max(current,max);
            if(current<0)current=0;
        }
        return max;
    }
    private int minSum(int []nums){
        int current=0;
        int min=0;
        for(int i=0;i<nums.length;i++){
            current+=nums[i];
            min=Math.min(current,min);
            if(current>0)current=0;
        }
        return Math.abs(min);
    }
    public int maxAbsoluteSum(int[] nums) {
        return Math.max(minSum(nums),maxSum(nums));
    }
}