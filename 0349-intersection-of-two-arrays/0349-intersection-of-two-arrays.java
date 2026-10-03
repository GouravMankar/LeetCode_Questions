class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> comman=new HashSet<>();
        for(int item: nums1){
            set.add(item);
        }

        for(int item:nums2){
            if(set.contains(item)){
                comman.add(item);
            }
        }
        int []arr=new int[comman.size()];
        int i=0;
        for(int item:comman){
            arr[i++]=item;
        }
        return arr;
    }
}