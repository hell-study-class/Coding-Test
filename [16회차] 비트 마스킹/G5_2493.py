n, ts = int(input()), list(map(int, input().split()))
ts = sorted([(i+1, ts[i]) for i in range(n)], reverse=True)
stk = []
res = [0] * (n + 1)

for t in ts:
    if stk:
        while stk and t[1] > stk[-1][1]:
            x = stk.pop()
            res[x[0]] = t[0]
    stk.append(t)
print(*res[1:])