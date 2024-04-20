import java.util.Scanner;

// Clase principal que contiene el método main
public class Main {
    public static void main(String[] args) {
        Inventario gestorInventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBIENVENIDO AL SISTEMA DE INVENTARIO DE ElECTROMART");
            System.out.println("1. Desea agregar artículo");
            System.out.println("2. Desea modificar artículo");
            System.out.println("3. Desea ver Inventario");
            System.out.println("4. Salir");

            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarArticuloMenu(gestorInventario, scanner);
                    break;
                case 2:
                    modificarArticuloMenu(gestorInventario, scanner);
                    break;
                case 3:
                    gestorInventario.mostrarInventario();
                    break;
                case 4:
                    System.out.println("Bye...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor ingrese una opción válida.");
            }
        }
    }

    private static void agregarArticuloMenu(Inventario gestorInventario, Scanner scanner) {
        System.out.println("\nAgregar Artículo:");
        System.out.println("1. Teléfono Celular");
        System.out.println("2. Laptop");
        System.out.print("Seleccione el tipo de artículo que desea agregar: ");
        int tipoArticulo = scanner.nextInt();
        scanner.nextLine();

        switch (tipoArticulo) {
            case 1:
                Inventario Inventario;
                Inventario
                        = new Inventario();
                agregarTelefonoMovil(Inventario, scanner);
                break;
            case 2:
                Inventario = new Inventario();
                agregarLaptop(Inventario, scanner);
                break;
            default:
                System.out.println("Tipo de artículo NO válido.");
        }
    }

    private static void agregarTelefonoMovil(Inventario gestorInventario, Scanner scanner) {
        System.out.print("Nombre del teléfono celular: ");
        String nombre = scanner.nextLine();
        System.out.print("Modelo del teléfono celular: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca del teléfono celular: ");
        String marca = scanner.nextLine();
        System.out.print("Almacenamiento del teléfono celular: ");
        String almacenamiento = scanner.nextLine();
        System.out.print("Precio del teléfono celular: ");
        double precio = scanner.nextDouble();

        Articulo telefonoMovil = new TelefonoMovil(nombre, modelo, marca, almacenamiento, precio);
        gestorInventario.agregarArticulo(telefonoMovil);
        System.out.println("Teléfono celular ha sido agregado correctamente.");
    }

    private static void agregarLaptop(Inventario gestorInventario, Scanner scanner) {
        System.out.print("Nombre de la laptop: ");
        String nombre = scanner.nextLine();
        System.out.print("Modelo de  laptop: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca de  laptop: ");
        String marca = scanner.nextLine();
        System.out.print("Procesador de la laptop: ");
        String procesador = scanner.nextLine();
        System.out.print("Precio de la laptop: ");
        double precio = scanner.nextDouble();

        Articulo laptop = new Laptop(nombre, modelo, marca, procesador, precio);
        gestorInventario.agregarArticulo(laptop);
        System.out.println("Laptop ha sido agregada correctamente.");
    }

    private static void modificarArticuloMenu(Inventario gestorInventario, Scanner scanner) {
        System.out.print("Ingrese el número del artículo que desea modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (indice >= 1 && indice <= gestorInventario.obtenerTamanoInventario()) {
            System.out.println("Seleccione el tipo de artículo que desea modificar:");
            System.out.println("1. Teléfono Móvil");
            System.out.println("2. Laptop");
            System.out.print("Seleccione: ");
            int tipoArticulo = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (tipoArticulo) {
                case 1:
                    Inventario Inventario = new Inventario();
                    modificarTelefonoMovil(Inventario, scanner, indice - 1);
                    break;
                case 2:
                    Inventario  = new Inventario();
                    modificarLaptop(Inventario, scanner, indice - 1);
                    break;
                default:
                    System.out.println("Tipo de artículo inválido.");
            }
        } else {
            System.out.println("Número de artículo inválido.");
        }
    }

    private static void modificarTelefonoMovil(Inventario gestorInventario, Scanner scanner, int indice) {
        Articulo articulo = gestorInventario.obtenerArticulo(indice);
        if (articulo instanceof TelefonoMovil) {
            System.out.println("Modificar Teléfono Móvil:");
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Nueva marca: ");
            String marca = scanner.nextLine();
            System.out.print("Nuevo almacenamiento: ");
            String almacenamiento = scanner.nextLine();
            System.out.print("Nuevo precio: ");
            double precio = scanner.nextDouble();

            TelefonoMovil nuevoTelefonoMovil = new TelefonoMovil(nombre, modelo, marca, almacenamiento, precio);
            Laptop TelefonoMovil = null;
            gestorInventario.modificarArticulo(indice, TelefonoMovil);
            System.out.println("Teléfono móvil modificado correctamente.");
        } else {
            System.out.println("El artículo seleccionado no es un teléfono móvil.");
        }
    }

    private static void modificarLaptop(Inventario gestorInventario, Scanner scanner, int indice) {
        Articulo articulo = gestorInventario.obtenerArticulo(indice);
        if (articulo instanceof Laptop) {
            System.out.println("Modificar Laptop:");
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Nueva marca: ");
            String marca = scanner.nextLine();
            System.out.print("Nuevo procesador: ");
            String procesador = scanner.nextLine();
            System.out.print("Nuevo precio: ");
            double precio = scanner.nextDouble();

            Laptop nuevaLaptop = new Laptop(nombre, modelo, marca, procesador, precio);
            gestorInventario.modificarArticulo(indice, nuevaLaptop);
            System.out.println("Laptop modificada correctamente.");
        } else {
            System.out.println("El artículo seleccionado no es una laptop.");
        }
    }
}
