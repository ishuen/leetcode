// 609. Find Duplicate File in System
// Given a list paths of directory info, including the directory path, and all the files with contents in this directory, return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.
//
// A group of duplicate files consists of at least two files that have the same content.
//
// A single directory info string in the input list has the following format:
//
// "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
// It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) respectively in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
//
// The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:
//
// "directory_path/file_name.txt"
//
//
// Example 1:
//
// Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
// Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
// Example 2:
//
// Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
// Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
//
//
// Constraints:
//
// 1 <= paths.length <= 2 * 104
// 1 <= paths[i].length <= 3000
// 1 <= sum(paths[i].length) <= 5 * 105
// paths[i] consist of English letters, digits, '/', '.', '(', ')', and ' '.
// You may assume no files or directories share the same name in the same directory.
// You may assume each given directory info represents a unique directory. A single blank space separates the directory path and file info.
//
//
// Follow up:
//
// Imagine you are given a real file system, how will you search files? DFS or BFS?
// If the file content is very large (GB level), how will you modify your solution?
// If you can only read the file by 1kb each time, how will you modify your solution?
// What is the time complexity of your modified solution? What is the most time-consuming part and memory-consuming part of it? How to optimize?
// How to make sure the duplicated files you find are not false positive?
//
//
// Runtime 25ms Beats 54.83%of users with Java
// Memory 50.36MB Beats 99.23%of users with Java
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String folder: paths) {
            String[] files = folder.split(" ");
            for (int i = 1; i < files.length; i++) {
                String[] file = extractFile(files[i]);
                List<String> list = map.getOrDefault(file[1], new ArrayList<>());
                list.add(files[0] + "/" + file[0]);
                map.put(file[1], list);
            }
        }
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            if (entry.getValue().size() > 1) {
                ans.add(entry.getValue());
            }
        }
        return ans;
    }

    private String[] extractFile(String file) {
        int left = file.indexOf('(');
        return new String[]{file.substring(0, left), file.substring(left + 1, file.length() - 1)};
    }
}

// Runtime 19ms Beats 91.89%of users with Java
// Memory 50.80MB Beats 98.84%of users with Java
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String folder: paths) {
            String[] files = folder.split(" ");
            for (int i = 1; i < files.length; i++) {
                String[] file = extractFile(files[i]);
                List<String> list = map.getOrDefault(file[1], new ArrayList<>());
                list.add(files[0] + "/" + file[0]);
                map.put(file[1], list);
            }
        }
        for (List<String> value: map.values()) {
            if (value.size() > 1) {
                ans.add(value);
            }
        }
        return ans;
    }

    private String[] extractFile(String file) {
        int left = file.indexOf('(');
        return new String[]{file.substring(0, left), file.substring(left + 1, file.length() - 1)};
    }
}
