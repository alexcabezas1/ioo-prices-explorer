package dominio;

public class Direccion {
	
	private static int idCounter = 0;
	
    private int id;

    private String calle;

    private int altura;

    private String entreCalle1;

    private String entreCalle2;

    private float[] ubicacion;

    public Direccion(String calle, int altura, String entreCalle1, String entreCalle2, float[] ubic) {
    	this.calle = calle.toLowerCase();
    	this.altura = altura;
    	this.entreCalle1 = entreCalle1.toLowerCase();
    	this.entreCalle2 = entreCalle2.toLowerCase();
    	this.ubicacion = ubic;
    	this.id = ++idCounter;
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

	public float[] obtenerUbicacion() {
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
    
    public String toString() {
    	String cont = "direccion:" + String.valueOf(this.id);
    	cont += ", calle: " + this.calle;
    	cont += ", altura:" + String.valueOf(this.altura);
    	cont += ", entre-calle1:" + this.entreCalle1;
    	cont += ", entre-calle2:" + this.entreCalle2;
    	return cont;
    }
}