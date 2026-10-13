public class ListaEnlazada {

    // ===== ATRIBUTO PRINCIPAL =====
    // 'cabeza' apunta al PRIMER nodo de la lista. Si la lista está vacía, cabeza == null.
    private Nodo cabeza;

    // ===== CONSTRUCTOR =====
    // Al crear la lista, está vacía: cabeza apunta a null.
    public ListaEnlazada() {
        this.cabeza = null;
    }

    // PASO 3: Método estaVacia()
    // Devuelve true si la lista no tiene ningún nodo.
    public boolean estaVacia() {
        return cabeza == null;
    }

    // PASO 4: Método insertarAlInicio(int dato)
    // Inserta un nodo al principio. Es la operación más eficiente de una lista enlazada: O(1).
    public void insertarAlInicio(int dato) {
        // 1) Creamos el nuevo nodo con el dato recibido.
        Nodo nuevo = new Nodo(dato);

        // 2) Hacemos que el nuevo nodo apunte al que era el primer nodo.
        nuevo.siguiente = cabeza;

        // 3) Actualizamos 'cabeza' para que apunte al nuevo nodo.
        cabeza = nuevo;
    }

    // PASO 5: Método insertarAlFinal(int dato)
    // Recorre toda la lista para llegar al último nodo. Coste O(n).
    public void insertarAlFinal(int dato) {
        // 1) Creamos el nuevo nodo.
        Nodo nuevo = new Nodo(dato);

        // 2) Caso especial: si la lista está vacía, el nuevo nodo pasa a ser la cabeza.
        if (cabeza == null) {
            cabeza = nuevo;
            return; // salimos del método
        }

        // 3) Si no está vacía, recorremos hasta el ÚLTIMO nodo.
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        // 4) Enlazamos el último nodo con el nuevo.
        actual.siguiente = nuevo;
    }

    // PASO 6: Método imprimir()
    // Recorre la lista y muestra los datos. Esencial para depurar.
    public void imprimir() {
        // Si está vacía, avisamos y salimos.
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        // Puntero auxiliar para no perder la cabeza.
        Nodo actual = cabeza;

        // Recorremos hasta el final imprimiendo cada dato.
        while (actual != null) {
            System.out.print(actual.dato);
            // Si hay siguiente, imprimimos la flecha.
            if (actual.siguiente != null) {
                System.out.print(" → ");
            }
            actual = actual.siguiente; // avanzamos
        }
        System.out.println(); // salto de línea final
    }

    // PASO 7: Método buscar(int dato)
    // Devuelve true si el dato existe, false si no.
    public boolean buscar(int dato) {
        Nodo actual = cabeza;

        // Recorremos mientras no lleguemos al final.
        while (actual != null) {
            // Comparamos el dato del nodo actual con el buscado.
            if (actual.dato == dato) {
                return true; // encontrado
            }
            actual = actual.siguiente; // avanzamos
        }

        return false; // llegamos al final sin encontrarlo
    }

    // PASO 8: Método eliminar(int dato)
    // Elimina un nodo manejando tres casos: lista vacía, en la cabeza, o en medio/final.
    public boolean eliminar(int dato) {
        // CASO 1: lista vacía -> nada que eliminar.
        if (cabeza == null) {
            return false;
        }

        // CASO 2: el dato está en la CABEZA.
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente; // el segundo pasa a ser primero
            return true;
        }

        // CASO 3: el dato está en medio o al final.
        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;

        while (actual != null) {
            if (actual.dato == dato) {
                anterior.siguiente = actual.siguiente;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }

        return false; // no se encontró el dato
    }

    // PASO 9: Método contar()
    // Devuelve cuántos elementos hay.
    public int contar() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // PASO 10: Método obtener(int indice)
    // Devuelve el dato en la posición índice (empezando en 0). Coste O(n).
    public int obtener(int indice) {
        // Validación básica.
        if (indice < 0) {
            throw new IndexOutOfBoundsException("Índice negativo: " + indice);
        }

        Nodo actual = cabeza;
        int posicion = 0;

        while (actual != null) {
            if (posicion == indice) {
                return actual.dato;
            }
            actual = actual.siguiente;
            posicion++;
        }

        // Si salimos del while, el índice se pasó del tamaño.
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
    }
}