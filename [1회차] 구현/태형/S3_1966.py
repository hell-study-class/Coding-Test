import sys
from collections import deque
read = sys.stdin.readline

def sol():
    priorities = [0] * 10
    n, m = map(int, read().split())
    q = deque(enumerate(list(map(int, read().split()))))
    for doc in q:
        priorities[doc[1]] += 1

    print_cnt = 0
    for i in range(9, 0, -1):
        cur_priority = priorities[i]
        if cur_priority != 0:
            while cur_priority != 0:
                while q[0][1] != i:
                    q.rotate(-1)
                print_cnt += 1
                x = q.popleft()
                if x[0] == m:
                    return print_cnt
                cur_priority -= 1


res = [str(sol()) for _ in range(int(read()))]
print('\n'.join(res))
