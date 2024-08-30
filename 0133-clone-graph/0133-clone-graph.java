/*
// Definition for a Node.
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
    
//     private void dfs(Node node, Node cloneNode, Map<Node, Node> map) {
        
//         for (Node n : node.neighbors) {
            
//             if (!map.containsKey(n)) {
//                 Node clone = new Node(n.val);
//                 map.put(n, clone);
//                 cloneNode.neighbors.add(clone);
                
//                 dfs(n, clone, map);
//             }else {
//                    cloneNode.neighbors.add(map.get(n));
//             }
//         }
//     }
    
    private void bfs(Queue<Node> que, Map<Node, Node> map) {
        
        while (!que.isEmpty()) {
            
            Node node = que.poll();
            Node cloneNode = map.get(node);
            
            for (Node n : node.neighbors) {
                
                if (!map.containsKey(n)) {
                    Node clone = new Node(n.val);
                    map.put(n, clone);
                    cloneNode.neighbors.add(clone);

                    que.offer(n);
                }else {
                       cloneNode.neighbors.add(map.get(n));
                }
            }
        }
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        
        Queue<Node> que = new LinkedList<>();
        que.offer(node);
        bfs(que, map);
        
        return cloneNode;
    }
}