package domain;

import java.util.List;

public class Zona {

    private List<float[]> ubicaciones;

    public Zona(List<float[]> ubicaciones) {
    	this.ubicaciones = ubicaciones;
    }
    
    public boolean pertenece(float[] ubic) {
    	float longitud = ubic[0];
    	float latitud = ubic[1];
    	return (longitud > ubicaciones.get(0)[0] && longitud < ubicaciones.get(1)[0] 
    			&& latitud > ubicaciones.get(3)[1] && latitud < ubicaciones.get(4)[1]); 
    }

}