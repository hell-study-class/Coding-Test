import sys

sys.setrecursionlimit(int(1e9))

def sol(idx: int = 0, _s: int = 0):
    global res
    if idx == n:
        return
    if _s + nums[idx] == s:
        res += 1

    sol(idx + 1, _s + nums[idx])
    sol(idx + 1, _s)

n, s = map(int, input().split())
nums = list(map(int, input().split()))
res = 0

sol()
print(res)