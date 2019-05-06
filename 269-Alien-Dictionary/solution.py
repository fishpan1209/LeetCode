class Solution(object):
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        #find order pair, eg: tf, we
        orderPair = []
        for i in xrange(1, len(words)):
            w1 = words[i-1]
            w2 = words[i]
            l = min(len(w1), len(w2))
            
            for j in xrange(l):
                if w1[j] != w2[j]:
                    orderPair.append(w1[j]+w2[j])
                    break
        
        # get all distinct chars appeared in words
        allChars = set(''.join(words))
        res = []
        while orderPair:
            # get the first char that does not have a predecessor
            first = allChars - {p[1] for p in orderPair}
            if not first:
                return ''
            
            res.extend(first)
            allChars -= first
            # remove all pairs that contains the first char found
            orderPair = [pair for pair in orderPair if first.isdisjoint(pair)]
        
        return ''.join(res + list(allChars))
