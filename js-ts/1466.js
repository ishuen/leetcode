// 1466. Reorder Routes to Make All Paths Lead to the City Zero
//
// There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
//
// Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
//
// This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
//
// Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
//
// It's guaranteed that each city can reach city 0 after reorder.
//
//
//
// Example 1:
//
//
// Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
// Output: 3
// Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
// Example 2:
//
//
// Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
// Output: 2
// Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
// Example 3:
//
// Input: n = 3, connections = [[1,0],[2,0]]
// Output: 0
//
//
// Constraints:
//
// 2 <= n <= 5 * 104
// connections.length == n - 1
// connections[i].length == 2
// 0 <= ai, bi <= n - 1
// ai != bi
//

// Runtime 398 ms Beats 25.33% of users with JavaScript
// Memory 114.34 MB Beats 81.07% of users with JavaScript
/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number}
 */
var minReorder = function(n, connections) {
    const fromMap = new Map();
    const toMap = new Map();
    const visited = new Array(n);
    let count = 0;
    for (let connection of connections) {
        if (fromMap.has(connection[1])) {
            let sources = fromMap.get(connection[1]);
            sources.push(connection[0]);
            fromMap.set(connection[1], sources);
        } else {
            fromMap.set(connection[1], [connection[0]]);
        }
        if (toMap.has(connection[0])) {
            let destinations = toMap.get(connection[0]);
            destinations.push(connection[1]);
            toMap.set(connection[0], destinations);
        } else {
            toMap.set(connection[0], [connection[1]]);
        }   
    }
    let toVisit = [0];
    while (!isAllVisited(visited)) {
        const next = toVisit.shift();
        if (visited[next]) continue;
        let sources = fromMap.get(next);
        if (sources) {
            for (let source of sources) {
                if (visited[source]) continue;
                toVisit.push(source);
            }
        }
        
        let destinations = toMap.get(next);
        if (destinations) {
            for (let dest of destinations) {
                if (visited[dest]) continue;
                toVisit.push(dest);
                count++;
            }
        }
        visited[next] = true; 
    }
    return count;
};

var isAllVisited = function(visited) {
    for (let i = 0; i < visited.length; i++) {
        if (!visited[i]) return false;
    }
    return true;
}

// Runtime 279 ms Beats 73.33% of users with JavaScript
// Memory 111.24 MB Beats 83.73% of users with JavaScript
var minReorder = function(n, connections) {
    const fromMap = new Map();
    const toMap = new Map();
    const visited = new Set();
    let count = 0;
    for (let connection of connections) {
        if (fromMap.has(connection[1])) {
            let sources = fromMap.get(connection[1]);
            sources.push(connection[0]);
            fromMap.set(connection[1], sources);
        } else {
            fromMap.set(connection[1], [connection[0]]);
        }
        if (toMap.has(connection[0])) {
            let destinations = toMap.get(connection[0]);
            destinations.push(connection[1]);
            toMap.set(connection[0], destinations);
        } else {
            toMap.set(connection[0], [connection[1]]);
        }   
    }
    let toVisit = [0];
    while (visited.size != n) {
        const next = toVisit.shift();
        if (visited.has(next)) continue;
        let sources = fromMap.get(next);
        if (sources) {
            for (let source of sources) {
                if (visited.has(source)) continue;
                toVisit.push(source);
            }
        }
        
        let destinations = toMap.get(next);
        if (destinations) {
            for (let dest of destinations) {
                if (visited.has(dest)) continue;
                toVisit.push(dest);
                count++;
            }
        }
        visited.add(next);
    }
    return count;
};