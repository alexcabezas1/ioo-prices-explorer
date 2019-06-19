package vista;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AltaPrecio extends JPanel {
	private JTextField tfNombreProducto;
	private JTextField tfAltura;
	private JTextField tfEntreCalles1;
	private JTextField tfEntreCalles2;
	private JTextField tfPrecioProducto;

	/**
	 * Create the panel.
	 */
	public AltaPrecio() {
		setLayout(null);
		
		JLabel lblDatosDelProducto = new JLabel("Datos del Producto");
		lblDatosDelProducto.setBounds(10, 10, 136, 13);
		lblDatosDelProducto.setForeground(Color.BLUE);
		add(lblDatosDelProducto);
		
		JButton btnBuscarProducto = new JButton("...");
		btnBuscarProducto.setBounds(173, 6, 44, 21);
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnBuscarProducto);
		
		JLabel lblNombreProducto = new JLabel("Nombre");
		lblNombreProducto.setBounds(10, 30, 101, 14);
		lblNombreProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombreProducto.setForeground(Color.BLACK);
		add(lblNombreProducto);
		
		tfNombreProducto = new JTextField();
		tfNombreProducto.setBounds(121, 29, 96, 19);
		add(tfNombreProducto);
		tfNombreProducto.setColumns(10);
		
		JLabel lblTipoProducto = new JLabel("Tipo");
		lblTipoProducto.setBounds(10, 56, 31, 13);
		lblTipoProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTipoProducto.setForeground(Color.BLACK);
		add(lblTipoProducto);
		
		JComboBox cbTipoProducto = new JComboBox();
		cbTipoProducto.setBounds(81, 50, 136, 19);
		cbTipoProducto.setModel(new DefaultComboBoxModel(new String[] {"option 1", "option 2", "option 3"}));
		add(cbTipoProducto);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 83, 61, 13);
		lblMarca.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMarca.setForeground(Color.BLACK);
		add(lblMarca);
		
		JComboBox cbMarcaProducto = new JComboBox();
		cbMarcaProducto.setBounds(81, 75, 136, 21);
		add(cbMarcaProducto);
		
		JLabel lblDatosTienda = new JLabel("Tienda");
		lblDatosTienda.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDatosTienda.setBounds(10, 107, 136, 22);
		lblDatosTienda.setForeground(Color.BLUE);
		add(lblDatosTienda);
		
		JButton btnTienda = new JButton("...");
		btnTienda.setBounds(174, 108, 43, 21);
		add(btnTienda);
		
		JLabel lblNombreTienda = new JLabel("Nombre");
		lblNombreTienda.setBounds(10, 138, 61, 16);
		lblNombreTienda.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombreTienda.setForeground(Color.BLACK);
		add(lblNombreTienda);
		
		JComboBox cbTienda = new JComboBox();
		cbTienda.setBounds(81, 133, 136, 21);
		add(cbTienda);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 168, 71, 13);
		lblProvincia.setHorizontalAlignment(SwingConstants.LEFT);
		lblProvincia.setVerticalAlignment(SwingConstants.BOTTOM);
		lblProvincia.setForeground(Color.BLACK);
		add(lblProvincia);
		
		JComboBox cbProvincia = new JComboBox();
		cbProvincia.setBounds(81, 160, 136, 21);
		add(cbProvincia);
		
		JComboBox cbCalle = new JComboBox();
		cbCalle.setBounds(81, 187, 136, 21);
		add(cbCalle);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 191, 61, 17);
		lblCalle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCalle.setHorizontalAlignment(SwingConstants.LEFT);
		lblCalle.setForeground(Color.BLACK);
		add(lblCalle);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(81, 213, 136, 19);
		tfAltura.setColumns(10);
		add(tfAltura);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 213, 56, -3);
		lblAltura.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAltura.setForeground(Color.BLACK);
		add(lblAltura);
		
		tfEntreCalles1 = new JTextField();
		tfEntreCalles1.setBounds(81, 234, 71, 19);
		tfEntreCalles1.setColumns(10);
		add(tfEntreCalles1);
		
		tfEntreCalles2 = new JTextField();
		tfEntreCalles2.setBounds(156, 234, 61, 19);
		tfEntreCalles2.setColumns(10);
		add(tfEntreCalles2);
		
		JLabel lblEntreCalles = new JLabel("Entre calles");
		lblEntreCalles.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEntreCalles.setBounds(10, 234, 91, 19);
		add(lblEntreCalles);
		
		tfPrecioProducto = new JTextField();
		tfPrecioProducto.setBounds(140, 257, 77, 19);
		add(tfPrecioProducto);
		tfPrecioProducto.setColumns(10);
		
		JLabel lblPrecioProducto = new JLabel("Precio del Producto");
		lblPrecioProducto.setBounds(10, 263, 120, 13);
		lblPrecioProducto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrecioProducto.setForeground(Color.BLACK);
		add(lblPrecioProducto);
		
		JButton btnRegistrarPrecio = new JButton("Registrar Precio");
		btnRegistrarPrecio.setBounds(10, 282, 207, 40);
		btnRegistrarPrecio.setBackground(Color.BLUE);
		btnRegistrarPrecio.setForeground(Color.WHITE);
		btnRegistrarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnRegistrarPrecio);
		
		JLabel lblAltura_1 = new JLabel("Altura");
		lblAltura_1.setBounds(10, 219, 92, 13);
		lblAltura_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAltura_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltura_1.setForeground(Color.BLACK);
		add(lblAltura_1);

	}
}
