package visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class RegComp extends JPanel {
	private JTextField txtId;
	public static JButton btnCancelar;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtSerie;

	/**
	 * Create the panel.
	 */
	public RegComp(int type) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 50, 46, 14);
		add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Arial", Font.PLAIN, 16));
		txtId.setEnabled(false);
		txtId.setBounds(160, 47, 86, 20);
		add(txtId);
		txtId.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBounds(400, 264, 121, 23);
		add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(279, 50, 66, 14);
		add(lblNewLabel_1);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMarca.setColumns(10);
		txtMarca.setBounds(406, 47, 86, 20);
		add(txtMarca);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(37, 125, 86, 14);
		add(lblNewLabel_2);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Arial", Font.PLAIN, 16));
		txtModelo.setColumns(10);
		txtModelo.setBounds(160, 122, 86, 20);
		add(txtModelo);
		
		JLabel lblCantl = new JLabel("Cant:");
		lblCantl.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantl.setBounds(283, 125, 86, 14);
		add(lblCantl);
		
		JSpinner spnCantidad = new JSpinner();
		spnCantidad.setFont(new Font("Arial", Font.PLAIN, 16));
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidad.setBounds(406, 122, 86, 20);
		add(spnCantidad);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCosto.setBounds(37, 165, 86, 14);
		add(lblCosto);
		
		JSpinner spnCosto = new JSpinner();
		spnCosto.setFont(new Font("Arial", Font.PLAIN, 16));
		spnCosto.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnCosto.setBounds(160, 162, 86, 20);
		add(spnCosto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecio.setBounds(283, 165, 86, 14);
		add(lblPrecio);
		
		JSpinner spnPrecio = new JSpinner();
		spnPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		spnPrecio.setBounds(406, 162, 86, 20);
		add(spnPrecio);
		
		JLabel label = new JLabel("Num. Serie");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBounds(90, 82, 89, 14);
		add(label);
		
		txtSerie = new JTextField();
		txtSerie.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSerie.setColumns(10);
		txtSerie.setBounds(281, 77, 211, 20);
		add(txtSerie);
		
		JLabel typeLabel = new JLabel("New label");
		switch (type) {
		case 0:
			typeLabel.setText("Registro Disco Duro");
			break;
		case 1:
			typeLabel.setText("Registro Micro Procesador");
			break;
		case 2:
			typeLabel.setText("Registro Ram");
			break;
			
		default:
			break;
		}
		typeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		typeLabel.setBounds(180, 13, 173, 14);
		add(typeLabel);

	}
}
