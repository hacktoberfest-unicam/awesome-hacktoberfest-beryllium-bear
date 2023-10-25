import tkinter as tk
import math

def button_click(number):
    current = entry.get()
    entry.delete(0, tk.END)
    entry.insert(0, current + number)

def clear():
    entry.delete(0, tk.END)

def calculate():
    current = entry.get()
    try:
        result = str(eval(current))
        entry.delete(0, tk.END)
        entry.insert(0, result)
    except Exception as e:
        entry.delete(0, tk.END)
        entry.insert(0, "Error")

def square_root():
    current = entry.get()
    try:
        result = math.sqrt(float(current))
        entry.delete(0, tk.END)
        entry.insert(0, result)
    except ValueError:
        entry.delete(0, tk.END)
        entry.insert(0, "Error")

def power():
    current = entry.get()
    entry.delete(0, tk.END)
    entry.insert(0, current + "**")

window = tk.Tk()
window.title("Calculator")

entry = tk.Entry(window, width=20, font=("Arial", 20))
entry.grid(row=0, column=0, columnspan=4)

buttons = [
    '7', '8', '9', '/',
    '4', '5', '6', '*',
    '1', '2', '3', '-',
    '0', '.', '=', '+',
    'sqrt', 'x^y'  
]

row_val = 1
col_val = 0

for button in buttons:
    if button == 'sqrt':
        tk.Button(window, text="√", padx=20, pady=20, font=("Arial", 15), command=square_root).grid(row=row_val, column=col_val)
    elif button == 'x^y':
        tk.Button(window, text="x^y", padx=20, pady=20, font=("Arial", 15), command=power).grid(row=row_val, column=col_val)
    else:
        tk.Button(window, text=button, padx=20, pady=20, font=("Arial", 15),
                  command=lambda button=button: button_click(button) if button != '=' else calculate()).grid(row=row_val, column=col_val)
    
    col_val += 1
    if col_val > 3:
        col_val = 0
        row_val += 1

clear_button = tk.Button(window, text="C", padx=20, pady=20, font=("Arial", 15), command=clear)
clear_button.grid(row=row_val, column=col_val)

window.mainloop()