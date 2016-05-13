
public class WordDictionary {
    class TrieNode{
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
    
    TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode ws = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c-'a'] == null){
                ws.children[c-'a'] = new TrieNode();
            }
            ws = ws.children[c-'a'];
        }
        ws.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word, 0);
    }
    
    public boolean search(TrieNode root, String word, int pos){
        if(pos == word.length()) return root.isWord;
        if(word.charAt(pos)!='.'){
            return root.children[word.charAt(pos)-'a']!=null && search(root.children[word.charAt(pos)-'a'], word, pos+1);
        }
        else {
            for(int i=0; i<root.children.length; i++){
                if(root.children[i] != null){
                    if(search(root.children[i], word, pos+1)) return true;
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");