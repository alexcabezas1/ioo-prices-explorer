package dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {

	private List<Tienda> tiendas = new ArrayList<Tienda>();
 
	private List<Marca> marcas = new ArrayList<Marca>();

	private List<Direccion> direcciones = new ArrayList<Direccion>();
    
    private List<Producto> productos = new ArrayList<Producto>();
    private Map<String, Producto> productosPorNombre = new HashMap<String, Producto>();
    private Map<String, Producto> productosPorCodigoBarra = new HashMap<String, Producto>();
    
    private List<Precio> precios = new ArrayList<Precio>();
    
    //private List<Producto> productosComprados = new ArrayList<Producto>();
    
    private Usuario usuarioLogeado;
    
    private List<String> tipos = new ArrayList<String>();

    public void crearTienda(String nombre, String direccion, long[] ubicacion) {
        
    }

    public void crearPersona(String nombre, String apellido, String dni, String fechaNacimiento, String sexo) {
        
    }

    public void registrarUsuario(String nombre, String apellido, String dni, String fechaNacimiento, String sexo, String nombreUsuario, String clave, String email) {
        
    }

    public void obtenerPreciosRegistrados() {
        
    }

    
    public void mostrarCuentaUsuario() {
        
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

    public void mostrarPrecios(Precio[] prcs) {
        
    }

    public void modificarPrecio(Precio prc) {
        
    }

    public void eliminarPrecio(Precio prc) {
        
    }
    
    public void cerrarSesion() {
        
    }

    public void mostrarMensaje(String mensaje) {
        
    }
    
    public void mostrarPantallaInicio() {
        
    }

    public void mostrarEvolucionProducto(Producto prd) {
        
    }

    
    public void mostrarPantallaAltaPrecio() {
        
    }

    public void mostrarPantallaDetalleProducto(Producto prd, Precio prc) {
        
    }

    public void mostrarPantallaPreciosZona(Producto prd) {
    	Zona zn = determinarZona(500);
    	obtenerPreciosMasRecientes(prd, zn);
    	
    	//Llamar a iniciarVentana, prepararListaPreciosZona(preciosMasRecientes)
    }

    public void prepararListaPreciosZona(Precio[] prcs) {
        
    }
    
    public static void main(String[] args) {
    	Sistema si = new Sistema();
    	
    	si.iniciarSesion("abelardoram", "1234*");
    	//Usuario usr = si.obtenerUsuarioLogeado();
    	
    	si.guardarDatosAltaPrecio("codbar1", "Arroz Integral", "Gallo", 
				    			"Arroz", (float)50.50, "coto", "Parana", 26, 
				    			"Parana", "Rivadavia");
    	
    	List<Marca> marcas = si.buscarMarcas("Gallo");
    	Producto prd1 = new Producto("codbar2", "Arroz Blanco", marcas.get(0), "Arroz");
    	List<Tienda> tiendas = si.buscarTiendas("coto");
    	
    	si.guardarDatosAltaPrecio(prd1, tiendas.get(0), (float)40.12);
    	
    	List<Direccion> direcciones = si.buscarDireccion("Parana", "26");
    	System.out.println(direcciones.get(0));

    	Producto prd2 = new Producto("codbar3", "Pasta Larga", new Marca("Alicorp"), "Pasta");
    	si.guardarDatosAltaPrecio(prd2, (float)30.70, "Carrefur", "Beruti", 2890, "Beruti", "Austria");
    	
    	si.mostrarProductos();
    	si.mostrarPrecios();
    	
    }
}