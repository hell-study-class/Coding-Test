import sys
from typing import List

read = sys.stdin.readline


class Node:
    def __init__(self):
        self.is_end = False
        self.children = {}


class Trie:
    def __init__(self):
        self.head = Node()

    def insert(self, path: List[str]):
        node = self.head
        for dir_name in path:
            if dir_name not in node.children:
                node.children[dir_name] = Node()
            node = node.children[dir_name]
        node.is_end = True

    def dig(self, node: Node, depth: int = 0):
        for child in sorted(node.children.keys()):
            print(' ' * depth + child)
            self.dig(node.children[child], depth + 1)

paths = [read().rstrip().split('\\') for _ in range(int(read()))]
trie = Trie()
for path in paths:
    trie.insert(path)
trie.dig(trie.head)