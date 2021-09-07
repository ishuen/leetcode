// 332. Reconstruct Itinerary
// You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
//
// All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
//
// For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
//
//
//
// Example 1:
//
//
// Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
// Output: ["JFK","MUC","LHR","SFO","SJC"]
// Example 2:
//
//
// Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
// Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
//
//
// Constraints:
//
// 1 <= tickets.length <= 300
// tickets[i].length == 2
// fromi.length == 3
// toi.length == 3
// fromi and toi consist of uppercase English letters.
// fromi != toi
//
// Runtime: 5 ms, faster than 83.51% of Java online submissions for Reconstruct Itinerary.
// Memory Usage: 39.4 MB, less than 91.95% of Java online submissions for Reconstruct Itinerary.
class Solution {
    private Map<String, PriorityQueue<String>> map;
    private List<String> routes;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        routes = new LinkedList<>();
        for (List<String> ticket: tickets) {
            map.computeIfAbsent(ticket.get(0), t -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK");
        return routes;
    }
    private void visit(String start) {
        while (map.containsKey(start) && !map.get(start).isEmpty()) {
            visit(map.get(start).remove());
        }
        routes.add(0, start);
    }
}

