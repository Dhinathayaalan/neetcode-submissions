class Solution {
    public boolean canFinish(int n, int[][] arr) {
        int[] v = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        int nonZero = 0;
        for(int i=0;i<arr.length;i++){
            v[arr[i][0]]++;
        }
        for(int i=0;i<n;i++){
            if(v[i]==0){
                q.add(i);
            }
            else{
                nonZero++;
            }
        }
        if(nonZero==0) return true;
        while(!q.isEmpty()){
            int val = q.poll();
            for(int i=0;i<arr.length;i++){
                if(arr[i][1]==val){
                    v[arr[i][0]]--;
                    if(v[arr[i][0]] == 0){
                        q.add(arr[i][0]);
                        nonZero--;
                        if(nonZero==0){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
