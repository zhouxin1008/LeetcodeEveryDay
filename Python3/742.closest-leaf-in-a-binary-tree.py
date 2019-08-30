import collections
class Solution:
    def findClosestLeaf(self, root: TreeNode, k: int) -> int:
        def build(node, parent):
            if not node: return 
            if node.val == k:
                start = node
            if parent:
                map[parent].append(node)
                map[node].append(parent)

            build(node.left, node)
            build(node.right, node)

        map = collections.defaultdict(list)
        start = None
        build(root, None)
        q, seen = [start], set()
        while len(q) > 0:
            node = q.pop(0)
            if node not in seen:
                if not node.left and not node.right:
                    return node.val
                for n in map[node]:
                    q.append(n)
