package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class RegComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComponente dialog = new RegComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegComponente() {
		setTitle("Registro de Componentes\r\n");
		setBounds(100, 100, 616, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 82, 570, 128);
			panel.add(panel_1);
			panel_1.setLayout(new GridLayout(1, 0, 0, 0));
			
			JButton btnDiscoDuro = new JButton("Disco duro");
			btnDiscoDuro.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//			btnDiscoDuro.setBorder(new RoundedBorder(10));
			btnDiscoDuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnDiscoDuro.setBackground(Color.WHITE);
			panel_1.add(btnDiscoDuro);
			
			JButton btnRam = new JButton("Ram");
			btnRam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnRam.setBackground(Color.WHITE);
			panel_1.add(btnRam);
			
			JButton btnMicroProcesador = new JButton("Micro procesador");
			btnMicroProcesador.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnMicroProcesador.setBackground(Color.WHITE);
			panel_1.add(btnMicroProcesador);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 210, 570, 128);
			panel.add(panel_2);
			panel_2.setLayout(new GridLayout(1, 0, 0, 0));
			
			JButton btnTarjetaMadre = new JButton("Tarjeta Madre");
			btnTarjetaMadre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnTarjetaMadre.setBackground(Color.WHITE);
			panel_2.add(btnTarjetaMadre);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnNewButton.setBackground(Color.WHITE);
			panel_2.add(btnNewButton);
			
			JButton btnComputadora = new JButton("Computadora");
			btnComputadora.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnComputadora.setBackground(Color.WHITE);
			panel_2.add(btnComputadora);
			
			JLabel lblNewLabel = new JLabel("Registrar un:");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel.setBounds(241, 35, 107, 22);
			panel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
