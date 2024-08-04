import sys

read = sys.stdin.readline
sys.setrecursionlimit(int(1e6))

n, m = map(int,read().rstrip().split())

visited = [False] * (n+1)
result = []
line=[]
def dfs():
    if len(line) == m and sorted(line) not in result:
        result.append(sorted(line))
        return
    for i in range(1,n+1):
        if not visited[i]:
            line.append(i)
            visited[i] = True
            dfs()
            line.pop()
            visited[i] = False

dfs()

for i in result:
    for j in i:
        print(j,end=" ")
    print()

# import sys
# import itertools
#
# read = sys.stdin.readline
#
# n, m = map(int, read().rstrip().split())
# tree = [i for i in range(1,n+1)]
#
# result = itertools.combinations(tree,m)
#
# for i in result:
#     for j in i:
#         print(j,end=" ")
#     print()