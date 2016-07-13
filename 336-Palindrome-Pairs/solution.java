public class Solution {
    
    public List<List<Integer>> palindromePairs(String[] words){
        List<List<Integer>> res = new ArrayList();
        if(words==null || words.length==0) return res;
        HashMap<String, Integer> map = new HashMap();
        for(int i=0; i<words.length; i++){
            map.put(words[i], i);
        }
        
        for(int i=0; i<words.length; i++){
            String w = words[i];
            for(int j=0; j<=w.length(); j++){
                String s1 = w.substring(0, j);
                String s2 = w.substring(j); // beginIndes = j;
                if(isPalindrome(s1)){
                    String s2Reverse = new StringBuilder(s2).reverse().toString();
                    if (map.getOrDefault(s2Reverse, i) != i) {
                        res.add(Arrays.asList(map.get(s2Reverse), i));
                    }
                }
                // check s2!=null to avoid duplicate
                if(isPalindrome(s2) && s2.length()!=0){
                    String s1Reverse = new StringBuilder(s1).reverse().toString();
                    if (map.getOrDefault(s1Reverse, i) != i) {
                        res.add(Arrays.asList(i, map.get(s1Reverse)));
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String str) {
        for (int l = 0, r = str.length() - 1; l <= r; l ++, r --) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
        }
        return true;
    }
    
    // time limit exceeded
    /*
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> res = new ArrayList();
        if(words==null || words.length==0) return res;
        for(int i=0; i<words.length-1; i++){
            for(int j=i+1; j<words.length; j++){
                if(isPalindrome(i, j, words)){
                    res.add(new ArrayList(Arrays.asList(i, j)));
                }
                if(isPalindrome(j, i, words)){
                    res.add(new ArrayList(Arrays.asList(j, i)));
                }
                
            }
        }
        return res;
    }
    
    public boolean isPalindrome(int i, int j, String[] words){
        String s = words[i]+words[j];
        for(int l=0, r=s.length()-1; l<r; l++, r--){
            if(s.charAt(l)!=s.charAt(r)) return false;
        }
        return true;
    }
    */
}