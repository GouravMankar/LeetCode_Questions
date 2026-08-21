class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {



        // int[] merged = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
        //                 .sorted().toArray();
        // if((nums1.length+nums2.length)%2==0){
        //     return (merged[merged.length/2]+merged[(merged.length/2)-1])/2.0;
        // }
        // return merged[merged.length/2];

        int[] arr=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                i++;
            }else{
                arr[k]=nums2[j];
                j++;
            }
            k++;
            
        }
        while(i<nums1.length){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        if(arr.length%2==0){
            return (arr[arr.length/2]+arr[arr.length/2-1])/(double)2;
        }else{
            return arr[arr.length/2];
        }



  
    }
}