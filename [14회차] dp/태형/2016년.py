def solution(a, b):
    ms = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    dow = ['THU', 'FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED']
    return dow[(sum(ms[:a]) + b) % 7]
