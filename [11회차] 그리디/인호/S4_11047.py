n,k = map(int,input().split())
coins = []
for i in range(n):
    coins.append(int(input()))

cnt = 0
for i in coins[::-1]:
    if k == 0:
        break
    cnt+= k//i
    k=k % i

print(cnt)