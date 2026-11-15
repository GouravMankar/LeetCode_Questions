class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;

        long even = 1;
        long odd = 0;
        long sum = 0;
        long count = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 != 0) {
                count += even;
                odd++;
            } else {
                count += odd;
                even++;
            }

            count %= mod;
        }

        return (int) count;
    }
}