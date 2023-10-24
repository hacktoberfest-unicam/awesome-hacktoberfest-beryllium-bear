#Calcolatrice in Pyton


print ("Benvenuti al programma calcolatrice!")

print("Di seguito un elenco delle varie funzioni disponibili:")

print("- Per effettuare un' Addizione, seleziona 1;")
print("- Per effettuare una Sottrazione, seleziona 2;")
print("- Per effettuare una Moltiplicazione, seleziona 3;")
print("- Per effettuare una Divisione, seleziona 4;")
print("- Per uscire dal programma puoi digitare ESC;")

while True:

    action = input("Inserisci il numero corrispondete all'operazione da effettuare: ")

    if action == "1":
        print("\nHai scelto: Addizione\n")
        a = float(input("Inserisci il Primo Numero -> "))
        b = float(input("Inserisci il Secondo Numero -> "))
        print("Il risultato dell'Addizione è: "+str(a + b))
        
    elif action == "2":
        print("\nHai scelto: Sottrazione\n")
        a = float(input("Inserisci il Primo Numero -> "))
        b = float(input("Inserisci il Secondo Numero -> "))
        print("Il risultato dell'Sottrazione è: ",str(a - b))
    elif action == "3":
        print("\nHai scelto: Moltiplicazione\n")
        a = float(input("Inserisci il Primo Numero -> "))
        b = float(input("Inserisci il Secondo Numero -> "))
        print("Il risultato dell'Moltiplicazione è: ",str(a * b))
    elif action == "4":
        print("\nHai scelto: Divisione\n")
        a = float(input("Inserisci il Primo Numero -> "))
        b = float(input("Inserisci il Secondo Numero -> "))
        print("Il risultato dell'Divisione è: ",str(a / b))
    

    new_action = input("\nDesideri continuare ad utilizzare l'Applicazione? S/N ")
    if new_action == "S" or new_action == "s":
        print("Sto tornando al menù principale!\n")
        continue
    else:
        print("A presto!\n")
        break
