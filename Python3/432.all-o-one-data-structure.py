#
# @lc app=leetcode id=432 lang=python3
#
# [432] All O`one Data Structure
#
class Node:
    def __init__(self, val):
        self.val = val
        self.pre = None
        self.next = None
        self.list = set()
class AllOne:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.values = {}
        self.head, self.tail = Node(-1), Node(-1)
        self.head.next, self.tail.pre = self.tail, self.head
        

    def inc(self, key: str) -> None:
        """
        Inserts a new key <Key> with value 1. Or increments an existing key by 1.
        """
        v = self.values.get(key, 0) + 1
        self.values[key] = v
        self.__delkey(v-1, key)
        self.__addkey(v, key)

    def __delkey(self, num, key):
        if num == 0: return
        node = self.head
        while node and node.val != num:
            node = node.next
        if node:
            node.list.remove(key)
            if len(node.list) == 0:
                node.pre.next = node.next
                node.next.pre = node.pre

    def __addkey(self, num, key):
        if num == 0: return
        node = self.head
        while node and node.val < num:
            node = node.next
        if node and node.val == num:
            node.list.add(key)
        if (node and node.val > num) or not node:
            if not node:
                node = self.tail
            new_node = Node(num)
            new_node.list.add(key)
            node.pre.next = new_node
            new_node.pre = node.pre
            node.pre = new_node
            new_node.next = node

    def dec(self, key: str) -> None:
        """
        Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
        """
        v = self.values.get(key, 0) - 1
        if v >= 0:
            self.values[key] = v
            self.__delkey(v+1, key)
            self.__addkey(v, key)
        

    def getMaxKey(self) -> str:
        """
        Returns one of the keys with maximal value.
        """
        if self.tail.pre is self.head: return ""
        return list(self.tail.pre.list)[0]
        

    def getMinKey(self) -> str:
        """
        Returns one of the keys with Minimal value.
        """
        if self.head.next is self.tail: return ""
        return list(self.head.next.list)[0]


# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()

