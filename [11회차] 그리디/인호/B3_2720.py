c = int(input())
res = []
for _ in range(c):
    m = int(input())
    line = []
    for i in (25,10,5,1):
        line.append(m//i)
        m= m%i
    res.append(line.copy())

for i in res:
    for j in i:
        print(j,end=" ")
    print()