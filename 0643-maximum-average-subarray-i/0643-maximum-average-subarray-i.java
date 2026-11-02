class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        int low=0;
        double avg=0;
        for(int i=0; i<k;i++){
            sum+=nums[i];
        }
        avg=(double)sum/k;
        for(int i=k;i<nums.length;i++){
            sum=sum-nums[low]+nums[i];
            avg=Math.max(avg,(double)(sum/k));
            low++;
        }
        return avg;
    }
}