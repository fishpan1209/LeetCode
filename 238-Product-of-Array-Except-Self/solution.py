class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [1]*len(nums)
        for i in xrange(1, len(res)):
            res[i] = (res[i-1] * nums[i-1])
        right = 1
        for j in xrange(len(nums)-1, -1, -1):
            res[j] *= right
            right *= nums[j]
        return res
            
