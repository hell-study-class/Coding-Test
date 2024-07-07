import sys
import math
from collections import Counter

read = sys.stdin.readline


def sol():
    def mean():
        return round(sum(nums) / len(nums))

    def median():
        if len(nums) % 2 == 0:
            return (nums[len(nums) // 2] + nums[len(nums) // 2 + 1]) / 2
        else:
            return nums[len(nums) // 2]

    def mode():
        num_counter = Counter(nums).most_common(2)
        if len(num_counter) == 2 and num_counter[0][1] == num_counter[1][1]:
            return num_counter[1][0]
        else:
            return num_counter[0][0]

    def _range():
        return nums[-1] - nums[0]

    nums = sorted(list(map(int, [read().rstrip() for _ in range(int(read()))])))
    print(mean())
    print(median())
    print(mode())
    print(_range())


sol()
