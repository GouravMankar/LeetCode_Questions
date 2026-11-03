class Solution {
    // private int maxVal(int []arr){
    //     int val=Integer.MIN_VALUE;
    //     for(int item:arr){
    //         if(item>val){
    //             val=item;
    //         }
    //     }
    //     return val;
    // }
    public int minMoves(int[] nums) {
        int val=Integer.MIN_VALUE;
        for(int item:nums){
            if(item>val){
                val=item;
            }
        }
        int count=0;
        for(int item:nums){
            count=count+(val-item);
        }
        return count;
    }
}