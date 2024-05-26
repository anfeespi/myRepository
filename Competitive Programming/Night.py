n = int(input())
t = 0
ini = 3
sum = 3
r = n

while r >= 3:
    while True:
        if r - ini >= 0:
            t = t + 1
            r = r - ini
            ini = ini + sum
            sum = sum + 1
        else:
            ini = 3
            sum = 3
            break

print(t,  r)