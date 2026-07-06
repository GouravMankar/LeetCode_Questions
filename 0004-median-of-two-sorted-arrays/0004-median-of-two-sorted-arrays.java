class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {



        int[] merged = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                        .sorted().toArray();
        if((nums1.length+nums2.length)%2==0){
            return (merged[merged.length/2]+merged[(merged.length/2)-1])/2.0;
        }
        return merged[merged.length/2];


  
    }
}