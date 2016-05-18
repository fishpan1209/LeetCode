public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m==0 && n==0) return 0;
        else if(m==0 || nums1==null) return nums2[n/2];
        else if(n==0 || nums2==null) return nums1[m/2];
        if(m>n) return findMedianSortedArrays(nums2, nums1);
        
        double res=0;
        int start=0, end=m;
        int mid = (m+n+1)/2;
        while(start<=end){
            int i=(start+end)/2;
            int j = mid-i;
            System.out.println(i+" "+j);
            // i too small
            if(j>0 && i<m && nums2[j-1]>nums1[i]){
                start = i-1;
            }
            // i too big
            else if(i>0 && j<n && nums1[i-1]>nums2[j]){
                end = i+1;
            }
            // found
            else{
                int max_left, min_right;
                if(i==0) max_left = nums2[j-1];
                else if (j==0) max_left = nums1[i-1];
                else max_left = Math.max(nums1[i-1], nums2[j-1]);
                
                if((m+n)/2==0) res = (double) max_left;
                
                if(i==m) min_right = nums2[j];
                else if(j==n) min_right = nums1[i];
                else min_right = Math.min(nums1[i],nums2[j]);
                
                res = (max_left+min_right)/2.0;
            }
        }
        return res;
    }
}