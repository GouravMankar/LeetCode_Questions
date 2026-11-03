class Solution {
    private int maxVal(int []arr){
        int val=Integer.MIN_VALUE;
        for(int item:arr){
            if(item>val){
                val=item;
            }
        }
        return val;
    }
    public int minMoves(int[] nums) {
        int max=maxVal(nums);
        int count=0;
        for(int item:nums){
            count=count+(max-item);
        }
        return count;
    }
}