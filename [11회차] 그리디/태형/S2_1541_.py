op = input()
ex = op.split('-')
res = sum(map(int, ex[0].split('+')))
for p in ex[1:]:
    res -= sum(map(int, p.split('+')))
print(res)