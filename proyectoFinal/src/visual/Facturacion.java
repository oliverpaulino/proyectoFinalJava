 package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Computadora;
import logico.Controladora;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.Product;
import logico.TarjetaMadre;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelo;
	private static Object row[];
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtNoFactura;
	private JTextField txtTotal;
	private JButton btnEliminar;
	private JButton btnRealizar;
	private JButton btnVaciarCarrito;
	private String codProduct;
	private JTextField txtIdCliente;
	private JLabel lblCliente;
	private JLabel lblRnc;
	private JTextField txtRNC;
	private JLabel lblCarrito;
	private JLabel lblMetodo;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion(Cliente cliente) {
		setTitle("Facturacion");
		setBounds(100, 100, 586, 381);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(399, 73, 161, 192);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		if (cliente==null) {
			
		}
		
		modelo = new DefaultTableModel();
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if(index>=0){
					btnEliminar.setEnabled(true);
					codProduct = new String(table.getValueAt(index, 0).toString());
					
					
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] headers = {"Id", "Tipo", "Precio"};
		modelo.setColumnIdentifiers(headers);
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel = new JLabel("No. factura");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 16, 109, 14);
		contentPanel.add(lblNewLabel);
		
		txtNoFactura = new JTextField();
		txtNoFactura.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNoFactura.setEditable(false);
		txtNoFactura.setText("F-"+Controladora.getInstance().idorder);
		txtNoFactura.setBounds(156, 15, 233, 20);
		contentPanel.add(txtNoFactura);
		txtNoFactura.setColumns(10);
		
		JLabel lblTotal = new JLabel("TOTAL: ");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTotal.setBounds(399, 277, 67, 14);
		contentPanel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTotal.setEditable(false);
		txtTotal.setBounds(476, 276, 84, 20);
		contentPanel.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setText(cliente.getId());
		txtIdCliente.setEditable(false);
		txtIdCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(156, 120, 233, 20);
		contentPanel.add(txtIdCliente);
		
		lblCliente = new JLabel("ID cliente:");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCliente.setBounds(29, 122, 109, 14);
		contentPanel.add(lblCliente);
		
		lblRnc = new JLabel("RNC:");
		lblRnc.setFont(new Font("Arial", Font.PLAIN, 16));
		lblRnc.setBounds(29, 52, 67, 14);
		contentPanel.add(lblRnc);
		
		txtRNC = new JTextField();
		txtRNC.setEditable(false);
		txtRNC.setFont(new Font("Arial", Font.PLAIN, 14));
		txtRNC.setColumns(10);
		txtRNC.setBounds(156, 50, 234, 20);
		contentPanel.add(txtRNC);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Valor Fiscal");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					txtRNC.setEditable(true);
					
				}
				else {
					txtRNC.setText("");
					txtRNC.setEditable(false);
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(429, 12, 109, 23);
		contentPanel.add(chckbxNewCheckBox);
		
		lblCarrito = new JLabel("Carrito");
		lblCarrito.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCarrito.setBounds(421, 49, 109, 14);
		contentPanel.add(lblCarrito);
		
		lblMetodo = new JLabel("Metodo:");
		lblMetodo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMetodo.setBounds(29, 90, 67, 14);
		contentPanel.add(lblMetodo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Tarjeta", "Transferencia"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(156, 85, 233, 20);
		contentPanel.add(comboBox);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(29, 157, 109, 14);
		contentPanel.add(lblNombre);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(cliente.getNombre());
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(156, 155, 233, 20);
		contentPanel.add(textField);
		
		JLabel lblNombre_1 = new JLabel("Telefono:");
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre_1.setBounds(29, 195, 109, 14);
		contentPanel.add(lblNombre_1);
		
		textField_1 = new JTextField();
		textField_1.setText(cliente.getNumero());
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(156, 190, 233, 20);
		contentPanel.add(textField_1);
		
		JLabel lblTelefono = new JLabel("Direccion");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefono.setBounds(29, 228, 109, 14);
		contentPanel.add(lblTelefono);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setText(cliente.getDireccion());
		textArea.setBounds(156, 225, 233, 66);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnEliminar = new JButton("Eliminar de carrito");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					elimanarDelCarrito(codProduct);
				}
			});
			buttonPane.add(btnEliminar);
			btnEliminar.setEnabled(false);
			btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnEliminar.setActionCommand("OK");
			{
				btnRealizar = new JButton("Realizar Compra");
				btnRealizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btnRealizar.setFont(new Font("Arial", Font.PLAIN, 14));
				btnRealizar.setActionCommand("OK");
				buttonPane.add(btnRealizar);
				getRootPane().setDefaultButton(btnRealizar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						dispose();
					}
				});
				
				btnVaciarCarrito = new JButton("Vaciar Carrito");
				btnVaciarCarrito.setFont(new Font("Arial", Font.PLAIN, 14));
				btnVaciarCarrito.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Controladora.getInstance().setCarrito(new ArrayList<Product>());;
						Controladora.getInstance().guardarDatos();
						dispose();
					}
				});
				btnVaciarCarrito.setActionCommand("Cancel");
				buttonPane.add(btnVaciarCarrito);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadCarrito();
	}
	
	private void loadCarrito() {
		Controladora.getInstance();
		ArrayList<Product> carrito = Controladora.cargarDatos().getCarrito();
		modelo.setRowCount(0);
		row = new Object[table.getColumnCount()];
		float total = 0;
		if(carrito != null)
			for (Product product : carrito) {
				row[0] = product.getId();
				row[1] = product.getModelo();
				if (product instanceof DiscoDuro) {
					row[1] = "Disco duro";
				} 
				else if (product instanceof MemoriaRAM) {
					row[1] = "RAM";
					
				}
				else if (product instanceof Microprocesador) {
					row[1] = "Micro Procesador";
				}
				else if (product instanceof TarjetaMadre) {
					row[1] = "Tarjeta Madre";
					
				}
				else if (product instanceof Computadora) {
					row[1] = "Computadora";
					
				}
				
	
				row[2]=  product.getPrecio();
				modelo.addRow(row);
				total+=product.getPrecio();
			}
		txtTotal.setText(total+"$");
		
		
	}
	
	private void elimanarDelCarrito(String idProduct) {
		System.out.println("hola");
		Controladora.getInstance().deleteProductFromCarrito(idProduct);
		loadCarrito();
		
	}
}
