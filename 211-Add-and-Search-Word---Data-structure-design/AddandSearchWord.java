
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
        TrieNode ws = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c != '.'){
                if(ws.children[c-'a']==null) return false;
                
            }
            else {
                if(i<word.length()-1) c= word.charAt(i+1);
                else return true;
            }
            ws = ws.children[c-'a'];
        }
        return true;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");