from collections import defaultdict


def is_valid(items):
    cnt = 0
    for k, v in items:
        if v % 2:
            cnt += 1
    return cnt < 2


name = input()
res = [''] * len(name)
alphabet = defaultdict(int)
for c in name:
    alphabet[c] += 1
sorted_alphabet = sorted(alphabet.items(), key=lambda x: x[0])
if is_valid(sorted_alphabet):
    idx = 0
    for k, v in sorted_alphabet:
        if v % 2:
            res[len(res) // 2] = k
            v -= 1
        for _ in range(0, v, 2):
            res[idx] = k
            res[len(res) - idx - 1] = k
            idx += 1
    print(''.join(res))
else:
    print("I'm Sorry Hansoo")
