class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // [finishTime, serverIndex]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        int[] count = new int[k];

        // Initially all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            int time = arrival[i];

            // Release servers whose requests are completed
            while (!busy.isEmpty() && busy.peek()[0] <= time) {

                long[] curr = busy.poll();

                available.add((int) curr[1]);
            }

            // If no server is available, drop the request
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server
            int preferred = i % k;

            // Find smallest available server >= preferred
            Integer server = available.ceiling(preferred);

            // Circular wraparound
            if (server == null) {
                server = available.first();
            }

            // Assign request
            available.remove(server);

            count[server]++;

            // Store finishing time and server index
            busy.offer(new long[]{
                (long) arrival[i] + load[i],
                server
            });
        }

        // Find maximum requests handled
        int maxCount = 0;

        for (int c : count) {
            maxCount = Math.max(maxCount, c);
        }

        // Return all servers having maximum requests
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == maxCount) {
                result.add(i);
            }
        }

        return result;
    }
}
