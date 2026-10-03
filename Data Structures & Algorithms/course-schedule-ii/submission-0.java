class Solution {
    public int[] findOrder(int n, int[][] arr) {
        int[] res = new int[n];
        int idx = 0;
        int[] v = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        int nonZero = 0;
        for(int i=0;i<arr.length;i++){
            v[arr[i][0]]++;
        }
        for(int i=0;i<n;i++){
            if(v[i]==0){
                q.add(i);
                res[idx++] = i;
            }
            else{
                nonZero++;
            }
        }
        if(nonZero==0) return res;
        while(!q.isEmpty()){
            int val = q.poll();
            for(int i=0;i<arr.length;i++){
                if(arr[i][1]==val){
                    v[arr[i][0]]--;
                    if(v[arr[i][0]] == 0){
                        q.add(arr[i][0]);
                        res[idx++] = arr[i][0];
                        nonZero--;
                        if(nonZero==0){
                            return res;
                        }
                    }
                }
            }
        }
        return new int[0];
    }
}
