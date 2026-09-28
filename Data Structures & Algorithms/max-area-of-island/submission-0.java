class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==1){
                    res = Math.max(islandArea(i, j, grid, 0), res);
                }
            }
        }
        return res;
    }

    private int islandArea(int i, int j, int[][] grid, int currArea){
        int r = grid.length;
        int c = grid[0].length;
        if(i<0 || i>=r || j<0 || j>=c || grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
        return 1 + islandArea(i, j+1, grid, currArea) + islandArea(i+1, j, grid, currArea) + islandArea(i, j-1, grid, currArea) + islandArea(i-1, j, grid, currArea);
    }
}
