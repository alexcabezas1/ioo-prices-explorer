package domain;

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

    public void altaPrecio(Usuario usr, Producto prd, Tienda tda, float valor) {
		Precio prc = prd.agregarPrecio(usr, tda, valor);
		this.precios.add(prc);
    }

    public void crearTienda(String nombre, String direccion, long[] ubicacion) {
        
    }
    
    public Producto crearProducto(String codBarras, String nombre, String mrcNbre, String tipo) {
    	Marca nMrc = new Marca(mrcNbre);
    	return this.crearProducto(codBarras, nombre, nMrc, tipo);
    }
    
    public Producto crearProducto(String codBarras, String nombre, Marca marca, String tipo) {
    	Producto nPrd = new Producto(codBarras, nombre, marca, tipo.toLowerCase());
    	this.productos.add(nPrd);
    	this.actualizarTipos(tipo);
		this.productosPorCodigoBarra.put(nPrd.obtenerCodigoBarras(), nPrd);
		this.productosPorNombre.put(nPrd.obtenerNombre(), nPrd);
		return nPrd;
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
    		if (prd.contiene(valor)) coincidencias.add(prd);
    	}
    	return coincidencias;
    }

    public Producto buscarProductoPorCodigoBarras(String valor) {
    	return productosPorCodigoBarra.get(valor);
    }

    public List<Producto> buscarProductos(Integer[] ids) {
    	List<Producto> coincidencias = new ArrayList<Producto>();
    	for (Producto prd : this.productos) {
    		List<Integer> ids_producto = Arrays.asList(ids);
    		if (ids_producto.contains(prd.obtenerId())) {
    			coincidencias.add(prd);
    		}
    	}
    	return coincidencias;
        
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
        	if (tda.contiene(valor)) coincidencias.add(tda);
        }
        return coincidencias;
    }

    public List<Direccion> buscarDireccion(String calle, String altura) {
        List<Direccion> coincidencias = new ArrayList<Direccion>();
        String valor = calle + " " + altura;
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
    }

    public List<Marca> buscarMarcas(String valor) {
        List<Marca> coincidencias = new ArrayList<Marca>();
        for (Marca mrc : this.marcas) {
        	if (mrc.contiene(valor)) coincidencias.add(mrc);
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
    	Usuario usr = obtenerUsuarioLogeado();

    	Producto prd = buscarProductos(new Integer[]{id}).get(0);
    	
    	Precio prc = prd.obtenerPrecioMasReciente(usr.obtenerUbicacion());
    	
    	//Llamar a iniciarVentanaDetallePrecio
    	
    }

    public void mostrarPantallaDetalleProducto(Producto prd, Precio prc) {
        
    }

    public Zona determinarZona(int metros) {
    	float[] ubic = obtenerUsuarioLogeado().obtenerUbicacion();
    	
    	//Asumimos que ubic de 0 es la latitud
    	//Asumimos que ubic de 1 es la longitud
    	
    	//Para sacar la zona, primero disminuimos la longitud y la latitud en metros/2
    	float m = metros;
    	
    	List<float[]> ubicaciones = new ArrayList<float[]>();
    	ubicaciones.add(new float[] {ubic[0] - m, ubic[1]});
    	ubicaciones.add(new float[] {ubic[0] + m, ubic[1]});
    	ubicaciones.add(new float[] {ubic[0], ubic[1] - m});
    	ubicaciones.add(new float[] {ubic[0], ubic[1] + m});
    	
		return new Zona(ubicaciones);
    }

    public List<Precio> obtenerPreciosMasRecientes(Producto prd, Zona zn) {
    	
        Map<Integer, Precio> preciosMasRecientesXTienda = new HashMap<Integer, Precio>();
        
        for(Precio prc: prd.obtenerPrecios()){
        	
        	Precio precioMasReciente = preciosMasRecientesXTienda.get(prc.obtenerTienda().obtenerId());
        	
        	if ((precioMasReciente == null || prc.obtenerFechaHoraRegistro().after(precioMasReciente.obtenerFechaHoraRegistro()) &&
        			zn.pertenece(prc.obtenerTienda().obtenerUbicacion()))){
        		preciosMasRecientesXTienda.put(prc.obtenerTienda().obtenerId(), prc);
        	}
    	}
        
		return  Arrays.asList((Precio[]) preciosMasRecientesXTienda.values().toArray());
    }

    public void mostrarPantallaPreciosZona(Producto prd) {
    	Zona zn = determinarZona(500);
    	obtenerPreciosMasRecientes(prd, zn);
    	
    	//Llamar a iniciarVentana, prepararListaPreciosZona(preciosMasRecientes)
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
				    			"Parana y Rivadavia", "");
    	
    	List<Marca> marcas = si.buscarMarcas("Gallo");
    	Producto prd = new Producto("codbar2", "Arroz Blanco", marcas.get(0), "Arroz");
    	
    	List<Direccion> direcciones = si.buscarDireccion("Parana", "26");
    	List<Tienda> tiendas = si.buscarTiendas("coto");
    	
    	si.guardarDatosAltaPrecio(prd, tiendas.get(0), (float)40.12);
    	
    	si.mostrarProductos();
    	si.mostrarPrecios();
    	
    }
}