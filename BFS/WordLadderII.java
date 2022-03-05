import java.util.Set;

/*
126. Word Ladder II
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

https://www.jiuzhang.com/solution/word-ladder-ii/
*/
class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() < 1) {
            return res;
        }
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> lb = new HashMap<>();
        Set<String> dict = new HashSet<>();
        dict.add(beginWord);
        for (String word : wordList) {
            dict.add(word);
        }
        for (String word : dict) {
            graph.put(word, getNext(word, dict));
            lb.put(word, getDiff(word, endWord));
        }

        if (!dict.contains(endWord)) {
            return res;
        }
        int limit = 0;
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        while(res.isEmpty()) {
            dfs(limit, 1, beginWord, endWord, lb, graph, path, res);
            limit++;
        }
        return res;
    }

    private List<String> getNext(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] cs = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                cs[i] = c;
                String next = String.valueOf(cs);
                if (dict.contains(next) && !word.equals(next)) {
                    res.add(next);
                }
            }
        }
        return res;
    }

    private int getDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

    private void dfs(int limit, int x, String word, String end, Map<String, Integer> lb, 
                     Map<String, List<String>> graph, List<String> path, List<List<String>> res) {
        if (x == limit + 1) {
            if (word.equals(end)) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        //System.out.println(word);
        //System.out.println(lb.get(word));
        if (x - 1 + lb.get(word) > limit) {
            return;
        }

        for (String next : graph.get(word)) {
            path.add(next);
            dfs(limit, x + 1, next, end, lb, graph, path, res);
            path.remove(path.size() - 1);
        }

        if (res.isEmpty()) {
            lb.put(word, Math.max(limit - (x - 1) + 1, lb.get(word)));
        }
    }
}