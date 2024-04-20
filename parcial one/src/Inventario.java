import java.util.ArrayList;

// Clase para gestionar el inventario
public class Inventario {
    private ArrayList<Articulo> inventario;

    public Inventario() {
        inventario = new ArrayList<>();
    }

    public void agregarArticulo(Articulo articulo) {
        inventario.add(articulo);
    }

    public void modificarArticulo(int indice, Laptop nuevoArticulo) {
        inventario.set(indice, nuevoArticulo);
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("=== Inventario de ElectroMart ===");
            for (int i = 0; i < inventario.size(); i++) {
                Articulo articulo = inventario.get(i);
                System.out.println((i + 1) + ". " + articulo.obtenerDescripcion() + " - Precio: $" + articulo.obtenerPrecio());
            }
        }
    }

    public int obtenerTamanoInventario() {
        return inventario.size();
    }

    public Articulo obtenerArticulo(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            return inventario.get(indice);
        } else {
            return null;
        }
    }
}
