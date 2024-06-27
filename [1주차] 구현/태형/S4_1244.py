import sys

read = sys.stdin.readline


def toggle(switch_num):
    switches[switch_num] = 1 if not switches[switch_num] else 0


def boy(my_num):
    for switch_num in range(1, n + 1):
        if switch_num % my_num == 0:
            toggle(switch_num)


def girl(my_num):
    toggle(my_num)
    idx = 1
    while my_num + idx <= n and \
            0 < my_num - idx and \
            switches[my_num + idx] == switches[my_num - idx]:
        toggle(my_num+idx); toggle(my_num-idx)
        idx += 1

n = int(read())
switches = [0] + list(map(int, read().split()))
students = [tuple(map(int, read().split())) for _ in range(int(read()))]
for student in students:
    gender, switch_num = student
    if gender == 1:
        boy(switch_num)
    elif gender == 2:
        girl(switch_num)

cnt = 0
for switch in switches[1:]:
    print(switch, end=' ')
    cnt += 1
    if cnt >= 20:
        print()
        cnt = 0