public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder sb = new StringBuilder();
        
        // + or -
        sb.append(((numerator>0) ^ (denominator>0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        sb.append(num/den);
        long remainer = num%den;
        if(remainer==0) return sb.toString();
        
        // fractional part
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap();
        map.put(remainer, sb.length());
        while(remainer!=0){
            remainer *= 10;
            sb.append(remainer/den);
            remainer %= den;
            if(map.containsKey(remainer)){
                int index = map.get(remainer);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else map.put(remainer, sb.length());
        }
        return sb.toString();
    }
}