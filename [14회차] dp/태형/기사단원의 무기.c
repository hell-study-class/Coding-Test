#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int get_prime(int number) {
    int ret = 1;
    for (int i=1;i<number/2+1;i++){
        if(number % i == 0)
            ret++;
    }
    return ret;
}

int solution(int number, int limit, int power) {
    int answer = 0;
    int attack;
    for(int i=1;i<number+1;i++) {
        attack = get_prime(i);
        if (attack > limit)
            answer += power;
        else
            answer += attack;
    }
    return answer;
}

