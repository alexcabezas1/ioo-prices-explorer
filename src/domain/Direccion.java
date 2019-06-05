package domain;

public class Direccion {
	
	private static int idCounter = 0;
	
    private int id;

    private String calle;

    private int altura;

    private String entreCalle1;

    private String entreCalle2;

    private long[] ubicacion;

    public Direccion(String calle, int altura, String entreCalle1, String entreCalle2, long[] ubic) {
    	this.calle = calle;
    	this.altura = altura;
    	this.entreCalle1 = entreCalle1;
    	this.entreCalle2 = entreCalle2;
    	this.ubicacion = ubic;
    	this.id = idCounter++;
    }
    
    public int obtenerId() {
		return id;
	}

	public String obtenerCalle() {
		return calle;
	}

	public int obtenerAltura() {
		return altura;
	}

	public String obtenerEntreCalle1() {
		return entreCalle1;
	}

	public String obtenerEntreCalle2() {
		return entreCalle2;
	}

	public long[] obtenerUbicacion() {
		return ubicacion;
	}

	public void validar() {
        
    }

    public boolean contiene(String valor) {
        String contenido = this.calle + " " + 
        				   String.valueOf(this.altura) + " " + 
        				   this.entreCalle1 + " " + 
        				   this.entreCalle2;
        return contenido.contains(valor);
    }

}