class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();

        Arrays.sort(sorted); // temporary

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int sa = digitSum(a);
            int sb = digitSum(b);

            if (sa != sb) {
                return sa - sb;
            }
            return a - b;
        });

        Map<Integer, Integer> targetIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetIndex.put(arr[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i] || targetIndex.get(nums[i]) == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = targetIndex.get(nums[j]);
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}