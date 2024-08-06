# import sys
# import itertools
# read = sys.stdin.readline
#
# n = int(read().rstrip())
# graph = []
# num = []
# joined = [False] * (n+1)
#
# for i in range(n):
#     graph.append(list(map(int, read().rstrip().split())))
#
# for i in range(1,n+1):
#     num.append(i)
#
# teams = list(itertools.combinations(num,int(n/2)))
#
# def points(t):
#     point = 0
#     for i in t:
#         for j in t:
#             if i != j:
#                 point+= graph[i-1][j-1]
#     return point
#
# def cal_min():
#     minn = 99999
#     for i in range(int(len(teams)/2)):
#         minn =min(minn,abs(points(teams[i])-points(teams[-(i+1)])))
#
#     return minn
# print(cal_min())

import sys
read = sys.stdin.readline
n = int(read())
graph = [list(map(int,read().split())) for _ in range(n)]
joined = [False for _ in range(n)]
INF = 2147000000
res = INF
def dfs(l,idx):
    global res
    if l == n/2:
        a=0
        b=0
        for i in range(n):
            for j in range(n):
                if joined[i] and joined[j]:
                    a+=graph[i][j]
                elif not joined[i] and not joined[j]:
                    b+=graph[i][j]
        res = min(res, abs(a-b))
        return
    for i in range(idx,n):
        if not joined[i]:
            joined[i] = True
            dfs(l+1,i+1)
            joined[i] = False
dfs(0,0)
print(res)
