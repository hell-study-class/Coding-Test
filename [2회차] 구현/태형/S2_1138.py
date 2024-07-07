n = int(input())
nums = list(map(int, input().split()))
mapping = {i+1: nums[i] for i in range(len(nums))}
res = [0] * n

for num, cnt in mapping.items():
    mv_cnt = cnt
    idx = 0
    while mv_cnt:
        if 0 < res[idx] < num:
            mv_cnt += 1
        idx += 1
        mv_cnt -= 1
    while res[idx] != 0:
        idx += 1
    res[idx] = num
print(*res)