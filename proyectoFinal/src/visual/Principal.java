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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import logico.Controladora;
import logico.Empleado;
import logico.Usuario;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;
	private JMenu menuCon2;
	private JMenu menuCon;
	private JMenu menuAdmin;
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
	private boolean inicioSesion = false;
	private JButton button;
	private JButton btnAtrasInicio;
	private JLabel lblimg;
	private JTextField textField;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JPanel panelizquierda;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JPanel pnCentro;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_4;

	public static void main(String[] args) {
		Controladora.getInstance().getMisUsuarios().add(new Empleado("E1", "Oliver jose paulino perez",
				"Oliver@gmail.com", "8097914801", "blah blah", "1230", 15000, false));
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

		menuCon = new JMenu("Registro");
		menuCon.setIcon(new ImageIcon(new ImageIcon(Principal.class.getResource("/img/reg.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		menuCon.setMargin(new Insets(5, 5, 5, 5));
		menuCon.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuCon);
		
		mntmNewMenuItem = new JMenuItem("Componentes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegOption reg = new RegOption();
				reg.setModal(true);
				reg.setVisible(true);
				reg.setLocationRelativeTo(null);
				
			}
		});
		menuCon.add(mntmNewMenuItem);

		menuCon2 = new JMenu("Cliente");
		menuCon2.setMargin(new Insets(5, 5, 5, 5));
		menuCon2.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuCon2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("A\u00F1adir cliente");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser addClient = new AddUser(null, "CLIENTE");
				addClient.setModal(true);
				addClient.setVisible(true);
			}
		});
		menuCon2.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Ver clientes");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListUsers listClients = new ListUsers("CLIENTE");
				listClients.setModal(true);
				listClients.setVisible(true);
			}
		});
		menuCon2.add(mntmNewMenuItem_4);

		menuAdmin = new JMenu("Administrador");
		menuAdmin.setMargin(new Insets(5, 5, 5, 5));
		menuAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuAdmin);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("A\u00F1adir empleado");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser addEmp = new AddUser(null, "EMPLEADO");
				addEmp.setModal(true);
				addEmp.setVisible(true);
			}
		});
		menuAdmin.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ver empleados");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListUsers listEmp = new ListUsers("EMPLEADO");
				listEmp.setModal(true);
				listEmp.setVisible(true);
			}
		});
		menuAdmin.add(mntmNewMenuItem_2);

		mnAdmin = new JMenu("Administrador");
		mnAdmin.setMargin(new Insets(5, 5, 5, 5));
		mnAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
		mnAdmin.setBackground(Color.WHITE);
		menuBar.add(mnAdmin);

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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1894, 47);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btniniciosesion = new JButton("Iniciar Sesion");
		btniniciosesion.setBounds(1773, 10, 111, 26);
		panel_1.add(btniniciosesion);

		lblimg = new JLabel("");
		lblimg.setVisible(false);
		ImageIcon img = new ImageIcon(Controladora.class.getResource("/img/user.png"));
        Image userimg = img.getImage();
        lblimg.setIcon(new ImageIcon(userimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        lblimg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if(panel_2.isVisible() == true)
            		panel_2.setVisible(false);
            	else {
            		panel_2.setVisible(true);
				}
            }
        });
        lblimg.setBounds(113, 3, 30, 30);
		lblimg.setBounds(1854, 8, 30, 30);
		panel_1.add(lblimg);
		
		textField = new JTextField();
		textField.setBounds(818, 13, 257, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Buscador:");
		lblNewLabel_1.setBounds(750, 16, 48, 14);
		panel_1.add(lblNewLabel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(1766, 47, 118, 34);
		panel_2.setVisible(false);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("Opciones");
		panel_2.add(btnNewButton, BorderLayout.CENTER);
		
		panelizquierda = new JPanel();
		panelizquierda.setBackground(Color.WHITE);
		panelizquierda.setBounds(0, 0, 191, 967);
		panel.add(panelizquierda);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(190, 47, 1704, 920);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		pnCentro = new JPanel();
		scrollPane.setViewportView(pnCentro);
		GridBagLayout gbl_pnCentro = new GridBagLayout();
		gbl_pnCentro.columnWidths = new int[]{0};
		gbl_pnCentro.rowHeights = new int[]{0};
		gbl_pnCentro.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pnCentro.rowWeights = new double[]{Double.MIN_VALUE};
		pnCentro.setLayout(gbl_pnCentro);
		btniniciosesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnInicioSesion.setVisible(true);
			}
		});
	}

	private void loadMenu() {
		if (inicioSesion) {
			btniniciosesion.setVisible(false);
			pnContrasena.setVisible(false);
			lblimg.setVisible(true);
		}
	}
}
