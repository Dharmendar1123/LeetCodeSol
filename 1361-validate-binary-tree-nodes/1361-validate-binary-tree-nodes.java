class Solution {
    int[] parent;
    int component;
    
    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private boolean union(int par, int child) {
        
        if (find(child) != child) {
            return false;
        }
        
        if (find(par) == child) {
            return false;
        }
        
        parent[child] = par;
        component--;
        
        return true;
    }
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        component = n;
        parent = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; ++i) {
            
            int node = i;
            int lc = leftChild[i];
            int rc = rightChild[i];
            
            if (lc != -1 && union(node, lc) == false) {
                return false;
            }
            
            if (rc != -1 && union(node, rc) == false) {
                return false;
            }
        }
        return component == 1;
    }
}