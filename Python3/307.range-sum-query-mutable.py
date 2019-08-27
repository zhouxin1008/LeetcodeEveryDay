#
# @lc app=leetcode id=307 lang=python3
#
# [307] Range Sum Query - Mutable
#
class SegmentTreeNode:
        def __init__(self, sum: int, range_left: int, range_right: int):
            self.sum = sum
            self.range_left = range_left
            self.range_right = range_right
            self.child_left = None
            self.child_right = None

class NumArray:

    def _buildTree(self, range_left: int, range_right: int, nums: List[int]) -> SegmentTreeNode:
        if range_left == range_right:
            return SegmentTreeNode(nums[range_left], range_left, range_right)
        mid = (range_left + range_right) // 2
        child_left, child_right = self._buildTree(range_left, mid, nums), self._buildTree(mid+1, range_right, nums)
        root = SegmentTreeNode(child_left.sum + child_right.sum, range_left, range_right)
        root.child_left = child_left
        root.child_right = child_right
        return root

    def __init__(self, nums: List[int]):
        if not nums or len(nums) == 0:
            self._root = None
        else:
            self._root = self._buildTree(0, len(nums)-1, nums)

    def update(self, i: int, val: int) -> None:
        def doUpdate(root: SegmentTreeNode, i: int, val: int):
            if root.range_left == i and root.range_right == i:
                root.sum = val
                return
            mid = (root.range_left + root.range_right) // 2
            if i <= mid:
                doUpdate(root.child_left, i, val)
            else:
                doUpdate(root.child_right, i, val)
            root.sum = root.child_left.sum + root.child_right.sum
        doUpdate(self._root, i, val)

    def sumRange(self, i: int, j: int) -> int:
        def getSum(root: SegmentTreeNode, i: int, j: int): 
            if not root: return 0
            if root.range_left == i and root.range_right == j:
                return root.sum
            mid = (root.range_left + root.range_right) // 2
            if j <= mid:
                return getSum(root.child_left, i, j)
            elif i > mid:
                return getSum(root.child_right, i, j)
            else:
                return getSum(root.child_left, i, mid) + getSum(root.child_right, mid+1, j)
        return getSum(self._root, i, j)
        


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)

