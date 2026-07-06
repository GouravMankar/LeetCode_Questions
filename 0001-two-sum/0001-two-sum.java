class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> result=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int req=target-nums[i];
            if(result.containsKey(req)){
                return new int[]{result.get(req),i};
            }
            result.put(nums[i],i);
        }
        return new int[]{};
    }
}