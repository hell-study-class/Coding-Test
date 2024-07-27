import sys

sys.setrecursionlimit(int(1e6))
read = sys.stdin.readline

def preorder(v):
    if v != '.':
        print(v,end="")
        preorder(tree[v][0])
        preorder(tree[v][1])

def inorder(v):
    if v !='.':
        inorder(tree[v][0])
        print(v,end="")
        inorder(tree[v][1])

def postorder(v):
    if v != '.':
        postorder(tree[v][0])
        postorder(tree[v][1])
        print(v,end="")

n = int(read().rstrip())
tree = {}
for _ in range(n):
    root, left, right = map(str,read().rstrip().split())
    tree[root] = [left,right]

first = next(iter(tree))
preorder(first)
print()
inorder(first)
print()
postorder(first)

