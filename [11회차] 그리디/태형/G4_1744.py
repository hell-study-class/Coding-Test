def mul(xs: list[int], c0: int = 0):
    ret = sum(x * y for x, y in zip(xs[::2], xs[1::2]))
    if len(xs) % 2 and not c0:
        ret += xs[-1]
    return ret


nums = list(int(input()) for _ in range(int(input())))
s_nums = [[] for _ in range(4)]
res = 0
for num in nums:
    match num:
        case 0:
            s_nums[0].append(num)
        case 1:
            s_nums[1].append(num)
        case n if n > 1:
            s_nums[2].append(num)
        case n if n < 0:
            s_nums[-1].append(num)
s_nums[2].sort(reverse=True)
s_nums[-1].sort()

res += len(s_nums[1]) + mul(s_nums[2]) + mul(s_nums[-1], len(s_nums[0]))
print(res)