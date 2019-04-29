class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        carry = 0
        res = []
        i, j = len(a) -1, len(b) - 1
        while i >= 0 or j >= 0:
            temp = carry
            if i >= 0:
                temp += int(a[i])
                i -= 1
            if j >= 0:
                temp += int(b[j])
                j -= 1
            carry = temp / 2
            res.insert(0, str(temp % 2))
        
        if carry > 0:
            res.insert(0, str(carry))
        
        return ''.join(res)
            
