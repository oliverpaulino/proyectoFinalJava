package visual;

import java.awt.BorderLayout;
import visual.componentesVisuales.RegComp;
import visual.componentesVisuales.RegPC;
import visual.componentesVisuales.RegOfertas;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import logico.Controladora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class RegOption extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private RegComp regDiscoDuro = new RegComp(0);
	private RegComp regProcesador = new RegComp(1);
	private RegComp regRam = new RegComp(2);
	private RegComp regTarjeta = new RegComp(3);
	private JPanel optionPanel;

	// Set System L&F

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			RegOption dialog = new RegOption();

			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegOption() {
		setResizable(false);
		setTitle("Registro de Productos");
		setBounds(100, 100, 616, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			optionPanel = new JPanel();
			optionPanel.setBounds(5, 5, 590, 395);
			
			regDiscoDuro.setBounds(5, 5, 590, 395);
			regProcesador.setBounds(5, 5, 590, 395);
			regRam.setBounds(5, 5, 590, 395);
			regTarjeta.btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					optionPanel.setVisible(true);
					regTarjeta.setVisible(false);
				}
			});
			regTarjeta.setBounds(5, 5, 590, 395);
			regDiscoDuro.btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					optionPanel.setVisible(true);
					regDiscoDuro.setVisible(false);
				
				}
			});
		
			regProcesador.btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					optionPanel.setVisible(true);
					regProcesador.setVisible(false);
				}
			});
			regRam.btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					optionPanel.setVisible(true);
					regRam.setVisible(false);
				}
			});
			
			regProcesador.setVisible(false);
			regRam.setVisible(false);
			regDiscoDuro.setVisible(false);
			regTarjeta.setVisible(false);
			contentPanel.add(optionPanel);
			contentPanel.add(regRam);
			contentPanel.add(regProcesador);
			contentPanel.add(regDiscoDuro);
			contentPanel.add(regTarjeta);

			optionPanel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 82, 570, 128);
			optionPanel.add(panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[] { 190, 190, 190, 0 };
			gbl_panel_1.rowHeights = new int[] { 128, 0 };
			gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel_1.setLayout(gbl_panel_1);

			JButton btnDiscoDuro = new JButton("Disco Duro");
			btnDiscoDuro.setFocusable(false);
			btnDiscoDuro.setFocusTraversalPolicyProvider(true);
			btnDiscoDuro.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnDiscoDuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Controladora.getInstance();
					regDiscoDuro.actualizarId();
					
					optionPanel.setVisible(false);
					regDiscoDuro.setVisible(true);
					regProcesador.setVisible(false);
					regRam.setVisible(false);
					regTarjeta.setVisible(false);
				}
			});
			btnDiscoDuro.setBackground(Color.WHITE);
			GridBagConstraints gbc_btnDiscoDuro = new GridBagConstraints();
			gbc_btnDiscoDuro.fill = GridBagConstraints.BOTH;
			gbc_btnDiscoDuro.insets = new Insets(0, 0, 0, 5);
			gbc_btnDiscoDuro.gridx = 0;
			gbc_btnDiscoDuro.gridy = 0;
			panel_1.add(btnDiscoDuro, gbc_btnDiscoDuro);

			JButton btnRam = new JButton("RAM");
			btnRam.setFocusable(false);
			btnRam.setFocusTraversalPolicyProvider(true);
			btnRam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Controladora.getInstance();
					regRam.actualizarId();
					optionPanel.setVisible(false);
					regDiscoDuro.setVisible(false);
					regProcesador.setVisible(false);
					regRam.setVisible(true);
					regTarjeta.setVisible(false);

				}
			});
			btnRam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnRam.setBackground(Color.WHITE);
			GridBagConstraints gbc_btnRam = new GridBagConstraints();
			gbc_btnRam.fill = GridBagConstraints.BOTH;
			gbc_btnRam.insets = new Insets(0, 0, 0, 5);
			gbc_btnRam.gridx = 1;
			gbc_btnRam.gridy = 0;
			panel_1.add(btnRam, gbc_btnRam);

			JButton btnMicroProcesador = new JButton("Micro Procesador");
			btnMicroProcesador.setFocusTraversalPolicyProvider(true);
			btnMicroProcesador.setFocusable(false);
			btnMicroProcesador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Controladora.getInstance();
					regProcesador.actualizarId();
					
					optionPanel.setVisible(false);
					regDiscoDuro.setVisible(false);
					regProcesador.setVisible(true);
					regRam.setVisible(false);
					regTarjeta.setVisible(false);
				}
			});
			btnMicroProcesador.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnMicroProcesador.setBackground(Color.WHITE);
			GridBagConstraints gbc_btnMicroProcesador = new GridBagConstraints();
			gbc_btnMicroProcesador.fill = GridBagConstraints.BOTH;
			gbc_btnMicroProcesador.gridx = 2;
			gbc_btnMicroProcesador.gridy = 0;
			panel_1.add(btnMicroProcesador, gbc_btnMicroProcesador);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 215, 570, 128);
			optionPanel.add(panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[] { 190, 190, 190, 0 };
			gbl_panel_2.rowHeights = new int[] { 128, 0 };
			gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel_2.setLayout(gbl_panel_2);

			JButton btnTarjetaMadre = new JButton("Tarjeta Madre");
			btnTarjetaMadre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Controladora.getInstance();
					regTarjeta.actualizarId();
					optionPanel.setVisible(false);
					regDiscoDuro.setVisible(false);
					regProcesador.setVisible(false);
					regRam.setVisible(false);
					regTarjeta.setVisible(true);
					
				}
			});
			btnTarjetaMadre.setFocusable(false);
			btnTarjetaMadre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnTarjetaMadre.setBackground(Color.WHITE);
			GridBagConstraints gbc_btnTarjetaMadre = new GridBagConstraints();
			gbc_btnTarjetaMadre.fill = GridBagConstraints.BOTH;
			gbc_btnTarjetaMadre.insets = new Insets(0, 0, 0, 5);
			gbc_btnTarjetaMadre.gridx = 0;
			gbc_btnTarjetaMadre.gridy = 0;
			panel_2.add(btnTarjetaMadre, gbc_btnTarjetaMadre);

			JButton btnNewButton = new JButton("Ofertas");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegOfertas reg = new RegOfertas();
					reg.setModal(true);
					reg.setVisible(true);
				}
			});
			btnNewButton.setFocusable(false);
			btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnNewButton.setBackground(Color.WHITE);
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 1;
			gbc_btnNewButton.gridy = 0;
			panel_2.add(btnNewButton, gbc_btnNewButton);

			JButton btnComputadora = new JButton("Computadora");
			btnComputadora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*optionPanel.setVisible(false);
					regDiscoDuro.setVisible(false);
					regProcesador.setVisible(false);
					regRam.setVisible(false);
					regTarjeta.setVisible(false);*/
					RegPC regPC = new RegPC(null);
					regPC.setModal(true);
					regPC.setVisible(true);
					//regProcesador.actualizarId();
				}
			});
			btnComputadora.setFocusable(false);
			btnComputadora.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnComputadora.setBackground(Color.WHITE);
			GridBagConstraints gbc_btnComputadora = new GridBagConstraints();
			gbc_btnComputadora.fill = GridBagConstraints.BOTH;
			gbc_btnComputadora.gridx = 2;
			gbc_btnComputadora.gridy = 0;
			panel_2.add(btnComputadora, gbc_btnComputadora);

			JLabel lblNewLabel = new JLabel("Registrar:");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel.setBounds(255, 47, 66, 22);
			optionPanel.add(lblNewLabel);
		}
	}
}
