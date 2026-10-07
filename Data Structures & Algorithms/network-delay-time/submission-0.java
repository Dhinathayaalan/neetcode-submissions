class Edge{
    int to;
    int time;
    Edge(int to, int time){
        this.to = to;
        this.time = time;
    }
}
class Node{
    int name;
    int dist;
    Node(int name, int dist){
        this.name = name;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int sentCount = 0;
        int minTime = 0;

        Map<Integer, List<Edge>> adj = new HashMap();
        Map<Integer, Integer> d = new HashMap<>();
        for(int i=1;i<=n;i++){
            adj.put(i, new ArrayList());
            d.put(i, Integer.MAX_VALUE);
        }
        for(int[] i : times){
            adj.get(i[0]).add(new Edge(i[1], i[2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.dist-b.dist);
        
        pq.add(new Node(k, 0));
        d.put(k, 0);

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            if(currNode.dist < d.get(currNode.name)){
                continue;
            }
            for(Edge e : adj.get(currNode.name)){
                int newDist = currNode.dist + e.time;
                if(newDist < d.get(e.to)){
                    d.put(e.to, newDist);
                    pq.add(new Node(e.to, newDist));
                }
            }
        }
        int distance;
        for(int i=1;i<=n;i++){
            distance = d.get(i);
            if(distance != Integer.MAX_VALUE){
                sentCount++;
                minTime = Math.max(minTime, distance);
            }  
        }
        return sentCount==n ? minTime : -1;
    }
}
