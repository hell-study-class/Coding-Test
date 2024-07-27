import sys

sys.setrecursionlimit(int(1e6))
read = sys.stdin.readline

def deleteNode(start):
    parent[start] = -10
    for i in range(n):
        if parent[i] == start:
            deleteNode(i)

n = int(read().rstrip())
parent = list(map(int,read().rstrip().split()))
delete = int(read().rstrip())

deleteNode(delete)
cnt=0
for i in range(n):
    if parent[i] != -10 and i not in parent:
        cnt+=1
print(cnt)