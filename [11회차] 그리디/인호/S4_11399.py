n = int(input())
p = sorted(list(map(int,input().split())))
time = 0
res = []
for i in p:
    time+=i
    res.append(time)
print(sum(res))
