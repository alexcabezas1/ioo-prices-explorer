package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import dominio.Producto;

public class BuscadorProductosDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JButton btnBuscar;
	private DefaultListModel<Producto> resultadosBusquedaModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscadorProductosDialog dialog = new BuscadorProductosDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscadorProductosDialog() {
		setTitle("Buscar un Producto");
		setBounds(100, 100, 307, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextField tfNombre = new JTextField();
		tfNombre.setBounds(10, 7, 183, 19);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(203, 6, 85, 21);
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 278, 202);
		contentPanel.add(scrollPane);
		
		resultadosBusquedaModel = new DefaultListModel<Producto>();
		JList listResultadosBusqueda = new JList<Producto>(resultadosBusquedaModel);
		scrollPane.setViewportView(listResultadosBusqueda);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);	
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void addResultadoBusqueda(ArrayList<Producto> resultados) {
		resultadosBusquedaModel.addAll(resultados);
	}
}
