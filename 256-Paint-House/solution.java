public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int n = costs.length;   // num of house
        int red = 0;
        int blue = 0;
        int green = 0;
        for(int i=0; i<n; i++){
            int r = red, b = blue, g = green; // need to save these first because they'll be changed
            red = costs[i][0]+Math.min(b, g);
            blue = costs[i][1]+Math.min(r, g);
            green = costs[i][2]+Math.min(r, b);
        }
        return Math.min(red, Math.min(blue, green));
    }
}