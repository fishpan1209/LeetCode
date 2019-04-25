# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        res = []
        def build(node, res):
            if not node:
                res.append('#')
                return
            res.append(str(node.val))
            
            build(node.left, res)
            build(node.right, res)
        build(root, res)
        return ','.join(res)
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def build(nodes):
            val = nodes.pop(0)
            if val == '#':
                return None
            node = TreeNode(int(val))
            node.left = build(nodes)
            node.right = build(nodes)
            return node
            
        nodes = data.split(',')
        return build(nodes)
        
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
