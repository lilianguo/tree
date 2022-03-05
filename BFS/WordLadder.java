/*
127. Word Ladder
Medium

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.



Time Complexity: O(M×N)O(M \times N)O(M×N), where MMM is the length of words and NNN is the total number of words in the input word list. Finding out all the transformations takes MMM iterations for each of the NNN words. Also, breadth first search in the worst case might go to each of the NNN words.

Space Complexity: O(M×N)O(M \times N)O(M×N), to store all MMM transformations for each of the NNN words, in the all_combo_dict dictionary. Visited dictionary is of NNN size. Queue for BFS in worst case would need space for all NNN words.

*/
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        visited.add(beginWord);
        queue.add(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            //System.out.println("size = " + size);
            res++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                //System.out.println("curr = " + curr);
                if (curr.equals(endWord)) {
                    return res;
                }

                for (String next : getNext(curr, dict)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            
        }
        
        return 0;
    }
    
    private Set<String> getNext(String curr, Set<String> dict) {
        Set<String> nexts = new HashSet<>();
        for (int i = 0; i < curr.length(); i++) {
            char[] cs = curr.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != cs[i]) {
                    cs[i] = c;
                    //System.out.println("cs.toString() = " + String.valueOf(cs));
                    if (dict.contains(String.valueOf(cs))) {
                        nexts.add(String.valueOf(cs));
                    }
                }
            } 
        }
        //System.out.println("nexts.size() = " + nexts.size());
        return nexts;
    }
}