class Solution {
    public int diffChar(String a, String b){
        int diffCount = 0;
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        for(int i=0;i<x.length;i++){
            if(x[i]!=y[i]){
                diffCount++;
            }
        }
        return diffCount;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //if(diffChar(beginWord, endWord)<=1) return 0;
        Map<String, Integer> vis = new HashMap<>();

        wordList.add(beginWord);
        Map<String, List<String>> adj = new HashMap<>();
        for(String i : wordList){
            adj.put(i, new ArrayList<>());
        } 

        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                if(diffChar(wordList.get(i), wordList.get(j))<=1){
                    adj.get(wordList.get(i)).add(wordList.get(j));
                    adj.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        //System.out.println(adj);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vis.put(beginWord, 1);
        while(!q.isEmpty()){
            String word = q.poll();
            for(String i : adj.get(word)){
                if(vis.get(i)==null){
                    q.offer(i);
                    vis.put(i, vis.get(word)+1);
                }
            }
        }

        return vis.get(endWord)!=null ? vis.get(endWord) : 0;
    }
}
