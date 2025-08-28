// Definimos la clase Libro (molde para crear libros)
public class Libro {
    String titulo; // Atributo: título del libro
    String autor; // Atributo: autor del libro
    int anio; // Atributo: año de publicación
    boolean disponible; // Atributo: disponibilidad (true o false)

    // Constructor para inicializar un libro con sus atributos
    public Libro(String titulo, String autor, int anio, boolean disponible) {
        this.titulo = titulo; // "this" hace referencia al atributo de la clase
        this.autor = autor;
        this.anio = anio;
        this.disponible = disponible;
    }

    // Método para prestar un libro (cambia disponibilidad a false)
    public void prestar() {
        disponible = false;
        System.out.println("El libro '" + titulo + "' ha sido prestado.");
    }

    // Método para devolver un libro (cambia disponibilidad a true)
    public void devolver() {
        disponible = true;
        System.out.println("El libro '" + titulo + "' ha sido devuelto.");
    }
}

// Definimos la clase Usuario (molde para crear usuarios)
class Usuario {
    String nombre; // Atributo: nombre del usuario
    int idUsuario; // Atributo: identificador del usuario

    // Constructor para inicializar un usuario
    public Usuario(String nombre, int idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    // Método para que el usuario tome un libro
    public void tomarLibro(Libro libro) {
        libro.prestar(); // Llama al método prestar() de la clase Libro
        System.out.println(nombre + " tomó el libro '" + libro.titulo + "'.");
    }

    // Método para que el usuario devuelva un libro
    public void devolverLibro(Libro libro) {
        libro.devolver(); // Llama al método devolver() de la clase Libro
        System.out.println(nombre + " devolvió el libro '" + libro.titulo + "'.");
    }
}

// Definimos la clase Biblioteca (molde para crear bibliotecas)
class Biblioteca {
    String nombre; // Atributo: nombre de la biblioteca
    Libro[] listaLibros; // Atributo: lista de libros (arreglo)
    Usuario[] listaUsuarios; // Atributo: lista de usuarios (arreglo)
    int contadorLibros; // Contador de libros agregados
    int contadorUsuarios; // Contador de usuarios registrados

    // Constructor para inicializar la biblioteca
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.listaLibros = new Libro[10]; // Creamos espacio para 10 libros
        this.listaUsuarios = new Usuario[10]; // Creamos espacio para 10 usuarios
        this.contadorLibros = 0;
        this.contadorUsuarios = 0;
    }

    // Método para registrar un usuario
    public void registrarUsuario(Usuario usuario) {
        listaUsuarios[contadorUsuarios] = usuario;
        contadorUsuarios++;
        System.out.println("Usuario '" + usuario.nombre + "' registrado en la biblioteca.");
    }

    // Método para agregar un libro
    public void agregarLibro(Libro libro) {
        listaLibros[contadorLibros] = libro;
        contadorLibros++;
        System.out.println("Libro '" + libro.titulo + "' agregado a la biblioteca.");
    }

    // Método para buscar un libro por título
    public Libro buscarLibro(String titulo) {
        for (int i = 0; i < contadorLibros; i++) {
            if (listaLibros[i].titulo.equals(titulo)) {
                return listaLibros[i]; // Devuelve el libro si lo encuentra
            }
        }
        return null; // Devuelve null si no encuentra el libro
    }

    // Método principal main (punto de inicio del programa)
    public static void main(String[] args) {
        // Creamos un objeto de tipo Biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // Creamos un objeto de tipo Libro
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, true);

        // Creamos un objeto de tipo Usuario
        Usuario usuario1 = new Usuario("Andrés", 101);

        // Agregamos el libro a la biblioteca
        biblioteca.agregarLibro(libro1);

        // Registramos al usuario en la biblioteca
        biblioteca.registrarUsuario(usuario1);

        // El usuario toma el libro
        usuario1.tomarLibro(libro1);

        // El usuario devuelve el libro
        usuario1.devolverLibro(libro1);

        // Mensaje final
        System.out.println("Fin del programa en Java. Ejemplo de Biblioteca.");
    }
}
