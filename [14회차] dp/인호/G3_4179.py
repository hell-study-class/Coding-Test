from typing import List
from collections import deque

class Solution:
    def solution(self, n:int, m:int, maps:List[List[str]]):
        directions = [(1,0),(0,1),(-1,0),(0,-1)]
        fire_times = [[-1] * m for _ in range(n)]
        jihun_times = [[-1] * m for _ in range(n)]
        q = deque();

        for i in range(n):
            for j in range(m):
                if maps[i][j] == "F":
                    fire_times[i][j] = 0
                    q.append([i,j])
                    break
        while q:
            x,y = q.popleft()
            for dx,dy in directions:
                cx,cy = x+dx, y+dy
                if 0 <= cx < n and 0<=cy<m and maps[cx][cy] == '.' and fire_times[cx][cy]==-1:
                    fire_times[cx][cy] = fire_times[x][y] +1
                    q.append([cx,cy])

        for i in range(n):
            for j in range(m):
                if maps[i][j] == 'J':
                    jihun_times[i][j] = 0
                    q.append([i,j])
                    break
        while q:
            x,y = q.popleft()
            for dx,dy in directions:
                cx,cy = x+dx, y+dy
                if cx<0 or cx>=n or cy<0 or cy>=m:
                    return jihun_times[x][y] + 1
                if maps[cx][cy] == '.' and jihun_times[cx][cy] == -1:
                    if fire_times[cx][cy] == -1 or fire_times[cx][cy] > jihun_times[x][y] +1 :
                        jihun_times[cx][cy] = jihun_times[x][y] +1
                        q.append([cx,cy])
        return "IMPOSSIBLE"

n ,m = map(int, input().split())
maps_input = list(input() for _ in range(n))
maps = []
for ss in maps_input:
    line = []
    for s in ss:
        line.append(s)
    maps.append(line)
s = Solution()
print(s.solution(n,m,maps))

