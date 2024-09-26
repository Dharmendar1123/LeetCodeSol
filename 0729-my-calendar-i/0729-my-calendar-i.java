class MyCalendar {
    
    TreeSet<int[]> st;

    public MyCalendar() {
        st = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); 
    }
    
    public boolean book(int start, int end) {
        
        int[] event = new int[] {start, end};
        int[] next = st.ceiling(event);
        
        if (next != null && next[0] < end) {
            return false;
        }
        
        int[] prev = st.floor(event);
        if (prev != null && start < prev[1]) {
            return false;
        }
        
        st.add(event);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */