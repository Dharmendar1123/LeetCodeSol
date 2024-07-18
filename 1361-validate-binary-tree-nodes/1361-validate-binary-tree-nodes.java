class Solution {

    public int count(int root, int[] leftChild, int[] rightChild) {
        if (root == -1) {
            return 0;
        }

        return 1 + count(leftChild[root], leftChild, rightChild) + count(rightChild[root], leftChild, rightChild);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        // Map<Integer, Integer> childToParent = new HashMap<>();
        int[] childToParent = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int node = i;
            int leftC = leftChild[i];
            int rightC = rightChild[i];
            
            if (leftC != -1) {
                // if (childToParent.containsKey(leftC)) {
                //     return false;
                // }else {
                //     childToParent.put(leftC, node);
                // }
                if (childToParent[leftC] != 0) {
                    return false;
                }else {
                    childToParent[leftC]++;
                }
            }
            
            if (rightC != -1) {
                // if (childToParent.containsKey(rightC)) {
                //     return false;
                // }else {
                //     childToParent.put(rightC, node);
                // }
                if (childToParent[rightC] != 0) {
                    return false;
                }else {
                    childToParent[rightC]++;
                }
            }
        }
        
        int root = -1;
        for (int i = 0; i < n; ++i) {
            // if (!childToParent.containsKey(i)) {
            //     if (root != -1) {
            //         return false;
            //     }else {
            //         root = i;
            //     }
            // }
            if (childToParent[i] > 1) {
                return false;
            }
            if (childToParent[i] == 0) {
                root = i;
            }
        }
        
        if (root == -1) {
            return false;
        }
        
        // boolean[] visited = new boolean[n];
        // Queue<Integer> que = new LinkedList<>();
        // int count = 0;
        // que.offer(root);
        
        // while (!que.isEmpty()) {
        //     int node = que.poll();
        //     if (visited[node]) {
        //         return false;
        //     }
        //     visited[node] = true;
        //     count++;
        //     if (leftChild[node] != -1) {
        //         que.offer(leftChild[node]);
        //     }

        //     if (rightChild[node] != -1) {
        //         que.offer(rightChild[node]);
        //     }
        // }
        // return count == n;
        
        return count(root, leftChild, rightChild) == n;
    }
}