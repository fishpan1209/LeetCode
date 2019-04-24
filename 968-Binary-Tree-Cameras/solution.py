# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minCameraCover(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        """
        if node is leaf, there should be a camera at it's parent, return 0
        if node itself, set a camera, return 1
        if node is a parent, it's already covered, return 2
        """
        self.res = 0
        return (self.dfs(root) == 0) + self.res
        
    def dfs(self, node):
        if not node:
            return 2
        l, r = self.dfs(node.left), self.dfs(node.right)
        if l == 0 or r == 0:
            self.res += 1
            return 1
        return 2 if l == 1 or r == 1 else 0
    
