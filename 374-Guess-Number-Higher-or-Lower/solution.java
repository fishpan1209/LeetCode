/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessBST(1, n);
    }
    
    public int guessBST(int left, int right){
        int mid = left+(right-left)/2;
        if(guess(mid)==0) return mid;
        else if(guess(mid)==1) return guessBST(mid+1, right);
        else return guessBST(left, mid-1);
    }
}