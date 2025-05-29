Sistema de Gestión de Biblioteca Personal

Este es un proyecto web desarrollado con Java + Vaadin + Spring Boot, orientado a la gestión de una biblioteca personal con funcionalidades completas como registro, préstamos, modificación, eliminación y visualización de estadísticas.

---

Características principales

- Registro de libros con: título, autor, año, género y estado (disponible/prestado).
- Modificación y eliminación de libros.
- Búsqueda parcial por título y autor.
- Filtrado por género y estado.
- Registro de préstamos con fecha y persona.
- Visualización de estadísticas: totales, por género y por disponibilidad.
- Almacenamiento de datos en archivos `.txt`.

---

Estructura del proyecto

- `src/main/java/com/example/Biblioteca` → Clases del modelo, lógica y vistas (Vaadin).
- `src/main/resources/data/` → Archivos de texto persistentes:
  - `libros.txt` 
  - `prestamos.txt` 
  - `estadisticas.txt` 
- `styles.css` → Estilos personalizados para las vistas.

---

Persistencia de datos

- Los libros y préstamos se guardan y leen desde archivos `.txt`.
- Las estadísticas se generan y sobrescriben al entrar a la vista de estadísticas.
- Se utiliza únicamente: `File`, `FileReader`, `BufferedReader`, `FileWriter` y `PrintWriter`.

---

Requisitos del sistema

- Java 17 o superior
- Maven
- Navegador web moderno