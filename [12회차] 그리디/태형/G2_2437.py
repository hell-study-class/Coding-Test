n, ws = int(input()), sorted(list(map(int, input().split())))
res = 1
for w in ws:
    if w > res:
        break
    res += w
print(res)