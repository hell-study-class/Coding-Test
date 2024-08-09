T = int(input())
ts = [300, 60, 10]
res = [0] * 3
for i in range(3):
    res[i], T = divmod(T, ts[i])
if T:
    print(-1)
else:
    print(*res)