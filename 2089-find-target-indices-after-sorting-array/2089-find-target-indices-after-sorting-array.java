class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums);
        int mid,right=nums.length-1,left=0;
        mid=Arrays.binarySearch(nums,target);
        if(mid>=0){
            result.add(mid);
        }else{
            return result;
        }
        for(int i=mid-1;i>=0;i--){
            if(nums[i]==target){
                result.add(i);
            }else{
                break;
            }
        }
        for(int i=mid+1;i<nums.length;i++){
            if(nums[i]==target){
                result.add(i);
            }else{
                break;
            }
        }
        Collections.sort(result);
        return result;
    }
}