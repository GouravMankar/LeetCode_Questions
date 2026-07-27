class Solution {
    public int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).skip(k-1).findFirst().orElse(0);
        
    }
}
// 1 2 2 3 3 4 5 5 6