class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        n++;
        this.parent = new int[n];
        this.size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
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
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int i=0;i<n;i++){
            if(!dsu.union(edges[i][0], edges[i][1])){
                return new int[]{edges[i][0], edges[i][1]};
            }
        }
        return new int[]{-1, -1};
    }
}
