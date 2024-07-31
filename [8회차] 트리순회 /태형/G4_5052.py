import sys
from typing import List

read = sys.stdin.readline


class Node:
    def __init__(self):
        self.is_end = False
        self.child = {}


class Trie:
    def __init__(self):
        self.head = Node()

    def insert(self, word: str):
        current = self.head
        for char in word:
            if char not in current.child:
                current.child[char] = Node()
            elif current.child[char].is_end:
                return False
            current = current.child[char]
        current.is_end = True
        return False if current.child else True


def sol(words: List[str]):
    trie = Trie()
    for word in words:
        if not trie.insert(word):
            return 'NO'
    return 'YES'


for T in range(int(read())):
    print(sol([read().rstrip() for _ in range(int(read()))]))
