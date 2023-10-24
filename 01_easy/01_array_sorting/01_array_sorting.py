# array of integer

num = input("quanti elementii vuoi nell'array? ")
array = []
for i in range(0, int(num)):
    array.append(int(input("inserisci un numero: ")))

mod = input("vuoi ordinare l'array in ordine crescente o decrescente? ")
if mod == "crescente":
    array.sort()
    print(array)
elif mod == "decrescente":
    array.sort(reverse=True)
    print(array)
