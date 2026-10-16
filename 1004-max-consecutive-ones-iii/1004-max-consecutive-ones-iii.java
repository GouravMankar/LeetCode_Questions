class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0,low=0,zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
            while(zero>k){
                if(nums[low]==0){
                    zero--;
                }
                low++;
            }
            max=Math.max(max,i-low+1);
        }
        return max;
    }
}