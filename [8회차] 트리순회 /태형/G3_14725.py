import sys
from collections import OrderedDict

read = sys.stdin.readline


class Node:
    def __init__(self):
        self.is_end = False
        self.children = OrderedDict()


class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, foods: str):
        node = self.root
        for food in foods:
            if food not in node.children:
                node.children[food] = Node()
            node = node.children[food]
        node.is_end = True

    def dig(self, node: Node, depth: int = 0):
        for child in sorted(node.children.items()):
            print('--' * depth + child[0])
            self.dig(node.children[child[0]], depth + 1)


paths = [read().split()[1:] for _ in range(int(read()))]
trie = Trie()
for path in paths:
    trie.insert(path)
trie.dig(trie.root)