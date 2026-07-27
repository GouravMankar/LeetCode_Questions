class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicate=new HashSet<>();
        boolean result=false;
        for(int i=0;i<nums.length;i++){
            if(duplicate.add(nums[i])){
            }else{
                result=true;
                break;
            }
        }
        return result;
    }
}