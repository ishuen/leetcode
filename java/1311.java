// 1311. Get Watched Videos by Your Friends
//
// There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends respectively for the person with id = i.
//
// Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on. In general, the level k of videos are all watched videos by people with the shortest path exactly equal to k with you. Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing). For videos with the same frequency order them alphabetically from least to greatest.
//
//
//
// Example 1:
//
//
//
// Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
// Output: ["B","C"]
// Explanation:
// You have id = 0 (green color in the figure) and your friends are (yellow color in the figure):
// Person with id = 1 -> watchedVideos = ["C"]
// Person with id = 2 -> watchedVideos = ["B","C"]
// The frequencies of watchedVideos by your friends are:
// B -> 1
// C -> 2
// Example 2:
//
//
//
// Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
// Output: ["D"]
// Explanation:
// You have id = 0 (green color in the figure) and the only friend of your friends is the person with id = 3 (yellow color in the figure).
//
//
// Constraints:
//
// n == watchedVideos.length == friends.length
// 2 <= n <= 100
// 1 <= watchedVideos[i].length <= 100
// 1 <= watchedVideos[i][j].length <= 8
// 0 <= friends[i].length < n
// 0 <= friends[i][j] < n
// 0 <= id < n
// 1 <= level < n
// if friends[i] contains j, then friends[j] contains i
//
// Runtime 25ms Beats 91.13%of users with Java
// Memory 45.23MB Beats 29.84%of users with Java
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer> friendList = getFriendList(id, level, friends);
        Map<String, Integer> map = new HashMap<>();
        for (int friend: friendList) {
            for (String video: watchedVideos.get(friend)) {
                int count = map.getOrDefault(video, 0);
                map.put(video, count + 1);
            }
        }
        PriorityQueue<Video> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return a.name.compareTo(b.name);
            }
            return a.count - b.count;
        });
        for (String key: map.keySet()) {
            pq.add(new Video(key, map.get(key)));
        }
        List<String> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            Video v = pq.remove();
            output.add(v.name);
        }
        return output;
    }

    class Video {
        int count; 
        String name;
        public Video(String name, int count) {
            this.count = count;
            this.name = name;
        }
    }

    private List<Integer> getFriendList(int id, int level, int[][] friends) {
        int curLevel = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(id);
        boolean[] visited = new boolean[friends.length];
        visited[id] = true;
        List<Integer> output = new ArrayList<>();
        while (curLevel < level) {
            List<Integer> tempList = new ArrayList<>();
            int size = stack.size();
            for (int j = 0; j < size; j++) {
                int cur = stack.pop();
                for (int i = 0; i < friends[cur].length; i++) {
                    if (visited[friends[cur][i]] == false) {
                        tempList.add(friends[cur][i]);
                        visited[friends[cur][i]] = true;
                        stack.add(friends[cur][i]);
                    }
                }
            }
            curLevel++;
            output = tempList;
        }
        return output;
    }
}