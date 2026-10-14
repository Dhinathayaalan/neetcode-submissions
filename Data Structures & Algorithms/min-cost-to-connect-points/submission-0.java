class Solution {
    int[] parent;
    int[] size;
    int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return false;
        }
        if(size[rootA] < size[rootB]){
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        else{
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        return true;
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int x1 = points[i][0], x2 = points[j][0], y1 = points[i][1], y2 = points[j][1];
                int dis = Math.abs(x1-x2) + Math.abs(y1-y2);
                edges.add(new int[]{i, j, dis});
            }
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        int connection = 0;
        int cost = 0;
        for(int[] arr : edges){
            if(union(arr[0], arr[1])){
                cost += arr[2];
                connection++;
                if(connection == n-1){
                    return cost;
                }
            }
        }
        return cost;
    }
}