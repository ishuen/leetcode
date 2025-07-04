// 855. Exam Room

// There is an exam room with n seats in a single row labeled from 0 to n - 1.
//
// When a student enters the room, they must sit in the seat that maximizes the distance to the closest person. If there are multiple such seats, they sit in the seat with the lowest number. If no one is in the room, then the student sits at seat number 0.
//
// Design a class that simulates the mentioned exam room.
//
// Implement the ExamRoom class:
//
// ExamRoom(int n) Initializes the object of the exam room with the number of the seats n.
// int seat() Returns the label of the seat at which the next student will set.
// void leave(int p) Indicates that the student sitting at seat p will leave the room. It is guaranteed that there will be a student sitting at seat p.
//
//
// Example 1:
//
// Input
// ["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"]
// [[10], [], [], [], [], [4], []]
// Output
// [null, 0, 9, 4, 2, null, 5]
//
// Explanation
// ExamRoom examRoom = new ExamRoom(10);
// examRoom.seat(); // return 0, no one is in the room, then the student sits at seat number 0.
// examRoom.seat(); // return 9, the student sits at the last seat number 9.
// examRoom.seat(); // return 4, the student sits at the last seat number 4.
// examRoom.seat(); // return 2, the student sits at the last seat number 2.
// examRoom.leave(4);
// examRoom.seat(); // return 5, the student sits at the last seat number 5.
//
//
//
// Constraints:
//
// 1 <= n <= 109
// It is guaranteed that there is a student sitting at seat p.
// At most 104 calls will be made to seat and leave.

// Runtime 840 ms Beats 18.22%
// Memory 45 MB Beats 55.33%
class ExamRoom {
    private int capacity;
    private TreeSet<Integer> seats;
    public ExamRoom(int n) {
        capacity = n;
        seats = new TreeSet<>();
    }
    
    public int seat() {
        int index = 0;
        if (seats.size() > 0) {
            int prev = -1;
            int max = 0;
            for (int seat: seats) {
                int dis = prev < 0 ? seat : (seat - prev) / 2;
                if (max < dis) {
                    max = dis;
                    index = prev < 0 ? 0 : prev + dis;
                }
                prev = seat;
            }
            if (!seats.contains(capacity - 1) && (capacity - 1 - seats.last()) > max) {
            index = capacity - 1;       
            }
        }
        seats.add(index);
        return index;
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
}

// Runtime 808 ms Beats 26.12%
// Memory 45.6 MB Beats 17.53%
class ExamRoom {
    private int capacity;
    private TreeSet<Integer> seats;
    public ExamRoom(int n) {
        capacity = n;
        seats = new TreeSet<>();
    }
    
    public int seat() {
        int index = 0;
        if (seats.size() > 0) {
            int prev = -1;
            int max = seats.first();
            for (int seat: seats) {
                if (prev != -1) {
                    int dis = (seat - prev) / 2;
                    if (max < dis) {
                        max = dis;
                        index = prev + dis;
                    }
                }
                prev = seat;
            }
            if (capacity - 1 - seats.last() > max) {
            index = capacity - 1;       
            }
        }
        seats.add(index);
        return index;
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
}
