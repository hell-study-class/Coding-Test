from typing import List
import sys

sys.setrecursionlimit(int(1e9))


def sol(start_i: int):
    def rec(remainder: List[int], s: int, last_num: int):
        if not remainder:
            global res
            res = max(res, s)
            return
        for num in remainder:
            next = remainder[:]
            next.remove(num)
            rec(next, s + abs(last_num - num), num)
    tmp = nums[:]
    tmp.remove(nums[start_i])
    rec(tmp, 0, nums[start_i])


n = int(input())
nums = list(map(int, input().split()))
res = 0
for i in range(n):
    sol(i)
print(res)