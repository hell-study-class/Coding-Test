_, ds, ps = int(input()), list(map(int, input().split())), list(map(int, input().split()))
p = ps[0]
r = 0
for i in range(1, len(ps)):
    r += p * ds[i-1]
    p = min(p, ps[i])
print(r)