ss, c = input(), 0
f, r = ss[0], 0
for s in ss:
    if f != s:
        c += 1
        f = s
        if not c % 2:
            r += 1
print(r + 1 if c&1 else r)