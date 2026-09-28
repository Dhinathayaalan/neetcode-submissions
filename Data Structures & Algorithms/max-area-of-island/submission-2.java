class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    res = Math.max(islandArea(i, j, grid, visited), res);
                }
            }
        }
        return res;
    }

    private int islandArea(int i, int j, int[][] grid, boolean[][] visited){
        int r = grid.length;
        int c = grid[0].length;
        if(i<0 || i>=r || j<0 || j>=c || grid[i][j]==0 || visited[i][j]){
            return 0;
        }
        visited[i][j]=true;
        return 1 + islandArea(i, j+1, grid, visited) + islandArea(i+1, j, grid, visited) + islandArea(i, j-1, grid, visited) + islandArea(i-1, j, grid, visited);
    }
}
