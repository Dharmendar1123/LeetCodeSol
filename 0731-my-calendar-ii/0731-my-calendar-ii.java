class MyCalendarTwo {
    
    List<int[]> doubleBooking;
    List<int[]> booking;
    
    private boolean checkOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }
    
    private int[] findOverlap(int start1, int end1, int start2, int end2) {
        return new int[] {Math.max(start1, start2), Math.min(end1, end2)};
    }

    public MyCalendarTwo() {
        doubleBooking = new ArrayList<>();
        booking = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        
        for (int[] region : doubleBooking) {
            if (checkOverlap(region[0], region[1], start, end)) {
                return false;
            }
        }
        
        for (int[] book : booking) {
            if (checkOverlap(book[0], book[1], start, end)) {
                doubleBooking.add(findOverlap(book[0], book[1], start, end));
            }
        }
        
        booking.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */