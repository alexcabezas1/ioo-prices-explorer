package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlador.Controlador;

import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import dominio.Producto;


public class BuscadorProductosDialog extends JDialog implements ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JButton btnBuscar;
	private JList<Producto> listResultadosBusqueda;
	private DefaultListModel<Producto> resultadosBusquedaModel;
	private AltaPrecioPanel altaPrecioPanel;

	/**
	 * Create the dialog.
	 */
	public BuscadorProductosDialog(JFrame parent, AltaPrecioPanel altaPrecio) {
		super(parent);
		this.altaPrecioPanel = altaPrecio;
		
		setTitle("Buscar un Producto");
		setBounds(100, 100, 307, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(10, 7, 183, 19);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand(InterfazVista.ABUSCAR_PRODUCTOS_DESDE_ALTAPRECIO);
		btnBuscar.setBounds(203, 6, 85, 21);
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 278, 202);
		contentPanel.add(scrollPane);
		
		resultadosBusquedaModel = new DefaultListModel<Producto>();
		listResultadosBusqueda = new JList<Producto>(resultadosBusquedaModel);
		listResultadosBusqueda.setCellRenderer(new BuscadorListCellRenderer());
		listResultadosBusqueda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = this.listResultadosBusqueda.getSelectionModel();
		selectionModel.addListSelectionListener(this);
		scrollPane.setViewportView(listResultadosBusqueda);
		
		setContentPane(contentPanel);
	}
	
	public String getPalabraBusqueda() {
		return tfNombre.getText();
	}

	public void addListenerBuscarProducto(Controlador c) {
		this.btnBuscar.addActionListener(c);
	}
	
	public void agregarResultadosBusqueda(Collection<Producto> items) {
		resultadosBusquedaModel.addAll(items);
	}
	
	public void limpiar() {
		resultadosBusquedaModel.clear();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		altaPrecioPanel.setProductoElegido(listResultadosBusqueda.getSelectedValue());
	}
	
	class BuscadorListCellRenderer extends JLabel implements ListCellRenderer<Producto> {
		public BuscadorListCellRenderer() {
			setOpaque(true);
		}
	
		@Override
		public Component getListCellRendererComponent(JList<? extends Producto> list, Producto value, int index,
				boolean isSelected, boolean cellHasFocus) {
			
			String desc = "<html><b>" + value.obtenerNombre() + "</b>, " + 
					value.obtenerMarca().obtenerNombre() + " (<i>" + 
					value.obtenerTipo() + "</i>)</html>"; 
			setText(desc);

			if (isSelected){
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			}else{
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setFont(list.getFont());
		  	setEnabled(list.isEnabled());
		  	
			return this;
		}
	}

}
