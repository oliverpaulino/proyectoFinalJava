 package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Computadora;
import logico.Controladora;
import logico.DiscoDuro;
import logico.Empleado;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.Order;
import logico.Product;
import logico.TarjetaMadre;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private float total =0;
	private JCheckBox chckbxValorFiscal;
	private JComboBox cbxMetodo;
	private JTextArea txtDireccion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion(Cliente cliente, Empleado empleado, Order order) {
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
		
		chckbxValorFiscal = new JCheckBox("Valor Fiscal");
		chckbxValorFiscal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxValorFiscal.isSelected()) {
					txtRNC.setEditable(true);
					
				}
				else {
					txtRNC.setText("");
					txtRNC.setEditable(false);
				}
			}
		});
		chckbxValorFiscal.setFont(new Font("Arial", Font.PLAIN, 16));
		chckbxValorFiscal.setBounds(429, 12, 109, 23);
		contentPanel.add(chckbxValorFiscal);
		
		lblCarrito = new JLabel("Carrito");
		lblCarrito.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCarrito.setBounds(421, 49, 109, 14);
		contentPanel.add(lblCarrito);
		
		lblMetodo = new JLabel("Metodo:");
		lblMetodo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMetodo.setBounds(29, 90, 67, 14);
		contentPanel.add(lblMetodo);
		
		cbxMetodo = new JComboBox();
		cbxMetodo.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Tarjeta", "Transferencia"}));
		cbxMetodo.setFont(new Font("Arial", Font.PLAIN, 14));
		cbxMetodo.setBounds(156, 85, 233, 20);
		contentPanel.add(cbxMetodo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre.setBounds(29, 157, 109, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(156, 155, 233, 20);
		contentPanel.add(txtNombre);
		
		JLabel lblNombre_1 = new JLabel("Telefono:");
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNombre_1.setBounds(29, 195, 109, 14);
		contentPanel.add(lblNombre_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(156, 190, 233, 20);
		contentPanel.add(txtTelefono);
		
		JLabel lblTelefono = new JLabel("Direccion");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTelefono.setBounds(29, 228, 109, 14);
		contentPanel.add(lblTelefono);
		
		txtDireccion = new JTextArea();
		txtDireccion.setEditable(false);
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDireccion.setBounds(156, 225, 233, 66);
		contentPanel.add(txtDireccion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnEliminar = new JButton("Eliminar de carrito");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					elimanarDelCarrito(codProduct);
					loadCarrito(cliente, empleado);
					
				}
			});
			buttonPane.add(btnEliminar);
			btnEliminar.setEnabled(false);
			btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnEliminar.setActionCommand("OK");
			{
				btnRealizar = new JButton("Realizar Compra");
				if (Controladora.getInstance().getCarrito().size()==0) {
					btnRealizar.setEnabled(false);
				}
				else {
					btnRealizar.setEnabled(true);
					
				}
				btnRealizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						realizarCompra(cliente, empleado, null);
						
						
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
		if (order!=null) {
			loadAuxOrder(order);
		}
		else {
			
			loadCarrito(cliente, empleado);
		}
	}
	private void loadAuxOrder(Order orderAux) {
		
		txtIdCliente.setText(orderAux.getClientId());
		txtNoFactura.setText(orderAux.getId());
		txtRNC.setText(orderAux.getRNC());
		txtTotal.setText(orderAux.getTotal()+"$");
		Cliente aux = (Cliente) Controladora.getInstance().findUserById(orderAux.getClientId());
		txtNombre.setText(aux.getNombre());
		txtTelefono.setText(aux.getNumero());
		txtDireccion.setText(aux.getDireccion());
		
		btnEliminar.setEnabled(false);
		btnRealizar.setEnabled(false);
		btnVaciarCarrito.setEnabled(false);
		chckbxValorFiscal.setEnabled(false);
		cbxMetodo.setEditable(false);
		
		
		
		modelo.setRowCount(0);
		row = new Object[table.getColumnCount()];
		total = 0;
		if(orderAux.getProducts() != null)
			for (Product product : orderAux.getProducts()) {
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
	
	private void loadCarrito(Cliente cliente, Empleado empleado) {
		
		txtIdCliente.setText(cliente.getId());
		Controladora.getInstance();
		txtNoFactura.setText("F-"+Controladora.idorder);
		txtNombre.setText(cliente.getNombre());
		txtTelefono.setText(cliente.getNumero());
		txtDireccion.setText(cliente.getDireccion());
		Controladora.getInstance();
		ArrayList<Product> carrito = Controladora.cargarDatos().getCarrito();
		modelo.setRowCount(0);
		row = new Object[table.getColumnCount()];
		total = 0;
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
		Controladora.getInstance().deleteProductFromCarrito(idProduct);
		
	}
	
	private void realizarCompra(Cliente cliente, Empleado empleado, Order orderAux) {
		
		DiscoDuro discoDuro = null;
		Microprocesador microprocesador = null;
		MemoriaRAM memoriaRAM = null;
		TarjetaMadre tarjetaMadre = null;
		
		ArrayList<Product>miCarrito = Controladora.getInstance().getCarrito();
		
		for (Product product : miCarrito) {
			if (product instanceof DiscoDuro) {
				discoDuro = (DiscoDuro) product;
			}
			else if (product instanceof Microprocesador) {
				microprocesador = (Microprocesador) product;
			} 
			else if (product instanceof MemoriaRAM) {
				memoriaRAM = (MemoriaRAM) product;
				
			}
			else if (product instanceof TarjetaMadre) {
				tarjetaMadre = (TarjetaMadre) product;
				
			}
			product.setCantidad(product.getCantidad()-1);
			
		}
		
		if (discoDuro!=null && microprocesador!=null && memoriaRAM != null &&tarjetaMadre!=null) {
			int option = JOptionPane.showConfirmDialog(null, "Desea que le armemos su computadora?", "Confirmación", JOptionPane.WARNING_MESSAGE);
			if(option == JOptionPane.YES_OPTION){
				total += 50;
			}
		}
		Date date = new Date();
		
		Order order = new Order(txtNoFactura.getText(), date, chckbxValorFiscal.isSelected()? true : false, cliente.getId(), empleado.getId(), miCarrito, total, cbxMetodo.getSelectedItem().toString());
		Controladora.getInstance().addOrder(order);
		JOptionPane.showMessageDialog(null, "Venta exitosa", "Productos",
				JOptionPane.INFORMATION_MESSAGE);
		Controladora.getInstance().setCarrito(new ArrayList<Product>());;
		Controladora.getInstance().guardarDatos();
		clean();
		dispose();
		
	}
	
	private void clean() {
		Controladora.getInstance();
		txtNoFactura.setText("F-"+Controladora.idorder);
		txtRNC.setText("");
		chckbxValorFiscal.setSelected(false);
		
	}
}
