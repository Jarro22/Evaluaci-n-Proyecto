package main;
import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.ProductoDAO;
import dao.ProveedorDAO;
import dao.InventarioDAO;
import models.Cliente;
import models.Empleado;
import models.Producto;
import models.Proveedor;
import models.Inventario;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        InventarioDAO inventarioDAO = new InventarioDAO();
        //  Agregar un Cliente
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Ingrese el apellido del cliente:");
        String apellidoCliente = scanner.nextLine();
        System.out.println("Ingrese el teléfono del cliente:");
        String telefonoCliente = scanner.nextLine();
        System.out.println("Ingrese el correo del cliente:");
        String correoCliente = scanner.nextLine();
        System.out.println("Ingrese la dirección del cliente:");
        String direccionCliente = scanner.nextLine();
        Cliente nuevoCliente = new Cliente(0, nombreCliente, apellidoCliente, telefonoCliente, correoCliente, direccionCliente);
        clienteDAO.agregarCliente(nuevoCliente);
        //  Listar Clientes
        List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
        System.out.println("Clientes:");
        clientes.forEach(cliente -> System.out.println(cliente.getNombre() + " " + cliente.getApellido()));
        //  Actualizar un Cliente
        if (!clientes.isEmpty()) {
            Cliente cliente = clientes.get(0);
            System.out.println("\nIngrese el nuevo nombre para el cliente " + cliente.getNombre() + ":");
            cliente.setNombre(scanner.nextLine());
            clienteDAO.actualizarCliente(cliente);
            System.out.println("\nCliente actualizado: " + cliente.getNombre());
        }
        //  Eliminar un Cliente
        if (!clientes.isEmpty()) {
            System.out.println("\n¿Desea eliminar el primer cliente de la lista? (s/n):");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                clienteDAO.eliminarCliente(clientes.get(0).getClienteId());
                System.out.println("\nCliente eliminado");
            }
        }
        //  Agregar un Empleado
        System.out.println("\nIngrese el nombre del empleado:");
        String nombreEmpleado = scanner.nextLine();
        System.out.println("Ingrese el apellido del empleado:");
        String apellidoEmpleado = scanner.nextLine();
        System.out.println("Ingrese el puesto del empleado:");
        String puestoEmpleado = scanner.nextLine();
        System.out.println("Ingrese el teléfono del empleado:");
        String telefonoEmpleado = scanner.nextLine();
        Empleado nuevoEmpleado = new Empleado(0, nombreEmpleado, apellidoEmpleado, puestoEmpleado, telefonoEmpleado);
        empleadoDAO.agregarEmpleado(nuevoEmpleado);
        //  Listar Empleados
        List<Empleado> empleados = empleadoDAO.obtenerTodosLosEmpleados();
        System.out.println("\nEmpleados:");
        empleados.forEach(empleado -> System.out.println(empleado.getNombre() + " " + empleado.getApellido()));
        //  Agregar un Producto
        System.out.println("\nIngrese el nombre del producto:");
        String nombreProducto = scanner.nextLine();
        System.out.println("Ingrese una descripción del producto:");
        String descripcionProducto = scanner.nextLine();
        System.out.println("Ingrese el precio del producto:");
        double precioProducto = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer de nueva línea
        System.out.println("Ingrese la categoría del producto:");
        String categoriaProducto = scanner.nextLine();
        System.out.println("Ingrese la cantidad en stock del producto:");
        int cantidadProducto = scanner.nextInt();
        scanner.nextLine(); 
        Producto nuevoProducto = new Producto(0, nombreProducto, descripcionProducto, precioProducto, categoriaProducto, cantidadProducto);
        productoDAO.agregarProducto(nuevoProducto);
        //  Listar Productos
        List<Producto> productos = productoDAO.obtenerTodosLosProductos();
        System.out.println("\nProductos:");
        productos.forEach(producto -> System.out.println(producto.getNombre()));
        //  Agregar un Proveedor
        System.out.println("\nIngrese el nombre del proveedor:");
        String nombreProveedor = scanner.nextLine();
        System.out.println("Ingrese el contacto del proveedor:");
        String contactoProveedor = scanner.nextLine();
        System.out.println("Ingrese el teléfono del proveedor:");
        String telefonoProveedor = scanner.nextLine();
        System.out.println("Ingrese la dirección del proveedor:");
        String direccionProveedor = scanner.nextLine();
        Proveedor nuevoProveedor = new Proveedor(0, nombreProveedor, contactoProveedor, telefonoProveedor, direccionProveedor);
        proveedorDAO.agregarProveedor(nuevoProveedor);
        //  Listar Proveedores
        List<Proveedor> proveedores = proveedorDAO.obtenerTodosLosProveedores();
        System.out.println("\nProveedores:");
        proveedores.forEach(proveedor -> System.out.println(proveedor.getNombre()));
        //  Agregar un Inventario
        System.out.println("\nIngrese el ID del producto para el inventario:");
        int productoId = scanner.nextInt();
        System.out.println("Ingrese la cantidad de productos en inventario:");
        int cantidadInventario = scanner.nextInt();
        scanner.nextLine();
        Inventario nuevoInventario = new Inventario(0, productoId, cantidadInventario, LocalDate.now());
        inventarioDAO.agregarInventario(nuevoInventario);
        //  Listar Inventarios
        List<Inventario> inventarios = inventarioDAO.obtenerTodoElInventario();
        System.out.println("\nInventarios:");
        inventarios.forEach(inventario -> System.out.println("Producto ID: " + inventario.getProductoId() + " | Cantidad: " + inventario.getCantidad()));
    }
}

