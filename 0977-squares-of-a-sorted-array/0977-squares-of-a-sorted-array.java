class Solution {
    public int[] sortedSquares(int[] nums) {
        int neg=-1;
        for(int i=0;i<nums.length&&nums[i]<0;i++){
            neg=i;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        int i=neg+1;
        int []arr=new int[nums.length];
        int j=0;
        while(neg>=0 && i<nums.length){
            if(nums[neg]<nums[i]){
               arr[j]=nums[neg];
               neg--;
               j++;
            }else{
                arr[j]=nums[i];
                i++;
                j++;
            }
        }
        while(neg>=0){
            arr[j]=nums[neg];
            neg--;
            j++;
        }
        while(i<nums.length){
            arr[j]=nums[i];
            i++;
            j++;
        }
        return arr;
    }
}