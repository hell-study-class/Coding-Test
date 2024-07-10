from collections import deque, defaultdict

n, k = map(int, input().split())
visited = [0] * 100_001
q = deque([n])
visited[n] = 1
cnt = 0

while q:
    iter_cnt = len(q)
    x = q.popleft()
    if x == k:
        cnt += 1
    for i in (x-1, x+1, x*2):
        if -1 < i < 100_001:
            if not visited[i] or visited[i] == visited[x] + 1:
                visited[i] = visited[x] + 1
                q.append(i)

print(visited[k]-1)
print(cnt if n != k else 1)