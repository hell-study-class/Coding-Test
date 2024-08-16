n, k = map(int, input().split())
nums = list(map(int, list(input())))
res = []

for num in nums:
    while res and k and res[-1] < num:
        res.pop()
        k -= 1
    res.append(num)
if k:
    res = res[:-k]
print(''.join(map(str, res)))