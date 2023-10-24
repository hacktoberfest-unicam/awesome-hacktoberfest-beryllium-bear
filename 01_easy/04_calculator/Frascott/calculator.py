"""DEFINIZIONE DELLE OPERAZIONI"""
def add(x, y):
    return x + y

def subtract(x, y):
    return x - y

def multiply(x, y):
    return x * y

def divide(x, y):
    if y == 0:
        return "Error: hai diviso per 0, torna alle elementari!"
    return x / y


#un main in loop finché l'utente non decide di uscire
while True:
    #menu
    print("Operazioni:")
    print("Scrivi 'add' per l'addizione")
    print("Scrivi 'subtract' per la sottrazione")
    print("Scrivi 'multiply' per la moltiplicazione")
    print("Scrivi 'divide' per la divisione")
    print("Scrivi 'exit' per terminare il programma")

    user_input = input(": ")

    if user_input == "exit":#se inserisce exit, allora il programma termina
        break
    elif user_input in ("add", "subtract", "multiply", "divide"):
        #inserimento dei numeri
        num1 = float(input("inserisci il primo numero: "))
        num2 = float(input("inserisci il secondo numero: "))

        #switch dei case
        if user_input == "add":
            print("Result:", add(num1, num2))
        elif user_input == "subtract":
            print("Result:", subtract(num1, num2))
        elif user_input == "multiply":
            print("Result:", multiply(num1, num2))
        elif user_input == "divide":
            print("Result:", divide(num1, num2))
    else:
        print("Per favore inserisci un'operazione valida")
