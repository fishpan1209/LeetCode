public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length())>=2) return false;
        int dist = 0;
        if(s.length()==t.length()){
            for(int i=0; i<s.length(); i++){
                if(dist>1) return false;
                if(s.charAt(i)!=t.charAt(i)) dist += 1;
            }
        }
        else{
            String longer = s.length()>t.length()? s : t;
            String shorter = s.length()>t.length()? t : s;
            int i=0, j=0;
            while(j<shorter.length()){
                if(longer.charAt(i)!=shorter.charAt(j)){
                    if(longer.charAt(i+1)==shorter.charAt(j)){
                        dist += 1;
                        i+=1;
                    }
                    else return false;
                }
                i++;
                j++;
            }
        }
        return dist==1;
    }
}