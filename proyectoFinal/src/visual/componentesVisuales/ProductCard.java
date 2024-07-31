package visual.componentesVisuales;

import javax.swing.JPanel;

import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.Product;
import logico.TarjetaMadre;
import visual.Principal;
import logico.Product;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductCard extends JPanel {
	/**
	 * Create the panel.
	 */
	public ProductCard(Product c1) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(new Color(240, 240, 240));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(Color.WHITE);
				
			}
			
		});
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(null);
		
		JLabel lblId = new JLabel(c1.getId());
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 73, 22);
		add(lblId);
		
		JLabel lblMarca = new JLabel(c1.getMarca());
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMarca.setBounds(88, 133, 94, 22);
		add(lblMarca);
		
		JLabel lblModelo = new JLabel(c1.getModelo());
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModelo.setBounds(88, 166, 94, 22);
		add(lblModelo);
		
		JLabel label232 = new JLabel("Costo:");
		label232.setFont(new Font("Arial", Font.PLAIN, 14));
		label232.setBounds(10, 232, 58, 22);
		add(label232);
		
		JLabel lblCosto = new JLabel(c1.getCosto()+"$");
		lblCosto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCosto.setBounds(88, 232, 94, 22);
		add(lblCosto);
		
		JLabel label342 = new JLabel("Precio:");
		label342.setFont(new Font("Arial", Font.PLAIN, 14));
		label342.setBounds(10, 265, 58, 22);
		add(label342);
		
		JLabel label_1 = new JLabel(c1.getPrecio()+"$");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(88, 265, 94, 22);
		add(label_1);
		
		JLabel lblSerial = new JLabel(c1.getNumeroSerie());
		lblSerial.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSerial.setBounds(88, 199, 94, 22);
		add(lblSerial);
		
		JLabel lblIcon = new JLabel("");
		
		ImageIcon productIcon;
		if (c1 instanceof DiscoDuro) {
			productIcon =new ImageIcon(new ImageIcon(ProductCard.class.getResource("/img/discoDuroHollow.png")).getImage()
					.getScaledInstance(80,80, Image.SCALE_SMOOTH));
		}
		else if (c1 instanceof MemoriaRAM) {
			productIcon =new ImageIcon(new ImageIcon(ProductCard.class.getResource("/img/ramHollow.png")).getImage()
					.getScaledInstance(80,80, Image.SCALE_SMOOTH));
		}
		else if (c1 instanceof Microprocesador) {
			productIcon =new ImageIcon(new ImageIcon(ProductCard.class.getResource("/img/cpuHollow.png")).getImage()
					.getScaledInstance(80,80, Image.SCALE_SMOOTH));
		}
		else if (c1 instanceof TarjetaMadre) {
			productIcon = new ImageIcon(new ImageIcon(ProductCard.class.getResource("/img/madreFull.png")).getImage()
					.getScaledInstance(80,80, Image.SCALE_SMOOTH));
		}
		else {
			productIcon =new ImageIcon(new ImageIcon(ProductCard.class.getResource("/img/reg.png")).getImage()
					.getScaledInstance(80,80, Image.SCALE_SMOOTH));
		}
		lblIcon.setIcon(productIcon);
		lblIcon.setBounds(53, 44, 94, 78);
		add(lblIcon);
		
		JLabel lblExistencia = new JLabel("Existencia:");
		lblExistencia.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExistencia.setBounds(10, 298, 73, 22);
		add(lblExistencia);
		
		JLabel lblCant = new JLabel(c1.getCantidad()+"");
		lblCant.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCant.setBounds(88, 298, 94, 22);
		add(lblCant);
		
		JLabel lblMarca_1 = new JLabel("Marca:");
		lblMarca_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMarca_1.setBounds(10, 133, 58, 22);
		add(lblMarca_1);
		
		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModelo_1.setBounds(10, 166, 58, 22);
		add(lblModelo_1);
		
		JLabel lblSerie = new JLabel("Serie:");
		lblSerie.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSerie.setBounds(10, 199, 58, 22);
		add(lblSerie);

	}
}
