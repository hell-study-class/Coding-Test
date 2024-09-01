from collections import deque
import sys

read = sys.stdin.readline

q = deque()

for _ in range(int(read())):
    commands = read().split()
    x = 0
    if len(commands) > 1:
        x = int(commands[1])

    if commands[0] == 'push':
        q.append(x)
    elif commands[0] == 'pop':
        if q:
            print(q[0])
            q.popleft()
        else:
            print(-1)
    elif commands[0] == 'size':
        print(len(q))
    elif commands[0] == 'empty':
        print(0 if q else 1)
    elif commands[0] == 'front':
        print(q[0] if q else -1)
    elif commands[0] == 'back':
        print(q[-1] if q else -1)