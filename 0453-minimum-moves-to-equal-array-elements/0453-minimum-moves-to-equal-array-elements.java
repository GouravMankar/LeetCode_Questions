class Solution {
    // private boolean allEqual(int []nums){
    //     int val=nums[0];
    //     for(int i=1;i<nums.length;i++){
    //         if(val!=nums[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // private int maximum(int []nums){
    //     int val=nums[0];
    //     int idx=0;
    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i]>val){
    //             val=nums[i];
    //             idx=i;
    //         }
    //     }
    //     return idx;
    // }
    public int minMoves(int[] nums) {
    //     int count=0;
    //    while(!allEqual(nums)){
    //         int val=maximum(nums);
    //         for(int i=0;i<nums.length;i++){
    //             if(i==val){
    //                 continue;
    //             }
    //             nums[i]++;
    //         }
    //         count++;
    //    } 
    //    return count;

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        int moves = sum - nums.length * min;

        return moves;
    
    }
}