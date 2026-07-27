class Solution {
    public int removeDuplicates(int[] nums) {
    // Using Extra Space 
    //     Set<Integer> set=new LinkedHashSet<>();
    //     for(int i=0;i<nums.length;i++){
    //         set.add(nums[i]);
    //     }
    //     int index=0;
    //     for(Integer i:set){
    //         nums[index++]=i;
    //     }
    //   return set.size();


    int count=1;
    int prev=nums[0];
    for(int i=1;i<nums.length;i++){
         if(prev!=nums[i]){
            nums[count]=nums[i];
            prev=nums[i];
            count++;
         }
        

    }
    System.out.println(count);
    return count;
    }
}