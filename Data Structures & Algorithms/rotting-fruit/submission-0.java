class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int fresh = 0;
        int minutes = 1;
        int res = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j, minutes});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!q.isEmpty()){
            int[] ind = q.poll();
            int row = ind[0];
            int col = ind[1];
            int min = ind[2];

            for(int[] d : dir){
                int newRow = row + d[0];
                int newCol = col + d[1];

                if(newRow<0 || newRow>=r || newCol<0 || newCol>=c){
                    continue;
                }
                if(grid[newRow][newCol] == 0 || grid[newRow][newCol] == 2){
                    continue;
                }
                res = Math.max(res, min);
                grid[newRow][newCol] = 2;
                fresh--;
                q.add(new int[]{newRow, newCol, min+1});
            }
        }
        if(fresh>0) return -1;
        return res;
    }
}
