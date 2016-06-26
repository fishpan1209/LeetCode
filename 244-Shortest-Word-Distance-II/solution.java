public class WordDistance {
    private HashMap<String,LinkedList<Integer>> map;
    
    public WordDistance(String[] words) {
        this.map = new HashMap<String, LinkedList<Integer>>();
        for(int i = 0; i < words.length; i++) {
            String curWord = words[i];
            if(!this.map.containsKey(curWord)) this.map.put(curWord,new LinkedList<Integer>());
            this.map.get(curWord).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int shortest = Integer.MAX_VALUE;
        LinkedList<Integer> word1List = map.get(word1);
        LinkedList<Integer> word2List = map.get(word2);
        int p1 = 0;
        int p2 = 0;
        while(p1 < word1List.size() && p2 < word2List.size()) {
            int w1 = word1List.get(p1);
            int w2 = word2List.get(p2);
            shortest = Math.min(shortest, Math.abs(w1-w2));
            if(w1<w2) p1++;
            else p2++;
        }
        return shortest;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");