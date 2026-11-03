class Solution {
    public int singleNumber(int[] nums) {
    int val=0;
    for(int item:nums){
        val=val^item;
    }
    return val;
    }
}