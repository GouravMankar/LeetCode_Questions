class Solution {
    private static int maxValue(int i,int []nums,int []dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int robbed=nums[i]+maxValue(i+2,nums,dp);
        int skipped=maxValue(i+1,nums,dp);
        dp[i]=Math.max(robbed,skipped);
        return dp[i];
    }
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return maxValue(0,nums,dp);
    }
}