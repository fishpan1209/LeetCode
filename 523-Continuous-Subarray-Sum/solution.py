class Solution(object):
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if len(nums) < 2:
            return False
        if k == 0:
            for i in xrange(len(nums)-1):
                if nums[i] == 0 and nums[i+1] == 0:
                    return True
            return False
        
        conSum = 0
        res = {}
        res[0] = -1
        for i in xrange(len(nums)):
            conSum += nums[i]
            conSum = conSum % k
            if conSum in res:
                if i - res[conSum] > 1:
                    return True
            else:
                res[conSum] = i

        return False
