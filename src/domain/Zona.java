package domain;

import java.util.List;

public class Zona {

    private List<float[]> ubicaciones;

    public Zona(List<float[]> ubicaciones) {
    	this.ubicaciones = ubicaciones;
    }
    
    public boolean pertenece(float[] ubic) {
    	//TODO implementar metodo 
    	return true;
    }

}