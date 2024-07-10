package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
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
import logico.Usuario;

import java.awt.SystemColor;
import javax.swing.UIManager;

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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		menuBar.add(menuCon);
		
		menuCon2 = new JMenu("consumidor");
		menuBar.add(menuCon2);
		
		menuAdmin = new JMenu("Administrador");
		menuBar.add(menuAdmin);
		
		mnAdmin = new JMenu("Administrador");
		menuBar.add(mnAdmin);
		
		btnNewButton_1 = new JButton("Iniciar Sesion");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnInicioSesion.setVisible(true);
			}
		});
		menuBar.add(btnNewButton_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		pnInicioSesion = new JPanel();
		pnInicioSesion.setBackground(Color.WHITE);
		pnInicioSesion.setBounds(702, 231, 489, 271);
		panel.add(pnInicioSesion);
		pnInicioSesion.setLayout(null);
		pnInicioSesion.setVisible(false);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(SystemColor.text);
		btnEnviar.setBackground(new Color(66, 133, 244));
		btnEnviar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario user = Controladora.getInstance().buscarUsuarioByCorreo(txtCorreo.getText().toString());
				
				if(user != null) {
//					poner el panel de qeu se encontro, y pedir la contrasena
				}else {
//					poner a registrarse ya que no se encontro usuario
				}
				pnInicioSesion.setVisible(false);
			}
		});
		 btnEnviar.setBounds(366, 219, 89, 23);
	        btnEnviar.setFocusPainted(false);
	        btnEnviar.setBorder(BorderFactory.createLineBorder(new Color(66, 133, 244), 1));
	        btnEnviar.addActionListener(e -> panel.setVisible(false));
		pnInicioSesion.add(btnEnviar);
		
		txtCorreo = new JTextField();
		txtCorreo.setForeground(Color.BLACK);
		txtCorreo.setName("");
		txtCorreo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Correo Electronico", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		txtCorreo.setToolTipText("");
		txtCorreo.setBounds(106, 112, 276, 39);
		pnInicioSesion.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblNewLabel = new JLabel("Inicio De Sesion");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel.setBounds(164, 36, 161, 25);
		pnInicioSesion.add(lblNewLabel);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 35);
		setLocationRelativeTo(null);
		
	}
	
	
}
