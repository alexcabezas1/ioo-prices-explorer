package domain;

public class Sistema {

    private Tienda tiendas;
    
    private Marca marcas;

    private Direccion direcciones;
    
    private Producto productos;
    
    private Precio precios;
    
    private Producto productosComprados;
    
    private Usuario usuarioLogeado;
    
    private String tipos;

    public void altaPrecio(Usuario usr, Producto prd, Tienda tda, float valor) {
    	

        
    }

    public void crearTienda(String nombre, String direccion, long[] ubicacion) {
        
    }

    public void crearProducto(String codigoBarras, String nombre, String marca, String tipo) {
        
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

    /**
     * @param String valor
     */
    public void buscarProductosPorPalabra(String valor) {
        
    }

    /**
     * @param String valor
     */
    public void buscarProductoPorCodigoBarras(String valor) {
        
    }

    /**
     * @param int[] ids
     */
    public void buscarProductos(int[] ids) {
        
    }

    /**
     * @param Producto[] ids
     */
    public void mostrarResultadosBusquedaProductos(Producto[] ids) {
        
    }

    /**
     * @param Producto prd
     */
    public void mostrarProducto(Producto prd) {
        
    }

    /**
     * @param Producto prd
     */
    public void mostrarProductosSimilares(Producto prd) {
        
    }

    /**
     * @param Productos[] prds
     */
    public void mostrarProductosRegistrados(Producto[] prds) {
        
    }

    /**
     * @param Usuario usr
     */
    public void obtenerProductosComprados(Usuario usr) {
        
    }

    /**
     * @param Productos[] prds
     */
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