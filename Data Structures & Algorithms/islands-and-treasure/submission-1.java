class Solution {
    
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<List<Integer>> q = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==0){
                    q.add(Arrays.asList(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            List<Integer> indices = q.poll();
            int x = indices.get(0);
            int y = indices.get(1);
            int val = indices.get(2);

            if(y+1<c && grid[x][y+1]>val && grid[x][y+1]==2147483647){
                q.add(Arrays.asList(x, y+1, val+1));
                grid[x][y+1] = val+1;
            }
            if(x+1<r && grid[x+1][y]>val && grid[x+1][y]==2147483647){
                q.add(Arrays.asList(x+1, y, val+1));
                grid[x+1][y] = val+1;
            }
            if(y>0 && grid[x][y-1]>val && grid[x][y-1]==2147483647){
                q.add(Arrays.asList(x, y-1, val+1));
                grid[x][y-1] = val+1;
            }
            if(x>0 && grid[x-1][y]>val && grid[x-1][y]==2147483647){
                q.add(Arrays.asList(x-1, y, val+1));
                grid[x-1][y] = val+1;
            }
        }
    }
}
