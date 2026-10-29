class Solution {

    private int[][] up;
    private int[] depth, tin, tout, parent;
    private int timer, LOG;
    private int[] bit;

    // Fenwick Tree: XOR update
    private void add(int index, int value) {
        while (index < bit.length) {
            bit[index] ^= value;
            index += index & -index;
        }
    }

    // Prefix XOR query
    private int prefixQuery(int index) {
        int result = 0;

        while (index > 0) {
            result ^= bit[index];
            index -= index & -index;
        }

        return result;
    }

    // Range XOR update [left, right]
    private void rangeUpdate(int left, int right, int value) {
        add(left, value);
        add(right + 1, value);
    }

    private int charBit(char c) {
        return 1 << (c - 'a');
    }

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        LOG = 32 - Integer.numberOfLeadingZeros(n);

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];

        int[] order = new int[n];
        int[] subtreeSize = new int[n];
        int[] stack = new int[n];

        Arrays.fill(parent, -1);

        // Iterative DFS to avoid stack overflow
        int top = 0;
        int count = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = ++timer;
            order[count++] = u;
            subtreeSize[u] = 1;

            up[0][u] = parent[u];

            for (int k = 1; k < LOG; k++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }

            for (int v : graph[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        // Calculate subtree sizes and Euler tour exit times
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];

            if (u != 0) {
                subtreeSize[parent[u]] += subtreeSize[u];
            }

            tout[u] = tin[u] + subtreeSize[u] - 1;
        }

        // Initial root-to-node XOR masks
        int[] basePrefix = new int[n];

        for (int u : order) {
            basePrefix[u] = charBit(s.charAt(u));

            if (u != 0) {
                basePrefix[u] ^= basePrefix[parent[u]];
            }
        }

        // Fenwick tree stores changes to prefix masks
        bit = new int[n + 2];

        char[] chars = s.toCharArray();
        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);

                int oldMask = charBit(chars[u]);
                int newMask = charBit(newChar);
                int delta = oldMask ^ newMask;

                if (delta != 0) {
                    rangeUpdate(tin[u], tout[u], delta);
                    chars[u] = newChar;
                }

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v);

                int prefixU =
                    basePrefix[u] ^ prefixQuery(tin[u]);

                int prefixV =
                    basePrefix[v] ^ prefixQuery(tin[v]);

                int pathMask =
                    prefixU ^ prefixV ^ charBit(chars[ancestor]);

                // At most one character may have odd frequency
                answer.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return answer;
    }

    private int lca(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int difference = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((difference & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return parent[u];
    }
}
