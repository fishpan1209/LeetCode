class TrieNode {
    // Initialize your data structure here.
    private TrieNode root;
    private TrieNode[] children;
    private boolean isLeaf;
    private boolean isWord;
    private char character;
    
    public TrieNode() {
        this.root = new TrieNode();
        this.children = new TrieNode[26];
        this.isLeaf = true;
        this.isWord = false;
    }
    
    protected TrieNode getNode(char c){
        return children[c-'a'];
    }
    
    protected void addWord(String word)
   {
      isLeaf = false;
      int charPos = word.charAt(0) - 'a';
      
      if (children[charPos] == null)
      {
      children[charPos] = new TrieNode(word.charAt(0));
      children[charPos].parent = this;
      }
      
      if (word.length() > 1)
      {
      children[charPos].addWord(word.substring(1));
      }
      else
      {
      children[charPos].isWord = true;
      }
   }

}


public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        this.root.addWord(word.toLowerCase());
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode lastNode = this.root;
        for(int i=0; i<prefix.length();i++){
            lastNode = lastNode.getNode(prefix.charAt(i));
            if(lastNode == null) return false;
        }
        return true;
       
    }
    
    
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");