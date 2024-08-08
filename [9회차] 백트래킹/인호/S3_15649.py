# import itertools
# import sys
#
# read = sys.stdin.readline
#
# n,m = map(int, read().rstrip().split())
# line = [i for i in range(1,n+1)]
#
# result = itertools.permutations(line,m)
#
# for i in result:
#     for j in i:
#         print(j,end=' ')
#     print()

import sys

sys.setrecursionlimit(int(1e6))
read = sys.stdin.readline

n,m =map(int,read().rstrip().split())
s= []
visited = [False] * (n+1)

def dfs():
    if len(s) == m:
        print(' '.join(map(str,s)))
    for i in range(1,n+1):
        if visited[i]:
            continue
        visited[i] = True
        s.append(i)
        dfs()
        s.pop()
        visited[i] = False
dfs()
