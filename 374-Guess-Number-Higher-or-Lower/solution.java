/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        while(guess(n)!=0){
            if(guess(n)==1) n++;
            else n--;
        }
        return n;
    }
}