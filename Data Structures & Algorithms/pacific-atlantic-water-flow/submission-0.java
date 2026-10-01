class Solution {
    public static int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}}; 

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        for(int j=0;j<heights[0].length;j++){
            dfs(heights, 0, j, pacific);
        }
        for(int i=0;i<heights.length;i++){
            dfs(heights, i, 0, pacific);
        }

        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for(int j=0;j<heights[0].length;j++){
            dfs(heights, heights.length-1, j, atlantic);
        }
        for(int i=0;i<heights.length;i++){
            dfs(heights, i, heights[0].length-1, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] reachable) {
        reachable[r][c] = true;
        for (int[] d : DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length){
                continue;
            }
            if (reachable[nr][nc] || heights[nr][nc] < heights[r][c]) continue;
            dfs(heights, nr, nc, reachable);
        }
    }
}
