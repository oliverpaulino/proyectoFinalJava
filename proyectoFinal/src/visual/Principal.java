package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Controladora;
import logico.DiscoDuro;
import logico.Empleado;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Usuario;
import visual.componentesVisuales.ListProduct;

import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;
	private JMenu mnCl;
	private JMenu mnReg;
	private JMenu mnAdmin;
	private JButton btniniciosesion;
	private JPanel pnInicioSesion;
	private JTextField txtCorreo;
	private JLabel lblNewLabel;
	private JButton btnContra;
	private JTextField txtcontra;
	private JButton btnNewButton_1;
	private JLabel lblinicio;
	private JPanel pnContrasena;
	private Empleado Admin = null;
	private boolean inicioSesion = false;// ==========================
	private JButton button;
	private JButton btnAtrasInicio;
	private JLabel lblUser;
	private JPanel pnUser;
	private JButton btnCierreSesion;
	private JPanel panelizquierda;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JPanel pnCentro;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_4;
	private JButton btnInfoPer;
	private JTable table;
	private DefaultTableModel modelo;
	private Object row[];
	private String idSelected;
	private JLabel lblNewLabel_3;
	private JTextField txtBuscadorCliente;
	private JComboBox<String> cbxbuscador;
	private JPanel pnBuscarClientes;
	private ListProduct listProduct;
	private JLabel lblCarrito;
	static Socket sfd = null;
	static ObjectOutputStream sld = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		Controladora.getInstance().addUser(new Empleado("", "", "", "", "", "", 0, true));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnReg = new JMenu("Registro");
		mnReg.setVisible(false);
		mnReg.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/torre-de-pc.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		mnReg.setMargin(new Insets(5, 5, 5, 5));
		mnReg.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnReg);

		mntmNewMenuItem = new JMenuItem("Registrar productos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegOption reg = new RegOption();
				reg.setModal(true);
				reg.setVisible(true);
				reg.setLocationRelativeTo(null);
				listProduct.loadComponents();

			}
		});
		mnReg.add(mntmNewMenuItem);

		mnCl = new JMenu("Cliente");
		mnCl.setVisible(false);
		mnCl.setMargin(new Insets(5, 5, 5, 5));
		mnCl.setFont(new Font("Arial", Font.PLAIN, 14));
		mnCl.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/personas.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		menuBar.add(mnCl);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("A\u00F1adir cliente");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser addClient = new AddUser(null, "CLIENTE");
				addClient.setModal(true);
				addClient.setVisible(true);
//				Controladora.getInstance().guardarDatosUsuario();
				loadUsers();
			}
		});
		mnCl.add(mntmNewMenuItem_3);

		mntmNewMenuItem_4 = new JMenuItem("Ver clientes");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListUsers listClients = new ListUsers("CLIENTE");
				listClients.setModal(true);
				listClients.setVisible(true);
				loadUsers();
			}
		});
		mnCl.add(mntmNewMenuItem_4);

		mnAdmin = new JMenu("Administrador");
		mnAdmin.setHorizontalAlignment(SwingConstants.LEFT);
		mnAdmin.setVisible(false);
		mnAdmin.setMargin(new Insets(5, 5, 5, 5));
		mnAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
		mnAdmin.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/apoyo-tecnico.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		menuBar.add(mnAdmin);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("A\u00F1adir empleado");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser addEmp = new AddUser(null, "EMPLEADO");
				addEmp.setModal(true);
				addEmp.setVisible(true);
			}
		});
		mnAdmin.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ver empleados");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListUsers listEmp = new ListUsers("EMPLEADO");
				listEmp.setModal(true);
				listEmp.setVisible(true);
				loadMenu();
			}
		});
		mnAdmin.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Ver facturas");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListFacturacion listFacturacion = new ListFacturacion();
				listFacturacion.setModal(true);
				listFacturacion.setVisible(true);

			}
		});
		mnAdmin.add(mntmNewMenuItem_5);

		btnNewButton_1 = new JButton("Iniciar Sesion");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnInicioSesion.setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 35);
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		pnInicioSesion = new JPanel();
		pnInicioSesion.setVisible(false);
		pnInicioSesion.setBackground(Color.WHITE);
		pnInicioSesion.setBounds(702, 231, 489, 271);
		panel.add(pnInicioSesion);
		pnInicioSesion.setLayout(null);

		JButton btnEnviar = new JButton("Siguiente");
		btnEnviar.setBorderPainted(false);
		btnEnviar.setFocusTraversalKeysEnabled(false);
		btnEnviar.setFocusable(false);
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviar.setBackground(new Color(66, 133, 244));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEnviar.setBackground(new Color(66, 133, 244));
			}
		});
		btnEnviar.setBackground(new Color(66, 133, 244));
		btnEnviar.setForeground(Color.BLACK);
		btnEnviar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado user = Controladora.getInstance().buscarEmpleadoByCorreo(txtCorreo.getText().toString());
				if (user != null) {
					pnContrasena.setVisible(true);
					pnInicioSesion.setVisible(false);
					Admin = user;
				} else {
					JOptionPane.showMessageDialog(null, "No encontramos ningun email, hable con el manager", "Registro",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEnviar.setBounds(366, 219, 89, 23);
		btnEnviar.setFocusPainted(false);
		btnEnviar.setBorder(BorderFactory.createLineBorder(new Color(66, 133, 244), 1));
		pnInicioSesion.add(btnEnviar);

		txtCorreo = new JTextField();
		txtCorreo.setForeground(Color.BLACK);
		txtCorreo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Correo Electronico",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		txtCorreo.setBounds(106, 112, 276, 39);
		pnInicioSesion.add(txtCorreo);
		txtCorreo.setColumns(10);

		lblNewLabel = new JLabel("Inicio De Sesion");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel.setBounds(164, 36, 161, 25);
		pnInicioSesion.add(lblNewLabel);

		btnAtrasInicio = new JButton("<");
		btnAtrasInicio.setFocusPainted(false);
		btnAtrasInicio.setFocusTraversalKeysEnabled(false);
		btnAtrasInicio.setBorderPainted(false);
		btnAtrasInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnInicioSesion.setVisible(false);
				txtCorreo.setText("");
			}
		});
		btnAtrasInicio.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAtrasInicio.setBorder(null);
		btnAtrasInicio.setBackground(new Color(66, 133, 244));
		btnAtrasInicio.setForeground(Color.BLACK);
		btnAtrasInicio.setBounds(56, 218, 89, 23);
		pnInicioSesion.add(btnAtrasInicio);

		pnContrasena = new JPanel();
		pnContrasena.setVisible(false);
		pnContrasena.setBounds(702, 231, 489, 271);
		panel.add(pnContrasena);
		pnContrasena.setBackground(Color.WHITE);
		pnContrasena.setLayout(null);

		btnContra = new JButton("Enviar");
		btnContra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passw = txtcontra.getText().toString();
				if (Admin.getPassword().equals(passw)) {
					JOptionPane.showMessageDialog(null, "Su inicio de sesion ha sido exitosa!", "Inicio de Sesion",
							JOptionPane.INFORMATION_MESSAGE);
					inicioSesion = true;
					loadMenu();
				} else {
					JOptionPane.showMessageDialog(null, "Correo o contrasena son incorrectos!", "Inicio de Sesion",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnContra.setBounds(366, 219, 89, 23);
		btnContra.setForeground(Color.BLACK);
		btnContra.setBackground(Color.WHITE);
		btnContra.setBorder(new LineBorder(new Color(66, 133, 244), 1, true));
		btnContra.setBackground(new Color(66, 133, 244));
		pnContrasena.add(btnContra);

		txtcontra = new JPasswordField();
		txtcontra.setForeground(Color.BLACK);
		txtcontra.setBounds(106, 112, 276, 39);
		txtcontra.setColumns(10);
		txtcontra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contrasena del correo",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		pnContrasena.add(txtcontra);

		lblinicio = new JLabel("Inicio De Sesion");
		lblinicio.setBounds(164, 36, 161, 25);
		lblinicio.setBackground(SystemColor.textHighlight);
		lblinicio.setForeground(SystemColor.textHighlight);
		lblinicio.setFont(new Font("Arial", Font.BOLD, 21));
		pnContrasena.add(lblinicio);

		button = new JButton("Atras");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnContrasena.setVisible(false);
				pnInicioSesion.setVisible(true);
			}
		});
		button.setBounds(55, 218, 89, 23);
		pnContrasena.add(button);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Arial", Font.ITALIC, 12));
		button.setBorder(null);
		button.setBackground(Color.WHITE);

		JPanel pnSuperior = new JPanel();
		pnSuperior.setBackground(Color.WHITE);
		pnSuperior.setBounds(0, 0, 1894, 47);
		panel.add(pnSuperior);
		pnSuperior.setLayout(null);

		btniniciosesion = new JButton("Iniciar Sesion");
		btniniciosesion.setBounds(1773, 12, 111, 26);
		pnSuperior.add(btniniciosesion);

		lblUser = new JLabel("");
		lblUser.setVisible(false);
		ImageIcon img = new ImageIcon(Controladora.class.getResource("/img/user.png"));
		Image userimg = img.getImage();
		lblUser.setIcon(new ImageIcon(userimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		lblUser.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (pnUser.isVisible() == true)
					pnUser.setVisible(false);
				else {
					pnUser.setVisible(true);
				}
			}
		});
		lblUser.setBounds(1804, 12, 30, 30);
		lblUser.setBounds(1854, 8, 30, 30);
		pnSuperior.add(lblUser);

		lblCarrito = new JLabel("");
		lblCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cliente cliente = (Cliente) Controladora.getInstance().findUserByCorreo(idSelected);
				if (cliente != null) {

					Facturacion facturacion = new Facturacion(cliente, Admin, null);

					facturacion.setModal(true);
					facturacion.setVisible(true);
				} else {

					JOptionPane.showMessageDialog(null, "Debe de elegir un cliente", "Productos",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		lblCarrito.setVisible(false);
		ImageIcon imgCarrito = new ImageIcon(Controladora.class.getResource("/img/carrito-de-compras.png"));
		Image carritoImg = imgCarrito.getImage();

		lblCarrito.setIcon(new ImageIcon(carritoImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

		lblCarrito.setBounds(1800, 6, 30, 35);
		pnSuperior.add(lblCarrito);

		pnUser = new JPanel();
		pnUser.setBounds(1766, 47, 118, 69);
		pnUser.setVisible(false);
		panel.add(pnUser);
		pnUser.setLayout(null);

		btnCierreSesion = new JButton("Cerrar Sesion");
		btnCierreSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea cerrar la sesion?",
						"Cierre de Sesion", JOptionPane.WARNING_MESSAGE);

				if (option == JOptionPane.YES_OPTION) {
					inicioSesion = false;
					loadMenu();
				} else {
					pnUser.setVisible(false);
				}
				// poner que se cierre la sesion

				// hacer lso de ocultar las ventanas dependiendo del cargo de la persona.
			}
		});
		btnCierreSesion.setBounds(0, 23, 118, 23);
		pnUser.add(btnCierreSesion);

		btnInfoPer = new JButton("Datos Personales");
		btnInfoPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosPersonales d = new DatosPersonales(Admin);
				d.setModal(true);
				d.setVisible(true);
			}
		});
		btnInfoPer.setBounds(0, 0, 118, 23);
		pnUser.add(btnInfoPer);

		JButton respaldobtn = new JButton("Respaldo");
		respaldobtn.setBounds(0, 46, 118, 23);
		pnUser.add(respaldobtn);
		respaldobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sfd = new Socket("localhost", 7000);
					ObjectOutputStream sld = new ObjectOutputStream(sfd.getOutputStream());
					Controladora controlador = Controladora.getInstance();
					sld.writeObject(controlador);
					sld.flush();

				} catch (UnknownHostException uhe) {
					System.out.println("No se puede acceder al servidor.");
					System.exit(1);
				} catch (IOException ioe) {
					System.out.println("Comunicación rechazada.");
					System.exit(1);
				} finally {
					try {
						if (sld != null) {
							sld.close();
						}
						if (sfd != null) {
							sfd.close();
						}
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});

		panelizquierda = new JPanel();
		panelizquierda.setBackground(Color.WHITE);
		panelizquierda.setBounds(0, 47, 244, 920);
		panel.add(panelizquierda);
		panelizquierda.setLayout(null);

		modelo = new DefaultTableModel();
		String[] headers = { "Nombre", "Email", "Direccion" };
		modelo.setColumnIdentifiers(headers);

		pnBuscarClientes = new JPanel();
		pnBuscarClientes.setBorder(null);
		pnBuscarClientes.setVisible(false);
		pnBuscarClientes.setBackground(Color.WHITE);
		pnBuscarClientes.setBounds(10, 11, 224, 414);
		panelizquierda.add(pnBuscarClientes);
		pnBuscarClientes.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Clientes:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(89, 0, 55, 14);
		pnBuscarClientes.add(lblNewLabel_2);

		txtBuscadorCliente = new JTextField();
		txtBuscadorCliente.setBounds(10, 25, 206, 20);
		pnBuscarClientes.add(txtBuscadorCliente);
		txtBuscadorCliente.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				loadUsers();
			}

			public void removeUpdate(DocumentEvent e) {
				loadUsers();
			}

			public void changedUpdate(DocumentEvent e) {
				loadUsers();
			}
		});
		txtBuscadorCliente.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 56, 206, 281);
		pnBuscarClientes.add(scrollPane_1);
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					idSelected = new String(table.getValueAt(index, 1).toString());
					// btnDelete.setEnabled(true);
					// btnEdit.setEnabled(true);
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane_1.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 56, 206, 281);
		pnBuscarClientes.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblNewLabel_3 = new JLabel("Buscar por:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 351, 70, 14);
		pnBuscarClientes.add(lblNewLabel_3);

		cbxbuscador = new JComboBox<String>();
		cbxbuscador.setFont(new Font("Arial", Font.PLAIN, 12));
		cbxbuscador.setBounds(90, 348, 126, 20);
		pnBuscarClientes.add(cbxbuscador);
		cbxbuscador.setModel(new DefaultComboBoxModel<String>(new String[] { "Nombre", "Email", "Direccion" }));

		panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(241, 47, 1653, 920);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);

		pnCentro = new JPanel();
		scrollPane.setViewportView(pnCentro);
		pnCentro.setLayout(null);

		listProduct = new ListProduct();
		listProduct.setBounds(10, 11, 1631, 883);
		listProduct.setVisible(false);

		pnCentro.add(listProduct);

		btniniciosesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnInicioSesion.setVisible(true);
			}
		});
		loadUsers();
	}

	public void loadMenu() {
		if (inicioSesion) {
			btniniciosesion.setVisible(false);
			pnContrasena.setVisible(false);
			lblUser.setVisible(true);
			lblCarrito.setVisible(true);
			txtCorreo.setText("");
			txtcontra.setText("");
			mnCl.setVisible(true);
			mnReg.setVisible(true);
			pnBuscarClientes.setVisible(true);
			listProduct.setVisible(true);
			if (Admin.isManager())
				mnAdmin.setVisible(true);
			else {
				mnAdmin.setVisible(false);
			}

			// cierra la sesion o sale
		} else {
			pnBuscarClientes.setVisible(false);
			pnUser.setVisible(false);
			Admin = null;
			btniniciosesion.setVisible(true);
			lblUser.setVisible(false);
			lblCarrito.setVisible(false);
			mnCl.setVisible(false);
			mnReg.setVisible(false);
			mnAdmin.setVisible(false);
			listProduct.setVisible(false);
		}

	}

	private void loadUsers() {
		ArrayList<Usuario> users = Controladora.getInstance().getMisUsuarios();
		String textoBuscador = txtBuscadorCliente.getText().toLowerCase();
		modelo.setRowCount(0); // Limpia el modelo antes de cargar nuevos datos

		if (users != null && !users.isEmpty()) {
			for (Usuario user : users) {
				if (user instanceof Cliente) {
					String nombre = user.getNombre();
					String email = user.getEmail();
					String direccion = user.getDireccion();

					// Filtrar según el tipo de búsqueda seleccionado
					String filtro = cbxbuscador.getSelectedItem().toString();
					if ((filtro.equalsIgnoreCase("Nombre") && nombre.toLowerCase().contains(textoBuscador))
							|| (filtro.equalsIgnoreCase("Email") && email.toLowerCase().contains(textoBuscador))
							|| (filtro.equalsIgnoreCase("Direccion")
									&& direccion.toLowerCase().contains(textoBuscador))) {
						// Agregar fila al modelo
						Object[] row = { nombre, email, direccion };
						modelo.addRow(row);
					}
				}
			}
		} else {
			System.out.println("No se encontraron usuarios para cargar.");
		}

		table.setModel(modelo); // Establecer el modelo en la tabla
	}
}
