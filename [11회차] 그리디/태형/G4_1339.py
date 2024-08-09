n = int(input())
nums = [list(list(input().rstrip())) for _ in range(n)]
maps = {chr(65 + i): 0 for i in range(26)}
res = 0
for num in nums:
    digit = 1
    for alpha in num[::-1]:
        maps[alpha] += digit
        digit *= 10
idx = 9
for v in sorted(maps.values(), reverse=True):
    res += idx * v
    idx -= 1
print(res)