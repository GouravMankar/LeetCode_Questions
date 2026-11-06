import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int q = queries.length;
        int[] ans = new int[q];

        // Sort logs by request time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Store original query indices
        int[][] sortedQueries = new int[q][2];

        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Sort queries by query time
        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        // Count requests for each server inside current window
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int i = 0; i < q; i++) {

            int queryTime = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];

            int start = queryTime - x;

            // Add logs whose time <= queryTime
            while (right < logs.length &&
                   logs[right][1] <= queryTime) {

                int server = logs[right][0];

                if (!map.containsKey(server)) {
                    activeServers++;
                }

                map.put(server, map.getOrDefault(server, 0) + 1);

                right++;
            }

            // Remove logs whose time < start
            while (left < right &&
                   logs[left][1] < start) {

                int server = logs[left][0];

                int count = map.get(server);

                if (count == 1) {
                    map.remove(server);
                    activeServers--;
                } else {
                    map.put(server, count - 1);
                }

                left++;
            }

            // Servers with zero requests
            ans[originalIndex] = n - activeServers;
        }

        return ans;
    }
}