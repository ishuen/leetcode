// 1233. Remove Sub-Folders from the Filesystem

// Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.

// If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".

// The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.

// For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.
 

// Example 1:

// Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
// Output: ["/a","/c/d","/c/f"]
// Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
// Example 2:

// Input: folder = ["/a","/a/b/c","/a/b/d"]
// Output: ["/a"]
// Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
// Example 3:

// Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
// Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 

// Constraints:

// 1 <= folder.length <= 4 * 104
// 2 <= folder[i].length <= 100
// folder[i] contains only lowercase letters and '/'.
// folder[i] always starts with the character '/'.
// Each folder name is unique.


// Runtime 70 ms Beats 20.00%
// Memory 24.31 MB Beats 10.00%
type Folder struct {
    HasFolder bool
    Next map[string]*Folder
}
func removeSubfolders(folder []string) []string {
    root := &Folder{
        HasFolder: false,
        Next: make(map[string]*Folder),
    }
    for _, path := range folder {
        addToTree(root, path)
    }
    output := []string{}
    var traverseTree func(folder *Folder, temp string)
    traverseTree = func(folder *Folder, temp string) {
        if folder.HasFolder {
            output = append(output, temp[1:])
        } else {
            for key, f := range folder.Next {
                traverseTree(f, temp + "/" + key)
            }
        }
    }
    traverseTree(root, "")
    return output
}

func addToTree(root *Folder, path string) {
    folders := strings.Split(path, "/")
    current := root
    for index, name := range folders {
        _, ok := current.Next[name]
        if !ok {
            if index != len(folders) - 1 {
                current.Next[name] = &Folder{
                    HasFolder: false,
                    Next: make(map[string]*Folder),
                }
                current = current.Next[name]
            } else {
                current.Next[name] = &Folder{
                    HasFolder: true,
                    Next: make(map[string]*Folder),
                }
            }
        } else {
            current = current.Next[name]
            if index == len(folders) - 1 {
                current.HasFolder = true
            }
        }
    }
}


// Runtime 8 ms Beats 100.00%
// Memory 13.86 MB Beats 60.00%
func removeSubfolders(folder []string) []string {
    output := []string{}
    slices.Sort(folder)
    var prev string
    for i, path := range folder {
        if i != 0 && len(path) > len(prev) && path[:len(prev)] == prev && path[len(prev)] == 
        '/' {
            continue
        }
        output = append(output, path)
        prev = path
    }
    return output
}