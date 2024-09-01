import sys
from collections import deque

read = sys.stdin.readline
write = sys.stdout.write


q = deque()
for _ in range(int(read())):
    command = read().split()
    if command[0] == 'push':
        q.append(command[1])
    elif command[0] == 'pop':
        write((q.popleft() if q else '-1') + '\n')
    elif command[0] == 'size':
        write(str(len(q)) + '\n')
    elif command[0] == 'empty':
        write(('0' if q else '1') + '\n')
    elif command[0] == 'front':
        write((q[0] if q else '-1') + '\n')
    elif command[0] == 'back':
        write((q[-1] if q else '-1') + '\n')
