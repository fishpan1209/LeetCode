class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        subSum, res = 0, 0
        preSum = {}
        preSum[0] = 1
        
        for i in xrange(0, len(nums)):
            subSum += nums[i]
            if subSum - k in preSum:
                res += preSum[subSum - k]
            preSum[subSum] = preSum.get(subSum, 0) + 1
        
        return res
            
