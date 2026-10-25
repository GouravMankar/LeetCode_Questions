
class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    if (dfs(grid, r, c, rows, cols)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int r, int c,
                        int rows, int cols) {

        // Out of bounds: this island is not closed
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }

        // Water or an already visited cell
        if (grid[r][c] == 1) {
            return true;
        }

        // Mark this land cell as visited
        grid[r][c] = 1;

        // Explore all four directions
        boolean up = dfs(grid, r - 1, c, rows, cols);
        boolean down = dfs(grid, r + 1, c, rows, cols);
        boolean left = dfs(grid, r, c - 1, rows, cols);
        boolean right = dfs(grid, r, c + 1, rows, cols);

        return up && down && left && right;
    }
}
