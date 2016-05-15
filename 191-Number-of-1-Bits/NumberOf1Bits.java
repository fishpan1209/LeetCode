public class Solution {
    // you need to treat n as an unsigned value
    /* Any unsigned integer 'n' will have the following last k digits: One followed by (k-1) zeroes: 100...0 Note that k can be 1 in which case there are no zeroes.

(n - 1) will end in this format: Zero followed by (k-1) 1's: 011...1

n & (n-1) will therefore end in 'k' zeroes: 100...0 & 011...1 = 000...0

Hence n & (n - 1) will eliminate the rightmost '1'. Each iteration of this will basically remove the rightmost '1' digit and hence you can count the number of 1's
*/
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
