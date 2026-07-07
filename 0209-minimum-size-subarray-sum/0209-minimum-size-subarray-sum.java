class Solution {
    public static int min(int result,int len){
        if(result>len)
           return len;
        else
           return result;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int high=0,low=0,result=Integer.MAX_VALUE;
        boolean flag=false;
        int sum=0;
        while(high<nums.length){
            sum=sum+nums[high];
        
        while(sum>=target){
            int len=high-low+1;
            result=Solution.min(result,len);
            sum=sum-nums[low];
            low++;
            flag=true;
        }
        high++;
    }
    if(flag==false){
        return 0;
    }
    return result;
    }
}