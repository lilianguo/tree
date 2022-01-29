/**
 * 211. Design Add and Search Words Data Structure Medium
 *
 * <p>Design a data structure that supports adding new words and finding if a string matches any
 * previously added string.
 *
 * <p>Implement the WordDictionary class:
 *
 * <p>WordDictionary() Initializes the object. void addWord(word) Adds word to the data structure,
 * it can be matched later. bool search(word) Returns true if there is any string in the data
 * structure that matches word or false otherwise. word may contain dots '.' where dots can be
 * matched with any letter.
 *
 * <p>Example:
 *
 * <p>Input ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]] Output
 * [null,null,null,null,false,true,true,true]
 *
 * <p>Explanation WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad"); wordDictionary.addWord("dad"); wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True wordDictionary.search("b.."); // return True
 *
 * <p>Constraints:
 *
 * <p>1 <= word.length <= 500 word in addWord consists lower-case English letters. word in search
 * consist of '.' or lower-case English letters. At most 50000 calls will be made to addWord and
 * search.
 */
// HashMap
class WordDictionary {
  Map<Integer, Set<String>> d;

  public WordDictionary() {
    d = new HashMap();
  }

  public void addWord(String word) {
    int m = word.length();
    if (!d.containsKey(m)) {
      d.put(m, new HashSet());
    }
    d.get(m).add(word);
  }

  public boolean search(String word) {
    int m = word.length();
    if (d.containsKey(m)) {
      for (String w : d.get(m)) {
        int i = 0;
        while (i < m && ((w.charAt(i) == word.charAt(i)) || word.charAt(i) == '.')) {
          i++;
        }
        if (i == m)
          return true;
      }
    }
    return false;
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */