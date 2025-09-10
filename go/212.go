// 212. Word Search II

// Given an m x n board of characters and a list of strings words, return all words on the board.

// Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

// Example 1:


// Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
// Output: ["eat","oath"]
// Example 2:


// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []
 

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] is a lowercase English letter.
// 1 <= words.length <= 3 * 104
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// All the strings of words are unique.

// Runtime 702 ms Beats 30.87%
// Memory 14.14 MB Beats 5.35%
func findWords(board [][]byte, words []string) []string {
    width := len(board[0])
    height := len(board)
    tree := arrangeWords(words, width, height)
    found := make(map[string]bool)

    directions := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
    var findWord func(row int, col int, visited [][]bool, node *Node, cur string)
    findWord = func(row int, col int, visited [][]bool, node *Node, cur string) {
        if node == nil {
            return
        }
        if node.IsEnd == true {
            found[cur] = true
        }
        for i := 0; i < 4; i++ {
            r := row + directions[i][0]
            c := col + directions[i][1]
            if r < 0 || c < 0 || r >= height || c >= width || visited[r][c] == true {
                continue
            }
            charIndex := board[r][c] - 'a'
            if node.Count > 0 && node.Next[charIndex] != nil {
                visited[r][c] = true
                findWord(r, c, visited, node.Next[charIndex], cur + string(board[r][c]))
                visited[r][c] = false
            }
        }
    }

    visited := make([][]bool, height)
    for index := range visited {
        visited[index] = make([]bool, width)
    }
    for i := 0; i < height; i++ {
        for j := 0; j < width; j++ {    
            visited[i][j] = true
            findWord(i, j, visited, tree.Next[board[i][j] - 'a'], string(board[i][j]))
            visited[i][j] = false
        }
    }
    output := []string{}
    for key := range found {
        output = append(output, key)
    }
    return output
}
type Node struct {
    IsEnd bool
    Next []*Node
    Count int
}

func (n *Node) AddNode(word string) {
    cur := n
    for i := 0; i < len(word); i++ {
        index := word[i] - 'a'
        cur.Count++
        if cur.Next[index] == nil {
            cur.Next[index] = &Node{IsEnd: false, Next: make([]*Node, 26)}
        }
        cur = cur.Next[index]
    }
    cur.IsEnd = true
}

func arrangeWords(words []string, width int, height int) *Node {
    tree := &Node{
        IsEnd: false,
        Next: make([]*Node, 26),
    }
    maxLength := width * height
    for _, word := range words {
        if len(word) > maxLength {
            continue
        }
        tree.AddNode(word)
    }
    return tree
}

// Runtime 46 ms Beats 98.77%
// Memory 10.28 MB Beats 20.16%
func findWords(board [][]byte, words []string) []string {
    width := len(board[0])
    height := len(board)
    tree := arrangeWords(words, width, height)
    found := []string{}

    directions := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
    var findWord func(row int, col int, node *Node, cur string)
    findWord = func(row int, col int, node *Node, cur string) {
        if node == nil {
            return
        }
        if node.IsEnd == true {
            found = append(found, cur)
            tree.RemoveNode(cur)
        }
        for i := 0; i < 4; i++ {
            r := row + directions[i][0]
            c := col + directions[i][1]
            if r < 0 || c < 0 || r >= height || c >= width || board[r][c] == '.' {
                continue
            }
            charIndex := board[r][c] - 'a'
            if node.Next[charIndex] != nil {
                temp := board[r][c]
                board[r][c] = '.'
                findWord(r, c, node.Next[charIndex], cur + string(temp))
                board[r][c] = temp
            }
        }
    }

    for i := 0; i < height; i++ {
        for j := 0; j < width; j++ {
            temp := board[i][j]
            board[i][j] = '.'
            findWord(i, j, tree.Next[temp - 'a'], string(temp))
            board[i][j] = temp
        }
    }
    return found
}
type Node struct {
    IsEnd bool
    Next [26]*Node
}

func (n *Node) AddNode(word string) {
    cur := n
    for i := 0; i < len(word); i++ {
        index := word[i] - 'a'
        if cur.Next[index] == nil {
            cur.Next[index] = &Node{}
        }
        cur = cur.Next[index]
    }
    cur.IsEnd = true
}

func (n *Node) RemoveNode(word string) bool {
    if len(word) == 0 {
        n.IsEnd = false
        isEmpty := true
        for i := 0; i < 26; i++ {
            if n.Next[i] != nil {
                return false
            }
        }
        return isEmpty
    }
    charIndex := word[0] - 'a'
    isChildEmpty := n.Next[charIndex].RemoveNode(word[1:])
    if isChildEmpty == true {
        n.Next[charIndex] = nil
        isEmpty := true
        for i := 0; i < 26; i++ {
            if n.Next[i] != nil {
                return false
            }
        }
        return isEmpty
    }
    return false
}

func arrangeWords(words []string, width int, height int) *Node {
    tree := &Node{}
    maxLength := width * height
    for _, word := range words {
        if len(word) > maxLength {
            continue
        }
        tree.AddNode(word)
    }
    return tree
}