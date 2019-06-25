package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlador.Controlador;
import dominio.Direccion;
import dominio.Tienda;

public class BuscadorTiendasDialog extends JDialog implements ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfDescripcion;
	private JButton btnBuscar;
	private JList<Tienda> listResultadosBusqueda;
	private DefaultListModel<Tienda> resultadosBusquedaModel;
	private AltaPrecioPanel altaPrecioPanel;

	/**
	 * Create the dialog.
	 */
	public BuscadorTiendasDialog(JFrame parent, AltaPrecioPanel altaPrecio) {
		super(parent);
		this.altaPrecioPanel = altaPrecio;
		
		setTitle("Buscar una tienda");
		setBounds(100, 100, 307, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(10, 7, 183, 19);
		contentPanel.add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand(InterfazVistaAltaPrecio.ABUSCAR_TIENDAS_DESDE_ALTAPRECIO);
		btnBuscar.setBounds(203, 6, 85, 21);
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 278, 202);
		contentPanel.add(scrollPane);
		
		resultadosBusquedaModel = new DefaultListModel<Tienda>();
		listResultadosBusqueda = new JList<Tienda>(resultadosBusquedaModel);
		listResultadosBusqueda.setCellRenderer(new BuscadorListCellRenderer());
		listResultadosBusqueda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = this.listResultadosBusqueda.getSelectionModel();
		selectionModel.addListSelectionListener(this);
		scrollPane.setViewportView(listResultadosBusqueda);
	}

	public String getPalabraBusqueda() {
		return tfDescripcion.getText();
	}

	public void addListenerBuscarTienda(Controlador c) {
		this.btnBuscar.addActionListener(c);
	}
	
	public void agregarResultadosBusqueda(Collection<Tienda> items) {
		resultadosBusquedaModel.addAll(items);
	}
	
	public void limpiar() {
		resultadosBusquedaModel.clear();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (listResultadosBusqueda.getSelectedValue() != null) {
			altaPrecioPanel.setTiendaElegida(listResultadosBusqueda.getSelectedValue());
		}
	}
	
	class BuscadorListCellRenderer extends JLabel implements ListCellRenderer<Tienda>{
		public BuscadorListCellRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Tienda> list, Tienda value, int index,
				boolean isSelected, boolean cellHasFocus) {
			Direccion direccion = value.obtenerDireccion();
			String desc = value.obtenerNombre() + ", " +
						  direccion.obtenerCalle() + " " +
						  String.valueOf(direccion.obtenerAltura()) + " (" +
						  direccion.obtenerEntreCalle1() + " y " +
						  direccion.obtenerEntreCalle2() + ")";
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
