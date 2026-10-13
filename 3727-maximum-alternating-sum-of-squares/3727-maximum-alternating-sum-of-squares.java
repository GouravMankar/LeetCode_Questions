class Solution {
    public long maxAlternatingSum(int[] nums) {
        long sum=0;
        long []arr=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=(long)(nums[i]*nums[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<nums.length;i++){
            if(i<(nums.length/2)){
                sum=sum-arr[i];
            }else{
                sum=sum+arr[i];
            }
        }
        return sum;
    }
}