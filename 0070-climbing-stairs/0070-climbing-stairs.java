class Solution {
    private static int counting(int n,int i,int []dp){
        if(i==n){
            return 1;
        }
        if(i>n)return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int a=counting(n,i+1,dp);
        int b=counting(n,i+2,dp);
        dp[i]=a+b;
        return dp[i];
    }
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        return counting(n,0,dp);
    }
}