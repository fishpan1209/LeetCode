import java.util.HashSet;
public class Solution {
    public String reverseVowels(String s) {
        if(s==null) return null;
        char[] str = s.toCharArray();
        int i=0; 
        int j=str.length-1;
        Set<Character> vowels = new HashSet(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
     
        while(i<j){
            while(!vowels.contains(str[i]) && i<j) i++;
            while(!vowels.contains(str[j]) && i<j) j--;
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;

        }
        return String.valueOf(str);
    }
}