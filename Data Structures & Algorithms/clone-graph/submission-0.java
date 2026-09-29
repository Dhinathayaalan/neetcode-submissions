/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)    return null;
        
        Queue<Node> oldQ = new LinkedList<>();
        Map<Integer, Node> visited = new HashMap<>();

        oldQ.add(node);
        Node res = new Node(node.val);
        visited.put(node.val, res);  

        while(!oldQ.isEmpty()){
            Node v = oldQ.poll();
            Node n = visited.get(v.val);

            for(Node i : v.neighbors){
                if(!visited.containsKey(i.val)){
                    oldQ.add(i);
                    Node newNode = new Node(i.val);
                    visited.put(i.val, newNode);
                }
                n.neighbors.add(visited.get(i.val));
            }
        }
        return res;
    }
}