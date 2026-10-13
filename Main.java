public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("¿Está vacía? " + lista.estaVacia());

        // Insertar elementos
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlInicio(5);
        lista.insertarAlFinal(30);

        System.out.print("Lista actual: ");
        lista.imprimir(); // Debe mostrar: 5 → 10 → 20 → 30

        System.out.println("Total de elementos: " + lista.contar());
        System.out.println("¿Existe el 20? " + lista.buscar(20));
        System.out.println("Elemento en el índice 2: " + lista.obtener(2));

        // Eliminar un elemento
        lista.eliminar(20);
        System.out.print("Lista después de eliminar el 20: ");
        lista.imprimir(); // Debe mostrar: 5 → 10 → 30
    }
}
