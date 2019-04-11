class Solution(object):
    def sortedSquares(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        i, j = 0, len(A)-1
        while i < j:
            if A[i]*A[i] < A[j]*A[j]:
                j -= 1
            else:
                i += 1
        print(i, j)
        res = []
        while i >= 0 and j < len(A):
            if i == j:
                res.append(A[i]*A[i])
                i -= 1
                j += 1
            elif A[i]*A[i] < A[j]*A[j]:
                res.append(A[i]*A[i])
                i -= 1
            else:
                res.append(A[j]*A[j])
                j += 1
        while i >= 0:
            res.append(A[i]*A[i])
            i -= 1
        while j < len(A):
            res.append(A[j]*A[j])
            j += 1
        return res
 
