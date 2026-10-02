class Solution {
    public static int[][] DIR = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0);
            }
            if(board[i][n-1]=='O'){
                dfs(board, i, n-1);
            }
        }
        for(int j=1;j<n-1;j++){
            if(board[0][j]=='O'){
                dfs(board, 0, j);
            }
            if(board[m-1][j]=='O'){
                dfs(board, m-1, j);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='E'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;

        board[i][j] = 'E';
        for(int[] d : DIR){
            int nr = i+d[0], nc = j+d[1];
            if(nr<0 || nr>=m || nc<0 || nc>=n){
                continue;
            }
            if(board[nr][nc]=='X' || board[nr][nc]=='E'){
                continue;
            }
            dfs(board, nr, nc);
        }
    }
}
