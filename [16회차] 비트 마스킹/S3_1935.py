n, ss = int(input()), input()
ns = list(int(input()) for _ in range(n))
alpha_map = {chr(65+i): str(ns[i]) for i in range(n)}
stk = []

for s in ss:
    if s.isalpha():
        stk.append(alpha_map[s])
    else:
        y, x = stk.pop(), stk.pop()
        stk.append(str(eval(x + s + y)))
print('{:.2f}'.format(float(stk[0])))
