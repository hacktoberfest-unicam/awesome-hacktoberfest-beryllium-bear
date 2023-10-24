#04 calculator
#FeeeDz
mod = input("Cosa vuoi fare?\n1. somma\n2. sottrazione\n3. moltiplicazione\n4. divisione ")

if mod == "1":
    n = int(input("Quanti numeri vuoi sommare? "))
    somma = 0
    for i in range(0, n):
        somma += int(input("Inserisci un numero: "))
    print(somma)
elif mod == "2":
    n = int(input("Quanti numeri vuoi sottrarre? "))
    sottrazione = int(input("Inserisci il primo numero: "))
    for i in range(1, n):
        sottrazione -= int(input("Inserisci un numero: "))
    print(sottrazione)
elif mod == "3":
    n = int(input("Quanti numeri vuoi sottrarre? "))
    molt = int(input("Inserisci il primo numero: "))
    for i in range(1, n):
        molt *= int(input("Inserisci un numero: "))
    print(molt)
elif mod == "4":
    a = int(input("Inserisci il primo numero: "))
    b = int(input("Inserisci il secondo numero: "))
    if b == 0:
        print("Errore: divisione per 0")
    else:
        print(a / b)
else:
    print("Errore: scelta non valida")
