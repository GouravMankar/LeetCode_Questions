class Solution {

    int[] ans;
    int[] last;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }

        ans = new int[n];
        last = new int[26];

        Arrays.fill(last, -1);

        dfs(0, tree, parent, s);

        return ans;
    }

    void dfs(int node, List<List<Integer>> tree,
             int[] parent, String s) {

        int ch = s.charAt(node) - 'a';

        int previous = last[ch];

        // Current node becomes nearest ancestor
        last[ch] = node;

        ans[node] = 1;

        // Visit children
        for (int child : tree.get(node)) {
            dfs(child, tree, parent, s);
        }

        // Find new parent
        int newParent = previous;

        if (newParent == -1) {
            newParent = parent[node];
        }

        // Add subtree size to new parent
        if (newParent != -1) {
            ans[newParent] += ans[node];
        }

        // Restore previous ancestor
        last[ch] = previous;
    }
}
