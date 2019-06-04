package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {

//    private Tienda tiendas;
//    
//    private Marca marcas;
//
//    private Direccion direcciones;
    
    private List<Producto> productos = new ArrayList<Producto>();
    private Map<String, Producto> productosPorNombre = new HashMap<String, Producto>();
    private Map<String, Producto> productosPorCodigoBarra = new HashMap<String, Producto>();
    
//    private Precio precios;
    
//    private Producto productosComprados;
    
//    private Usuario usuarioLogeado;
    
//    private String tipos;
    
    

    public void altaPrecio(Usuario usr, Producto prd, Tienda tda, float valor) {
    	if(prd.obtenerNombre() != null && usr != null && tda != null) {
    		Producto producto = buscarProductoPorCodigoBarras(prd.obtenerCodigoBarras());
    		if(producto != null) {
    			producto.agregarPrecio(usr, tda, valor);
    		} else {
    			prd.agregarPrecio(usr, tda, valor);
    			crearProducto(prd);
    		}
    	}
    }

    public void crearTienda(String nombre, String direccion, long[] ubicacion) {
        
    }

    public void crearProducto(Producto prd) {
			productosPorCodigoBarra.put(prd.obtenerCodigoBarras(), prd);
			productosPorNombre.put(prd.obtenerNombre(), prd);
        
    }

    public void crearPersona(String nombre, String apellido, String dni, String fechaNacimiento, String sexo) {
        
    }

    public void registrarUsuario(String nombre, String apellido, String dni, String fechaNacimiento, String sexo, String nombreUsuario, String clave, String email) {
        
    }

    
    public void obtenerUsuarioLogeado() {
        
    }

    
    public void obtenerPreciosRegistrados() {
        
    }

    
    public void mostrarCuentaUsuario() {
        
    }

    public Producto buscarProductosPorPalabra(String valor) {
    	return productosPorNombre.get(valor);
    }

    public Producto buscarProductoPorCodigoBarras(String valor) {
    	return productosPorCodigoBarra.get(valor);
    }

    public void buscarProductos(int[] ids) {
        
    }

    public void mostrarResultadosBusquedaProductos(Producto[] ids) {
        
    }

    public void mostrarProducto(Producto prd) {
        
    }

    public void mostrarProductosSimilares(Producto prd) {
        
    }

    public void mostrarProductosRegistrados(Producto[] prds) {
        
    }

    public void obtenerProductosComprados(Usuario usr) {
        
    }

    public void mostrarProductosComprados(Producto[] prds) {
        
    }

    public void comprarProductos(Producto[] prds) {
        
    }

    public void buscarPrecios(Producto prd) {
        
    }

    public void mostrarPrecios(Precio[] prcs) {
        
    }

    public void modificarPrecio(Precio prc) {
        
    }

    public void eliminarPrecio(Precio prc) {
        
    }

    public void iniciarSesion(String nombreUsuario, String clave) {
        
    }

    
    public void cerrarSesion() {
        
    }

    public void mostrarMensaje(String mensaje) {
        
    }

    public void buscarTiendas(String valor) {
        
    }

    public void buscarDireccion(String calle, String altura) {
        
    }

    
    public void mostrarPantallaInicio() {
        
    }

    public void mostrarEvolucionProducto(Producto prd) {
        
    }

    
    public void mostrarPantallaAltaPrecio() {
        
    }

    
    public void guardarFormularioAltaPrecio() {
        
    }

    public void buscarMarcas(String valor) {
        
    }

    public void actualizarTipos(String valor) {
        
    }

    public void elegirProducto(int id) {
        
    }

    public void mostrarPantallaDetalleProducto(Producto prd, Precio prc) {
        
    }

    public void determinarZona(int metros) {
        
    }

    public void obtenerPreciosMasRecientes(Producto prd, Zona zn) {
        
    }

    public void mostrarPantallaPreciosZona(Producto prd) {
        
    }

    public void prepararListaPreciosZona(Precio[] prcs) {
        
    }

}