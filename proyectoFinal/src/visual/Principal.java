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
import logico.Empleado;
import logico.Usuario;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagConstraints;

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
	private boolean inicioSesion = false;//==========================
	private JButton button;
	private JButton btnAtrasInicio;
	private JLabel lblimg;
	private JTextField textField;
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
	private JPanel pnOfertas;
	private JPanel panel_2;

	public static void main(String[] args) {
		Controladora.getInstance().getMisUsuarios().add(new Empleado("E1", "Oliver jose paulino perez", "oliver",
				"8097914801", "blah blah", "1230", 15000, true));
//		Controladora.getInstance().getMisUsuarios()
//				.add(new Cliente("E3", "Oscar pajaro", "oscar", "8097914801", "blah blah"));
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

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnReg = new JMenu("Registro");
		mnReg.setVisible(false);
		mnReg.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/reg.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		mnReg.setMargin(new Insets(5, 5, 5, 5));
		mnReg.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnReg);

		mntmNewMenuItem = new JMenuItem("Productos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegOption reg = new RegOption();
				reg.setModal(true);
				reg.setVisible(true);
				reg.setLocationRelativeTo(null);

			}
		});
		mnReg.add(mntmNewMenuItem);

		mnCl = new JMenu("Cliente");
		mnCl.setVisible(false);
		mnCl.setMargin(new Insets(5, 5, 5, 5));
		mnCl.setFont(new Font("Arial", Font.PLAIN, 14));
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
		mnAdmin.setVisible(false);
		mnAdmin.setMargin(new Insets(5, 5, 5, 5));
		mnAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
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
				Usuario user = Controladora.getInstance().buscarUsuarioByCorreo(txtCorreo.getText().toString());
				if (user != null) {
					pnContrasena.setVisible(true);
					pnInicioSesion.setVisible(false);
					Admin = (Empleado) user;
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
		btniniciosesion.setBounds(1773, 10, 111, 26);
		pnSuperior.add(btniniciosesion);

		lblimg = new JLabel("");
		lblimg.setVisible(false);
		ImageIcon img = new ImageIcon(Controladora.class.getResource("/img/user.png"));
		Image userimg = img.getImage();
		lblimg.setIcon(new ImageIcon(userimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		lblimg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (pnUser.isVisible() == true)
					pnUser.setVisible(false);
				else {
					pnUser.setVisible(true);
				}
			}
		});
		lblimg.setBounds(113, 3, 30, 30);
		lblimg.setBounds(1854, 8, 30, 30);
		pnSuperior.add(lblimg);

		textField = new JTextField();
		textField.setBounds(818, 13, 257, 20);
		pnSuperior.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Buscador:");
		lblNewLabel_1.setBounds(750, 16, 48, 14);
		pnSuperior.add(lblNewLabel_1);

		pnUser = new JPanel();
		pnUser.setBounds(1766, 47, 118, 47);
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
		lblNewLabel_2.setBounds(89, 0, 46, 14);
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
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					idSelected = new String(table.getValueAt(index, 0).toString());
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
		lblNewLabel_3.setBounds(10, 351, 55, 14);
		pnBuscarClientes.add(lblNewLabel_3);

		cbxbuscador = new JComboBox<String>();
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

		JButton btnNewButton = new JButton("Ofertas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton.getIcon().toString().contains("sortDown")) {
					btnNewButton.setBounds(781, 0, 89, 23);
					pnOfertas.setVisible(false);
					btnNewButton.setIcon(
							new ImageIcon(Principal.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
				} else {
					btnNewButton.setBounds(781, 162, 89, 23);
					pnOfertas.setVisible(true);
					btnNewButton.setIcon(
							new ImageIcon(Principal.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));

				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		btnNewButton.setBounds(781, 0, 89, 23);
		pnCentro.add(btnNewButton);

		pnOfertas = new JPanel();
		pnOfertas.setBackground(Color.LIGHT_GRAY);
		pnOfertas.setVisible(false);
		pnOfertas.setBounds(0, 0, 1666, 162);
		pnCentro.add(pnOfertas);
		pnOfertas.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		pnOfertas.add(scrollPane_2, BorderLayout.CENTER);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		scrollPane_2.setViewportView(panel_2);
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
			lblimg.setVisible(true);
			txtCorreo.setText("");
			txtcontra.setText("");
			mnCl.setVisible(true);
			mnReg.setVisible(true);
			pnBuscarClientes.setVisible(true);
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
			lblimg.setVisible(false);
			mnCl.setVisible(false);
			mnReg.setVisible(false);
			mnAdmin.setVisible(false);
		}

	}

	private void loadUsers() {
	    ArrayList<Usuario> users = Controladora.getInstance().cargarDatosUsuarios();
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
	                if ((filtro.equalsIgnoreCase("Nombre") && nombre.toLowerCase().contains(textoBuscador)) ||
	                    (filtro.equalsIgnoreCase("Email") && email.toLowerCase().contains(textoBuscador)) ||
	                    (filtro.equalsIgnoreCase("Direccion") && direccion.toLowerCase().contains(textoBuscador))) {
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
