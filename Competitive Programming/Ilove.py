n, d = input().split()

if int(n[len(n)-1]) > int(d):
    print((int(n) + 10) - (int(n[len(n)-1]) - int(d)))
elif int(n[len(n)-1]) < int(d):
    print(int(n) + (int(d) - int(n[len(n) - 1])))
else:
    print(int(n) + 10)