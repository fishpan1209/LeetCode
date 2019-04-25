class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        self.res = []
        self.remove(s, 0, 0, ['(', ')'])
        return self.res
    
    def remove(self, s, left, right, pair):
        count = 0
        for i in xrange(left, len(s)):
            if s[i] == pair[0]:
                count += 1
            if s[i] == pair[1]:
                count -= 1
            if count >= 0:
                continue
            for j in xrange(right, i+1):
                if s[j] == pair[1] and (j == right or s[j-1] != pair[1]):
                    self.remove(s[0:j]+s[j+1:], i, j, pair)
            return
        reverseds = s[::-1]
        if pair[0] == '(':
            self.remove(reverseds, 0, 0, [')', '('])
        else:
            self.res.append(reverseds)
