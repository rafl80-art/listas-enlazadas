public class Nodo {
      // ===== ATRIBUTOS =====
    // El valor que almacena este nodo. Usamos int para simplificar, pero podría ser genérico.
    int dato;

    // Referencia al SIGUIENTE nodo de la lista.
    // Si este nodo es el último, 'siguiente' será null.
    Nodo siguiente;

    // ===== CONSTRUCTOR =====
    // Recibe el dato a guardar. 'siguiente' se inicializa en null automáticamente.
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null; // explícito para que quede claro
    }
}


