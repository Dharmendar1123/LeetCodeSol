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
    
    private void dfs(Node node, Node cloneNode, Node[] created) {
        
        created[node.val] = cloneNode;
        for (Node n : node.neighbors) {
            
            if (created[n.val] == null) {
                Node clone = new Node(n.val);
                cloneNode.neighbors.add(clone);
                
                dfs(n, clone, created);
            }else {
                   cloneNode.neighbors.add(created[n.val]);
            }
        }
    }
    
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Node cloneNode = new Node(node.val);
        
        Node[] created = new Node[101];
        
        dfs(node, cloneNode, created);
        
        return cloneNode;
    }
}