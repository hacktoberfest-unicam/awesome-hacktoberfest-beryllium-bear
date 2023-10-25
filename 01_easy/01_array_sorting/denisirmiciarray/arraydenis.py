a1 = [100, 1000, -1111, -1.3, -3, 100032]

for i in range(0, len(a1)):
    for k in range(i+1, len(a1)):
        if(a1[i]>=a1[k]):
            a1[i], a1[k]=a1[k], a1[i]

print("Array sortato",a1)
