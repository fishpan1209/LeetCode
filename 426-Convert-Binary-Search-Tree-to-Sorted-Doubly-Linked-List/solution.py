"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right
"""
class Solution(object):
    def treeToDoublyList(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if not root:
            return None
        head, tail = self.helper(root)
        return head
    
    def helper(self, root):
        head, tail = root, root
        if root.left:
            lh, lt = self.helper(root.left)
            lt.right = root
            root.left = lt
            head = lh
        if root.right:
            rh, rt = self.helper(root.right)
            rh.left = root
            root.right = rh
            tail = rt
        head.left = tail
        tail.right = head
        return head, tail
        
