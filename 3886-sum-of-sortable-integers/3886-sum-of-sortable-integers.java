
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        int[] prefDrops = new int[n];

        prefMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], nums[i]);
        }

        suffMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }

        for (int i = 1; i < n; i++) {
            prefDrops[i] = prefDrops[i - 1];

            if (nums[i - 1] > nums[i]) {
                prefDrops[i]++;
            }
        }

        int answer = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            // Check whether neighboring groups can join in order
            for (int i = k; i < n; i += k) {
                if (prefMax[i - 1] > suffMin[i]) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                continue;
            }

            // Check each group's circular order
            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;

                int drops = prefDrops[end] - prefDrops[start];

                if (nums[end] > nums[start]) {
                    drops++;
                }

                if (drops > 1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answer += k;
            }
        }

        return answer;
    }
}
