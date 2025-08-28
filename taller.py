# Definimos la clase Libro (molde para crear libros)
class Libro:
    # Constructor para inicializar un libro con sus atributos
    def __init__(self, titulo, autor, anio, disponible):
        self.titulo = titulo        # Atributo: título del libro
        self.autor = autor          # Atributo: autor del libro
        self.anio = anio            # Atributo: año de publicación
        self.disponible = disponible  # Atributo: disponibilidad (True o False)

    # Método para prestar un libro (cambia disponibilidad a False)
    def prestar(self):
        self.disponible = False
        print(f"El libro '{self.titulo}' ha sido prestado.")

    # Método para devolver un libro (cambia disponibilidad a True)
    def devolver(self):
        self.disponible = True
        print(f"El libro '{self.titulo}' ha sido devuelto.")


# Definimos la clase Usuario (molde para crear usuarios)
class Usuario:
    # Constructor para inicializar un usuario con sus atributos
    def __init__(self, nombre, id_usuario):
        self.nombre = nombre          # Atributo: nombre del usuario
        self.id_usuario = id_usuario  # Atributo: identificador del usuario

    # Método para que el usuario tome un libro
    def tomar_libro(self, libro):
        libro.prestar()  # Llama al método prestar() de la clase Libro
        print(f"{self.nombre} tomó el libro '{libro.titulo}'.")

    # Método para que el usuario devuelva un libro
    def devolver_libro(self, libro):
        libro.devolver()  # Llama al método devolver() de la clase Libro
        print(f"{self.nombre} devolvió el libro '{libro.titulo}'.")


# Definimos la clase Biblioteca (molde para crear bibliotecas)
class Biblioteca:
    # Constructor para inicializar una biblioteca con sus atributos
    def __init__(self, nombre):
        self.nombre = nombre          # Atributo: nombre de la biblioteca
        self.lista_libros = []        # Atributo: lista de libros
        self.lista_usuarios = []      # Atributo: lista de usuarios

    # Método para registrar un usuario en la biblioteca
    def registrar_usuario(self, usuario):
        self.lista_usuarios.append(usuario)  # Agrega el usuario a la lista
        print(f"Usuario '{usuario.nombre}' registrado en la biblioteca.")

    # Método para agregar un libro a la biblioteca
    def agregar_libro(self, libro):
        self.lista_libros.append(libro)  # Agrega el libro a la lista
        print(f"Libro '{libro.titulo}' agregado a la biblioteca.")

    # Método para buscar un libro por título
    def buscar_libro(self, titulo):
        for libro in self.lista_libros:  # Recorre la lista de libros
            if libro.titulo == titulo:   # Compara títulos
                return libro             # Devuelve el libro si lo encuentra
        return None                      # Devuelve None si no lo encuentra


# ------------------ PROGRAMA PRINCIPAL ------------------

# Creamos un objeto de tipo Biblioteca
biblioteca = Biblioteca("Biblioteca Central")

# Creamos un objeto de tipo Libro
libro1 = Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, True)

# Creamos un objeto de tipo Usuario
usuario1 = Usuario("Andrés", 101)

# Agregamos el libro a la biblioteca
biblioteca.agregar_libro(libro1)

# Registramos al usuario en la biblioteca
biblioteca.registrar_usuario(usuario1)

# El usuario toma el libro
usuario1.tomar_libro(libro1)

# El usuario devuelve el libro
usuario1.devolver_libro(libro1)

# Mensaje final
print("Fin del programa en Python. Ejemplo de Biblioteca.")
