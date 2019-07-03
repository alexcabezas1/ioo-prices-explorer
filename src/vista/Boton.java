package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Boton extends JButton {

	public Boton(String texto, int y) {
		setBounds(10, 80 * y, 300, 75);
        setOpaque(true);
		setLayout(new BorderLayout());
		setText(texto);
	}
	
	public void setText(String texto) {
		String [] palabras = texto.split(" ");
//		if(palabras != null && palabras.length > 2) {
//			String label1 = "";
//			for(int i = 0; i < 2; i++ ) {
//				label1 += palabras[i] + " ";
//			}
//			JLabel jlabel = new JLabel(label1);
//			jlabel.setForeground(Color.GRAY);
//			add(BorderLayout.NORTH, jlabel);
//			
//			String label2 = "";
//			for(int i = 2; i < palabras.length; i++ ) {
//				label2 += palabras[i] + " ";
//			}
//			JLabel jlabel2 = new JLabel(label2);
//			jlabel2.setForeground(Color.GRAY);
//			add(BorderLayout.SOUTH, jlabel2);
//		} else {
			JLabel Jlabel1 = new JLabel(texto);
			Jlabel1.setForeground(Color.GRAY);
			add(BorderLayout.CENTER, Jlabel1);
//		}
	   
	   
	   

	}
}
