import customtkinter as ctk

# Ventana principal
class ventanaPrincipal(ctk.CTk):
    def __init__(self):
        super().__init__()

        # Configuración de la ventana principal
        self.title("QoS")
        self.geometry("800x500")
        self.resizable(False, False)

        # Crear widgets
        self.crear_widgets()

    def crear_widgets(self):
        # Título centrado
        titulo = ctk.CTkLabel(self, text="Ventana Principal", font=("Arial", 24, "bold"))
        titulo.pack(pady=30)

        # Aquí abajo poner los botones para navegar por las interfaces