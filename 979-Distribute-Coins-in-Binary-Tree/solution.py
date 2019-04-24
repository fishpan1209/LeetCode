# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def distributeCoins(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.res = 0
        self.dfs(root)
        return self.res
    
    def dfs(self, node):
        if not node:
            return 0
        l, r = self.dfs(node.left), self.dfs(node.right)
        self.res += abs(l) + abs(r)
        return node.val + l + r - 1
