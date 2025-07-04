// 3203. Find Minimum Diameter After Merging Two Trees
//
// There exist two undirected trees with n and m nodes, numbered from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.
//
// You must connect one node from the first tree with another node from the second tree with an edge.
//
// Return the minimum possible diameter of the resulting tree.
//
// The diameter of a tree is the length of the longest path between any two nodes in the tree.
//
//
//
// Example 1:
//
// Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]
//
// Output: 3
//
// Explanation:
//
// We can obtain a tree of diameter 3 by connecting node 0 from the first tree with any node from the second tree.
//
// Example 2:
//
//
// Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]
//
// Output: 5
//
// Explanation:
//
// We can obtain a tree of diameter 5 by connecting node 0 from the first tree with node 0 from the second tree.
//
//
//
// Constraints:
//
// 1 <= n, m <= 105
// edges1.length == n - 1
// edges2.length == m - 1
// edges1[i].length == edges2[i].length == 2
// edges1[i] = [ai, bi]
// 0 <= ai, bi < n
// edges2[i] = [ui, vi]
// 0 <= ui, vi < m
// The input is generated such that edges1 and edges2 represent valid trees.
//
//
//
// Runtime 358 ms Beats 100.00%
// Memory 125.87 MB Beats 80.00%
function minimumDiameterAfterMerge(edges1: number[][], edges2: number[][]): number {
    const diameter1 = findDiameter(edges1)
    const diameter2 = findDiameter(edges2)
    return Math.max(diameter1, diameter2, Math.floor((diameter1 + 1)/ 2) + Math.floor((diameter2 + 1)/2) + 1)
};

// find longest distance
function findDiameter(edges: number[][]): number {
    const mappings: number[][] = new Array()
    for (let i = 0; i < edges.length + 1; i++) {
        mappings.push(new Array())
    }
    for (let i = 0; i < edges.length; i++) {
        mappings[edges[i][0]].push(edges[i][1])
        mappings[edges[i][1]].push(edges[i][0])
    }
    const traverse = (start: number): number[] => {
        const levels : number[] = new Array(edges.length + 1).fill(-1)
        const queue: number[] = [start]
        levels[start] = 0
        let furthest = start
        while (queue.length > 0) {
            const cur = queue.shift()
            for (const next of mappings[cur]) {
                if (levels[next] == -1) {
                    levels[next] = levels[cur] + 1
                    queue.push(next)
                    if (levels[next] > levels[furthest]) {
                        furthest = next
                    }
                } 
            }
        }
        return [furthest, levels[furthest]]
    }
    const trial = traverse(0) // find furthest node
    return traverse(trial[0])[1] // recalculate furthest node level
}
