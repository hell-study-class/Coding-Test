from collections import deque

class Solution:
    def solution(self, n:int, m:int):
        directions = [-1,1,2]
        line = [-1] * 200001
        q = deque()

        line[n] = 0
        q.append(n)
        while q:
            x = q.popleft()
            if x == m:
                return line[x]
            for d in directions:
                if d == 2:
                    cx=2*x
                else:
                    cx = x + d
                if 0 <= cx < 200001 and line[cx] == -1:
                    line[cx] = line[x] +1
                    q.append(cx)

n,m = map(int,input().split())
s = Solution()
print(s.solution(n,m))