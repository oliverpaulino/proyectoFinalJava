package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import logico.Controladora;
import logico.Empleado;
import logico.Usuario;

import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;
	private JMenu menuCon2;
	private JMenu menuCon;
	private JMenu menuAdmin;
	private JMenu mnAdmin;
	private JButton btnNewButton_1;
	private JPanel pnInicioSesion;
	private JTextField txtCorreo;
	private JLabel lblNewLabel;
	private JButton btnContra;
	private JTextField txtcontra;
	private JLabel lblinicio;
	private Panel pnContrasena;
	private JButton btnatras;
	private JPanel pnRegistro;
	private JLabel lblRegistro;
	private JButton btnSigReg;
	private Empleado Admin = null;
	private JPanel panel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Controladora.getInstance().getMisUsuarios().add(new Empleado("E1", "Oliver", "Oliver@gmail.com", "8097914801", "blah blah", "1230", 15000, false));
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

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuCon = new JMenu("menu");
		menuCon.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuCon);
		
		menuCon2 = new JMenu("consumidor");
		menuCon2.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuCon2);
		
		menuAdmin = new JMenu("Administrador");
		menuAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuAdmin);
		
		mnAdmin = new JMenu("Administrador");
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
		
		panel_1 = new JPanel();
		menuBar.add(panel_1);
		menuBar.add(btnNewButton_1);
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
		
		pnContrasena = new Panel();
		pnContrasena.setVisible(false);
		pnContrasena.setBackground(Color.WHITE);
		pnContrasena.setBounds(702, 231, 489, 271);
		pnContrasena.setLayout(null);
		
		pnRegistro =  new JPanel();
		pnRegistro.setVisible(false);
		pnRegistro.setBackground(Color.WHITE);
		pnRegistro.setBounds(702, 156, 489, 383);
		pnRegistro.setLayout(null);
		panel.add(pnRegistro);
		
		lblRegistro = new JLabel("Registro");
		lblRegistro.setForeground(SystemColor.textHighlight);
		lblRegistro.setFont(new Font("Arial", Font.BOLD, 21));
		lblRegistro.setBackground(SystemColor.textHighlight);
		lblRegistro.setBounds(202, 21, 85, 25);
		pnRegistro.add(lblRegistro);
		
		btnSigReg = new JButton("Siguiente");
		btnSigReg.setForeground(Color.WHITE);
		btnSigReg.setFocusPainted(false);
		btnSigReg.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSigReg.setBackground(new Color(66, 133, 244));
		btnSigReg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSigReg.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSigReg.setBackground(new Color(66, 133, 244));
			}
		});
		btnSigReg.setBounds(388, 348, 89, 23);
		pnRegistro.add(btnSigReg);
		panel.add(pnContrasena);
		pnContrasena.setLayout(null);
		
		btnContra = new JButton("Enviar");
		btnContra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passw = txtcontra.getText().toString();
				if(Admin.getPassword().equals(passw)) {
					JOptionPane.showMessageDialog(null, "Su inicio de sesion ha sido exitosa!", "Inicio de Sesion", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Correo o contrasena son incorrectos!", "Inicio de Sesion", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnContra.setBounds(366, 219, 89, 23);
		btnContra.setForeground(SystemColor.text);
		btnContra.setBackground(new Color(66, 133, 244));
		btnContra.setBorder(BorderFactory.createLineBorder(new Color(66, 133, 244), 1));
		btnContra.setBackground(new Color(66, 133, 244));
		pnContrasena.add(btnContra);
		
		txtcontra = new JTextField();
		txtcontra.setForeground(Color.BLACK);
		txtcontra.setBounds(106, 112, 276, 39);
		txtcontra.setColumns(10);
		txtcontra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contrasena del correo", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		pnContrasena.add(txtcontra);
		
		lblinicio = new JLabel("Inicio De Sesion");
		lblinicio.setBounds(164, 36, 161, 25);	
		lblinicio.setBackground(SystemColor.textHighlight);
		lblinicio.setForeground(SystemColor.textHighlight);
		lblinicio.setFont(new Font("Arial", Font.BOLD, 21));
		pnContrasena.add(lblinicio);
		
		btnatras = new JButton("Atras");
		btnatras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnContrasena.setVisible(false);
				pnInicioSesion.setVisible(true);
			}
		});
		btnatras.setFont(new Font("Arial", Font.ITALIC, 12));
		btnatras.setBackground(Color.WHITE);
		btnatras.setBorder(null);
		btnatras.setForeground(new Color(66, 133, 244));
		btnatras.setBounds(55, 219, 89, 23);
		btnatras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnatras.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12)); // Cambia el estilo del texto
				btnatras.setText("<html><u>Atras</u></html>"); // Subraya el texto
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnatras.setFont(new Font("Arial", Font.ITALIC, 12)); // Restaura el estilo original
				btnatras.setText("Atras"); // Quita el subrayado
			}
		});
		pnContrasena.add(btnatras);
		
		pnInicioSesion = new JPanel();
		pnInicioSesion.setVisible(false);
		pnInicioSesion.setBackground(Color.WHITE);
		pnInicioSesion.setBounds(702, 231, 489, 271);
		panel.add(pnInicioSesion);
		pnInicioSesion.setLayout(null);
		
		JButton btnEnviar = new JButton("Siguiente");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviar.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEnviar.setBackground(new Color(66, 133, 244));
			}
		});
		btnEnviar.setForeground(SystemColor.text);
		btnEnviar.setBackground(new Color(66, 133, 244));
		btnEnviar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario user = Controladora.getInstance().buscarUsuarioByCorreo(txtCorreo.getText().toString());
				pnInicioSesion.setVisible(false);
				if(user != null) {
					pnContrasena.setVisible(true);
					Admin = (Empleado) user;
//					poner el panel de qeu se encontro, y pedir la contrasena
				}else {
					int option = JOptionPane.showConfirmDialog(null, "No encontramos ningun email, desea crear uno?", "Registro", JOptionPane.WARNING_MESSAGE);
					if(option == JOptionPane.CANCEL_OPTION ) {
						pnInicioSesion.setVisible(true);
					}else {
						pnRegistro.setVisible(true);
					}
//					poner a registrarse ya que no se encontro usuario
				}
			}
		});
		 btnEnviar.setBounds(366, 219, 89, 23);
	        btnEnviar.setFocusPainted(false);
	        btnEnviar.setBorder(BorderFactory.createLineBorder(new Color(66, 133, 244), 1));
		pnInicioSesion.add(btnEnviar);
		
		txtCorreo = new JTextField();
		txtCorreo.setForeground(Color.BLACK);
		txtCorreo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Correo Electronico", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		txtCorreo.setBounds(106, 112, 276, 39);
		pnInicioSesion.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblNewLabel = new JLabel("Inicio De Sesion");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel.setBounds(164, 36, 161, 25);
		pnInicioSesion.add(lblNewLabel);
		
		
		
		
	}
}