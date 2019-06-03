package domain;

public class Direccion {

    private int id;

    private String calle;

    private int altura;

    private String entreCalle1;

    private String entreCalle2;

    private long[] ubicacion;

    
    public int obtenerId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String obtenerCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int obtenerAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String obtenerEntreCalle1() {
		return entreCalle1;
	}

	public void setEntreCalle1(String entreCalle1) {
		this.entreCalle1 = entreCalle1;
	}

	public String obtenerEntreCalle2() {
		return entreCalle2;
	}

	public void setEntreCalle2(String entreCalle2) {
		this.entreCalle2 = entreCalle2;
	}

	public long[] obtenerUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(long[] ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void validar() {
        
    }

    public void contiene(String valor) {
        
    }

}