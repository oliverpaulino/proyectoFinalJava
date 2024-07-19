package visual.componentesVisuales;

import javax.swing.JPanel;


import logico.Product;
import logico.Product;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class ProductCard extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductCard(Product c1) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(null);
		
		JLabel lblId = new JLabel(c1.getId());
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblId.setBounds(53, 5, 94, 22);
		add(lblId);
		
		JLabel lblMarca = new JLabel(c1.getMarca());
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMarca.setBounds(10, 133, 94, 22);
		add(lblMarca);
		
		JLabel lblModelo = new JLabel(c1.getModelo());
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModelo.setBounds(10, 166, 94, 22);
		add(lblModelo);
		
		JLabel label232 = new JLabel("Costo:");
		label232.setFont(new Font("Arial", Font.PLAIN, 14));
		label232.setBounds(10, 199, 58, 22);
		add(label232);
		
		JLabel lblCosto = new JLabel(c1.getCosto()+"$");
		lblCosto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCosto.setBounds(78, 199, 94, 22);
		add(lblCosto);
		
		JLabel label342 = new JLabel("Precio:");
		label342.setFont(new Font("Arial", Font.PLAIN, 14));
		label342.setBounds(10, 224, 58, 22);
		add(label342);
		
		JLabel label_1 = new JLabel(c1.getPrecio()+"$");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(78, 224, 94, 22);
		add(label_1);

	}
}
