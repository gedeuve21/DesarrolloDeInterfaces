import tkinter as tk

root = tk.Tk()
root.title("Actividad 1.3 Tkinter")

seleccion = tk.StringVar()
seleccion.set("No fumador")

tk.Radiobutton(root, text="Fumador", variable=seleccion, value="Fumador").pack(anchor="w")
tk.Radiobutton(root, text="No fumador", variable=seleccion, value="No fumador").pack(anchor="w")

root.mainloop()