#FeeeDz
import tkinter as tk

def calculate():
    operation = operation_var.get()
    num1 = float(entry_num1.get())
    num2 = float(entry_num2.get())
    
    if operation == "1":
        result = num1 + num2
    elif operation == "2":
        result = num1 - num2
    elif operation == "3":
        result = num1 * num2
    elif operation == "4":
        if num2 == 0:
            result_label.config(text="Errore: divisione per 0")
            return
        result = num1 / num2
    else:
        result_label.config(text="Errore: operazione non valida")
        return
    
    result_label.config(text=f"Risultato: {result}")

# Creare una finestra principale
window = tk.Tk()
window.title("Calcolatore")

# Menu a discesa per selezionare l'operazione
operation_label = tk.Label(window, text="Seleziona l'operazione:")
operation_label.pack()
operation_var = tk.StringVar()
operation_var.set("1")  # Imposta la somma come operazione predefinita
operation_menu = tk.OptionMenu(window, operation_var, "1", "2", "3", "4")
operation_menu.pack()

# Inserimento dei numeri
entry_num1_label = tk.Label(window, text="Inserisci il primo numero:")
entry_num1_label.pack()
entry_num1 = tk.Entry(window)
entry_num1.pack()

entry_num2_label = tk.Label(window, text="Inserisci il secondo numero:")
entry_num2_label.pack()
entry_num2 = tk.Entry(window)
entry_num2.pack()

# Pulsante per calcolare
calculate_button = tk.Button(window, text="Calcola", command=calculate)
calculate_button.pack()

# Etichetta per visualizzare il risultato
result_label = tk.Label(window, text="Risultato: ")
result_label.pack()

window.mainloop()
