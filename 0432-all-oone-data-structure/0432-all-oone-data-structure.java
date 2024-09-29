class AllOne {
    
    private class Node {
        int count;
        LinkedHashSet<String> keys;
        Node prev, next;
        
        Node(int c) {
            count = c;
            keys = new LinkedHashSet<>();
        }
    }
    
    private Map<String, Node> keyCountMap;
    private Node head, tail;

    public AllOne() {
        keyCountMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    private Node addNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        return newNode;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void inc(String key) {
        if (!keyCountMap.containsKey(key)) {
            if (head.next == tail || head.next.count != 1) {
                addNodeAfter(head, 1);
            }
            head.next.keys.add(key);
            keyCountMap.put(key, head.next);
        }else {
            Node currNode = keyCountMap.get(key);
            int currCount = currNode.count;
            if (currNode.next == tail || currNode.next.count != currCount + 1) {
                addNodeAfter(currNode, currCount + 1);
            }
            currNode.next.keys.add(key);
            keyCountMap.put(key, currNode.next);
            currNode.keys.remove(key);
            if (currNode.keys.isEmpty()) {
                removeNode(currNode);
            }
        }
    }
    
    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }
        
        Node currNode = keyCountMap.get(key);
        int currCount = currNode.count;
        
        currNode.keys.remove(key);
        
        if (currCount == 1) {
            keyCountMap.remove(key);
        }else {
            if (currNode.prev == head || currNode.prev.count != currCount - 1) {
                addNodeAfter(currNode.prev, currCount - 1);
            }
            
            currNode.prev.keys.add(key);
            keyCountMap.put(key, currNode.prev);
        }
        
        if (currNode.keys.isEmpty()) {
            removeNode(currNode);
        }
    }
    
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */