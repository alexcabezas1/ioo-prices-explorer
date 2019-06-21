package modelo;

import java.util.List;

import dominio.Direccion;
import dominio.Marca;
import dominio.Precio;
import dominio.Producto;
import dominio.Tienda;
import modelo.Modelo;

public class TestModelo {
	static final Modelo modelo = new Modelo();
	
    private static void mostrarProductos() {
    	for (Producto prd : modelo.productos) {
        	System.out.println(prd.toString());
    	}
    }
    
    private static void mostrarPrecios() {
    	for (Precio prc : modelo.precios) {
    		System.out.println(prc.toString());
    	}
    }
	
	public static void main(String[] args) {
    	modelo.asignarUsuarioLogeado("abelardoram", "1234*");
    	//Usuario usr = modelo.obtenerUsuarioLogeado();
    	
    	modelo.guardarDatosAltaPrecio("codbar1", "Arroz Integral", "Gallo", 
				    			"Arroz", (float)50.50, "coto", "Parana", 26, 
				    			"Parana", "Rivadavia");
    	
    	List<Marca> marcas = modelo.buscarMarcas("Gallo");
    	Producto prd1 = new Producto("codbar2", "Arroz Blanco", marcas.get(0), "Arroz");
    	List<Tienda> tiendas = modelo.buscarTiendas("coto");
    	
    	modelo.guardarDatosAltaPrecio(prd1, tiendas.get(0), (float)40.12);
    	
    	List<Direccion> direcciones = modelo.buscarDireccion("Parana", "26");
    	System.out.println(direcciones.get(0));

    	Producto prd2 = new Producto("codbar3", "Pasta Larga", new Marca("Alicorp"), "Pasta");
    	modelo.guardarDatosAltaPrecio(prd2, (float)30.70, "Carrefur", "Beruti", 2890, "Beruti", "Austria");
    	
    	mostrarProductos();
    	mostrarPrecios();
	}

}
