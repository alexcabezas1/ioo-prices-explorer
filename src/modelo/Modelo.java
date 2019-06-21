package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dominio.Direccion;
import dominio.Marca;
import dominio.Persona;
import dominio.Precio;
import dominio.Producto;
import dominio.Tienda;
import dominio.Usuario;
import dominio.Zona;

public class Modelo {
	protected List<Tienda> tiendas = new ArrayList<Tienda>();
	protected Set<Marca> marcas = new HashSet<Marca>();
	protected List<Direccion> direcciones = new ArrayList<Direccion>();
	protected List<Producto> productos = new ArrayList<Producto>();
	protected List<Precio> precios = new ArrayList<Precio>();
	protected Usuario usuarioLogeado;
	protected Set<String> tipos = new HashSet<String>();
    
    private Map<String, Producto> productosPorNombre = new HashMap<String, Producto>();
    private Map<String, Producto> productosPorCodigoBarra = new HashMap<String, Producto>();

    public Set<String> obtenerTipos(){
    	return this.tipos;
    }
    
    public Set<Marca> obtenerMarcas(){
    	return this.marcas;
    }
    
    public Producto crearProducto(String codBarras, String nombre, Marca marca, String tipo) {
    	return new Producto(codBarras, nombre, marca, tipo.toLowerCase());
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
    
    public void altaPrecio(Usuario usr, Producto prd, Tienda tda, float valor) {
		Precio prc = prd.agregarPrecio(usr, tda, valor);
		this.precios.add(prc);
    }

    public void asignarUsuarioLogeado(String nombreUsuario, String clave) {
    	//inicio de sesion fijo para probar
    	Persona per = new Persona("Abelardo", "Ramirez", "123456789", "01-02-1994", "m");
    	Usuario usr = new Usuario("abelardoram", "abelardo890@gmail.com", "1234*", per);
    	float[] ubic = {(float)-34.6078662, (float)-58.3831004};
    	usr.asignarUbicacion(ubic);
        this.usuarioLogeado = usr;
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
    
    public void buscarPrecios(Producto prd) {
        
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
    
    public List<Marca> buscarMarcas(String valor) {
        List<Marca> coincidencias = new ArrayList<Marca>();
        for (Marca mrc : this.marcas) {
        	if (mrc.contiene(valor.toLowerCase())) coincidencias.add(mrc);
        }
        return coincidencias;
    }
    
    public Usuario obtenerUsuarioLogeado() {
        return this.usuarioLogeado;
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
}
