package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JMenu menuCon2;
	private JMenu menuCon;
	private JMenu menuAdmin;
	private JMenu mnAdmin;
	private JRadioButton selectConsumidor;
	private JRadioButton selectAdministrador;
	private JButton btnNewButton_1;
	private JPanel panelEntrada;

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
		
		btnNewButton_1 = new JButton("Cambiar modo Entrada");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEntrada.setVisible(true);
			}
		});
		menuBar.add(btnNewButton_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelEntrada = new JPanel();
		panelEntrada.setBackground(Color.LIGHT_GRAY);
		panelEntrada.setBounds(467, 241, 568, 251);
		panel.add(panelEntrada);
		panelEntrada.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Como quisiera entrar usted?");
		lblNewLabel.setBounds(23, 11, 225, 14);
		panelEntrada.add(lblNewLabel);
		
		selectAdministrador = new JRadioButton("Administrador");
		selectAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectConsumidor.setSelected(false);
				loadMenu();
			}
		});
		selectAdministrador.setBounds(56, 53, 109, 23);
		panelEntrada.add(selectAdministrador);
		
		selectConsumidor = new JRadioButton("Consumidor");
		selectConsumidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAdministrador.setSelected(false);
				loadMenu();
			}
		});
		selectConsumidor.setBounds(56, 79, 109, 23);
		panelEntrada.add(selectConsumidor);
		
		JButton btnNewButton = new JButton("entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEntrada.setVisible(false);
			}
		});
		btnNewButton.setBounds(43, 128, 89, 23);
		panelEntrada.add(btnNewButton);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height - 35);
		setLocationRelativeTo(null);
		
		loadMenu();
	}
	
	private void loadMenu() {
		if(selectAdministrador.isSelected()) {
			menuAdmin.setVisible(true);
			mnAdmin.setVisible(true);
			menuCon.setVisible(false);
			menuCon2.setVisible(false);
		}else if(selectConsumidor.isSelected()) {
			menuAdmin.setVisible(false);
			mnAdmin.setVisible(false);
			menuCon.setVisible(true);
			menuCon2.setVisible(true);
		}else {
			menuAdmin.setVisible(false);
			mnAdmin.setVisible(false);
			menuCon.setVisible(false);
			menuCon2.setVisible(false);
			
		}
	}
}
