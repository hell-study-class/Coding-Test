import sys

sys.setrecursionlimit(int(1e9))
read = sys.stdin.readline


def sol(start, end):
    if start > end:
        return
    root = x[start]
    idx = start + 1
    while idx <= end and x[idx] < root:
        idx += 1
    sol(start + 1, idx - 1)
    sol(idx, end)
    print(root)


x = []
while True:
    try:
        x.append(int(read()))
    except:
        break
sol(0, len(x) - 1)
