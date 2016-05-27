public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        int factorial = 1;
        // create nums list and n!
        ArrayList<Integer> nums = new ArrayList();
        for(int i=1; i<=n; i++){
            nums.add(i);
            factorial *= i;
        }
       
        for(int i=0; i<n; i++){
            factorial /= (n-i);
            System.out.println(factorial);
            // must use k-1 becuase 0-based
            int index = (k-1)/factorial;
            System.out.println(index);
            res.append(nums.get(index));
            nums.remove(index);
            k -= index*factorial;
            System.out.println("k: "+k);
        }
        return res.toString();
    }
}