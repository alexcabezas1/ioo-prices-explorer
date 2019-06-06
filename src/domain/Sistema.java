package domain;

import java.util.ArrayList;
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

    public void altaPrecio(Usuario usr, Producto prd, Tienda tda, float valor) {
		Precio prc = prd.agregarPrecio(usr, tda, valor);
		this.precios.add(prc);
    }

    public void crearTienda(String nombre, String direccion, long[] ubicacion) {
        
    }
    
    public Producto crearProducto(String codBarras, String nombre, String mrcNbre, String tipo) {
    	Marca nMrc = new Marca(mrcNbre);
    	this.marcas.add(nMrc);
    	
    	Producto nPrd = this.crearProducto(codBarras, nombre, nMrc, tipo);
    	this.productos.add(nPrd);
    	this.actualizarTipos(tipo);
		this.productosPorCodigoBarra.put(nPrd.obtenerCodigoBarras(), nPrd);
		this.productosPorNombre.put(nPrd.obtenerNombre(), nPrd);
    	return nPrd;
    }
    
    public Producto crearProducto(String codBarras, String nombre, Marca marca, String tipo) {
    	return new Producto(codBarras, nombre, marca, tipo.toLowerCase());
    }

    public void crearPersona(String nombre, String apellido, String dni, String fechaNacimiento, String sexo) {
        
    }

    public void registrarUsuario(String nombre, String apellido, String dni, String fechaNacimiento, String sexo, String nombreUsuario, String clave, String email) {
        
    }

    
    public Usuario obtenerUsuarioLogeado() {
        return this.usuarioLogeado;
    }

    
    public void obtenerPreciosRegistrados() {
        
    }

    
    public void mostrarCuentaUsuario() {
        
    }

    public List<Producto> buscarProductosPorPalabra(String valor) {
    	List<Producto> coincidencias = new ArrayList<Producto>();
    	for (Producto prd : this.productos) {
    		if (prd.contiene(valor.toLowerCase())) coincidencias.add(prd);
    	}
    	return coincidencias;
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
    	//inicio de sesion fijo para probar
    	Persona per = new Persona("Abelardo", "Ramirez", "123456789", "01-02-1994", "m");
    	Usuario usr = new Usuario("abelardoram", "abelardo890@gmail.com", "1234*", per);
    	float[] ubic = {(float)-34.6078662, (float)-58.3831004};
    	usr.asignarUbicacion(ubic);
        this.usuarioLogeado = usr;
    }

    
    public void cerrarSesion() {
        
    }

    public void mostrarMensaje(String mensaje) {
        
    }

    public List<Tienda> buscarTiendas(String valor) {
        List<Tienda> coincidencias = new ArrayList<Tienda>();
        for (Tienda tda : this.tiendas) {
        	if (tda.contiene(valor.toLowerCase())) coincidencias.add(tda);
        }
        return coincidencias;
    }

    public List<Direccion> buscarDireccion(String calle, String altura) {
        List<Direccion> coincidencias = new ArrayList<Direccion>();
        String valor = (calle + " " + altura).toLowerCase();
        for (Direccion dir : this.direcciones) {
        	if (dir.contiene(valor)) coincidencias.add(dir);
        }
        return coincidencias;
    }

    
    public void mostrarPantallaInicio() {
        
    }

    public void mostrarEvolucionProducto(Producto prd) {
        
    }

    
    public void mostrarPantallaAltaPrecio() {
        
    }

    
    public void guardarDatosAltaPrecio(Producto prd, Tienda tda, float prcValor) {
        Usuario usr = this.obtenerUsuarioLogeado();
        this.altaPrecio(usr, prd, tda, prcValor);
    }
    
    public void guardarDatosAltaPrecio(Producto prd, float prcValor, String tdaNbre, 
    		String dirCalle, int dirAtra, String dirEntCalle1, String dirEntCalle2) {
    	
    	Usuario usr = this.obtenerUsuarioLogeado();
    	Direccion nDir = new Direccion(dirCalle, dirAtra, dirEntCalle1, dirEntCalle2, usr.obtenerUbicacion());
    	Tienda nTda = new Tienda(tdaNbre, nDir);
    	this.guardarDatosAltaPrecio(prd, nTda, prcValor);
    	this.tiendas.add(nTda);
    	this.direcciones.add(nDir);
    }
    
    public void guardarDatosAltaPrecio(String prdCodBar, String prdNbre, String mrcNbre, 
    		String prdTpo, Tienda tda, float prcValor) {
    	
    	Producto nPrd = this.crearProducto(prdCodBar, prdNbre, mrcNbre, prdTpo);
    	this.guardarDatosAltaPrecio(nPrd, tda, prcValor);
    }
    
    public void guardarDatosAltaPrecio(String prdCodBar, String prdNbre, String mrcNbre, 
    		String prdTpo, float prcValor, String tdaNbre, String dirCalle, 
    		int dirAtra, String dirEntCalle1, String dirEntCalle2) {
    	
    	Usuario usr = this.obtenerUsuarioLogeado();
    	Direccion nDir = new Direccion(dirCalle, dirAtra, dirEntCalle1, dirEntCalle2, usr.obtenerUbicacion());
    	Tienda nTda = new Tienda(tdaNbre, nDir);
    	Producto nPrd = this.crearProducto(prdCodBar, prdNbre, mrcNbre, prdTpo);
    	this.guardarDatosAltaPrecio(nPrd, nTda, prcValor);
    	this.tiendas.add(nTda);
    	this.direcciones.add(nDir);
    }

    public List<Marca> buscarMarcas(String valor) {
        List<Marca> coincidencias = new ArrayList<Marca>();
        for (Marca mrc : this.marcas) {
        	if (mrc.contiene(valor.toLowerCase())) coincidencias.add(mrc);
        }
        return coincidencias;
    }

    public void actualizarTipos(String valor) {
    	boolean encontrado = false;
        for (String tipo : this.tipos) {
        	if (tipo.toLowerCase() == valor.toLowerCase()) {
        		encontrado = true;
        		break;
        	}
        }
        if (!encontrado) this.tipos.add(valor.toLowerCase());
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
    
    private void mostrarProductos() {
    	for (Producto prd : this.productos) {
        	System.out.println(prd.toString());
    	}
    }
    
    private void mostrarPrecios() {
    	for (Precio prc : this.precios) {
    		System.out.println(prc.toString());
    	}
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