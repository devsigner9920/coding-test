def count_num(n, num):
    count = 0
    div_num = num
    while n >= div_num:
        count = count + (n // div_num)
        div_num = div_num * num

    return count


M, N = map(int, input().split())
print(min(count_num(M, 5) - count_num(N, 5) - count_num(M-N, 5), count_num(M, 2) - count_num(N, 2) - count_num(M-N, 2)))
