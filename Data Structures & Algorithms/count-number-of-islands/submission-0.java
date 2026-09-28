class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]=='1'){
                    isIsland(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private void isIsland(int i, int j, char[][] grid){
        // if(i<0 || i>=grid.length){
        //     return;
        // }
        // if(j<0 || j>=grid[0].length){
        //     return;
        // }
        grid[i][j] = '0';
        if(j+1<grid[0].length && grid[i][j+1]=='1'){
            isIsland(i, j+1, grid);
        }
        if(i+1<grid.length && grid[i+1][j]=='1'){
            isIsland(i+1, j, grid);
        }
        if(j-1>=0 && grid[i][j-1]=='1'){
            isIsland(i, j-1, grid);
        }
        if(i-1>=0 && grid[i-1][j]=='1'){
            isIsland(i-1, j, grid);
        }
    }
}
