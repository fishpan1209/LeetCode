public class ValidWordAbbr {
    private Set<String> dict;

    public ValidWordAbbr(String[] dictionary) {
        dict = new HashSet<String>();
        for(String s : dictionary){
            String abbr = abbr(s);
            if(!dict.contains(abbr)) dict.add(abbr);
        }
    }

    public boolean isUnique(String word) {
        String w_abbr = abbr(word);
        if(dict.contains(w_abbr)) return false;
        else return true;
    }
    
    public String abbr(String s){
        if(s.length()<=2) return s;
        else{
            return s.charAt(0)+(s.length()-2)+s.charAt(s.length()-1);
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");