class Solution {
    public static int[][] DIR = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]])
        );
        int res = grid[0][0];
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] ind = pq.poll();
            int x = ind[0];
            int y = ind[1];
            if(vis[x][y]) continue;
            vis[x][y] = true;
            System.out.println(grid[x][y]);
            res = Math.max(res, grid[x][y]);
            if(x==m-1 && y==n-1){
                return res;
            }
            for(int[] d : DIR){
                int nr = d[0] + x;
                int nc = d[1] + y;

                if(nr<0 || nr>=m || nc<0 || nc>=n) continue;
                if(vis[nr][nc]) continue;
                pq.offer(new int[]{nr, nc});
            }
        }

        return res;
    }
}
