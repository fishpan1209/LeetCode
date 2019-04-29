class Solution(object):
    def isAlienSorted(self, words, order):
        """
        :type words: List[str]
        :type order: str
        :rtype: bool
        """
        if len(words) <= 1:
            return true
        res = True
        
        alphaOrder = {}
        for c, l in enumerate(order):
            alphaOrder[l] = c
            
        for i in xrange(1, len(words)):
            res = res and self.compare(words[i-1], words[i], alphaOrder)
        return res
    
    def compare(self, word1, word2, order):
        i = 0
        while i < min(len(word1), len(word2)):
            if order[word1[i]] < order[word2[i]]:
                return True
            elif order[word1[i]] == order[word2[i]]:
                i += 1
            else:
                print(word1[i], word2[i])
                return False
                          
        return len(word1) <= len(word2)
        
            
