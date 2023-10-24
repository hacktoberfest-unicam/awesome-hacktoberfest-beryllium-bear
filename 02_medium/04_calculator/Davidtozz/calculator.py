import tkinter as tk

#! Handles button click
def on_button_click(event):
    text = event.widget.cget("text")
    if text == "=":
        try:
            result = str(eval(entry.get()))
            entry.delete(0, tk.END)
            entry.insert(tk.END, result)
        except Exception as e:
            entry.delete(0, tk.END)
            entry.insert(tk.END, "Error")
    elif text == "C":
        entry.delete(0, tk.END)
    else:
        entry.insert(tk.END, text)

#! create instante of window
root = tk.Tk()
root.title("Calculator")

entry = tk.Entry(root, width=25, font=('Arial', 16))
entry.grid(row=0, column=0, columnspan=4)

button_texts = [
    '7', '8', '9', '/',
    '4', '5', '6', '*',
    '1', '2', '3', '-',
    'C', '0', '=', '+',
]

row, col = 1, 0
for button_text in button_texts:
    button = tk.Button(root, text=button_text, width=5, height=2, font=('Arial', 16))
    button.grid(row=row, column=col)
    button.bind("<Button-1>", on_button_click)
    col += 1
    if col > 3:
        col = 0
        row += 1

root.mainloop()
