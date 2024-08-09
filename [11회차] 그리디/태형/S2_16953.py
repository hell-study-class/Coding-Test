a, b = map(int, input().split())
r = 1
while b >= a:
    if b == a:
        print(r)
        break
    b_s = str(b)
    if b_s[-1] == '1':
        b = int(b_s[:-1])
    elif not b % 2:
        b //= 2
    else:
        print(-1)
        break
    r += 1
else:
    print(-1)
