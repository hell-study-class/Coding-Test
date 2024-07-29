import sys
from collections import deque

sys.setrecursionlimit(int(1e6))
read = sys.stdin.readline

n = int(read().rstrip())

tree = {i:{} for i in range(1,2**(n+1))}
dp = [[0,0] for i in range(2**(n+1))]

line = deque(list(map(int,read().rstrip().split())))

for i in range(1,2**n):
    tree[i][2*i] = line.popleft()
    tree[i][2*i+1] = line.popleft()


def dfs(x, s):
    if x == n-1:
        maxx = max(tree[s][s*2],tree[s][s*2+1])
        dp[s] = [maxx, 2*maxx]
        return [maxx,2*maxx]
    else:
        dp[s][0] = max(tree[s][s*2] + dfs(x+1,s*2)[0],
                       tree[s][s*2+1] + dfs(x+1,s*2+1)[0])
        dp[s][1] = dp[s*2][1] + dp[s*2+1][1]+ dp[s][0] - dp[s*2][0] +dp[s][0] - dp[s*2+1][0]
        return dp[s]

print(dfs(0,1)[1])