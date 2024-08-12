n = int(input())
ps = sorted(list(map(int, input().split())))
res = 0

for i in range(n):
    res += ps[i] * (n - i)
print(res)