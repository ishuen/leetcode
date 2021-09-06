// 731. My Calendar II
// You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.
//
// A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).
//
// The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
//
// Implement the MyCalendarTwo class:
//
// MyCalendarTwo() Initializes the calendar object.
// boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
//
//
// Example 1:
//
// Input
// ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
// [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
// Output
// [null, true, true, true, false, true, true]
//
// Explanation
// MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
// myCalendarTwo.book(10, 20); // return True, The event can be booked.
// myCalendarTwo.book(50, 60); // return True, The event can be booked.
// myCalendarTwo.book(10, 40); // return True, The event can be double booked.
// myCalendarTwo.book(5, 15);  // return False, The event ca not be booked, because it would result in a triple booking.
// myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
// myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
//
//
// Constraints:
//
// 0 <= start < end <= 109
// At most 1000 calls will be made to book.
// Runtime: 187 ms, faster than 56.30% of Java online submissions for My Calendar II.
// Memory Usage: 40 MB, less than 40.14% of Java online submissions for My Calendar II.
class MyCalendarTwo {

    private TreeMap<Integer, Integer> calendar;
    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int openEvent = 0;
        for (Map.Entry<Integer, Integer> entry: calendar.entrySet()) {
            openEvent += entry.getValue();
            if (openEvent > 2) {
                int s = calendar.get(start) - 1;
                if (s == 0) calendar.remove(start);
                else calendar.put(start, s);
                int e = calendar.get(end) + 1;
                if (e == 0) calendar.remove(end);
                else calendar.put(end, e);
                return false;
            }
        }
        return true;
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

// Map<key: start, value: end>
// start = 1, end = -1 => when an event ends, # of open event = 0
