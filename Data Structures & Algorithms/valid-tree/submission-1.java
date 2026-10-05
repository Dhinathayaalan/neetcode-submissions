class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> node = new ArrayList<>();
        for(int i=0;i<n;i++) node.add(new ArrayList());
        //System.out.println(node);
        for(int i=0;i<edges.length;i++){
            node.get(edges[i][0]).add(edges[i][1]);
            node.get(edges[i][1]).add(edges[i][0]);
        } 
        int[] visited = new int[n];
        System.out.print(node);
        int prev = -1;
        for(int i=0;i<n;i++){
            if(visited[i]!=1 && !dfs(0, node, visited, prev)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int v, List<List<Integer>> node, int[] visited, int prev){
        if(visited[v]==1){
            return false;
        }
        visited[v] = 1;
        boolean result = true;
        for(Integer i : node.get(v)){
            if(i!=prev) result = result && dfs(i, node, visited, v);
        }
        return result;
    }
}
