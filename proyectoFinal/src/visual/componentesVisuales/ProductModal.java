package visual.componentesVisuales;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logico.Controladora;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.Product;
import logico.TarjetaMadre;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ProductModal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSpinner spnCosto;
	private JSpinner spnCant;
	private JSpinner spnPrecio;
	public JButton btnEliminar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductModal dialog = new ProductModal(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProductModal(Product c1) {
		setBounds(100, 100, 450, 365);
		setPreferredSize(new Dimension(450, 350));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("Id: "+c1.getId());
			lblId.setFont(new Font("Arial", Font.PLAIN, 16));
			lblId.setBounds(10, 24, 94, 14);
			contentPanel.add(lblId);
		}
		{
			JLabel lblSerie = new JLabel("Serie: "+c1.getNumeroSerie());
			lblSerie.setFont(new Font("Arial", Font.PLAIN, 16));
			lblSerie.setBounds(10, 62, 223, 14);
			contentPanel.add(lblSerie);
		}
		{
			JLabel lblIcon = new JLabel("");
			ImageIcon productIcon;
			if (c1 instanceof DiscoDuro) {
				productIcon =new ImageIcon(new ImageIcon(ProductCard.class.getResource("/img/discoDuroHollow.png")).getImage()
						.getScaledInstance(100,100, Image.SCALE_SMOOTH));
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
				productIcon =new ImageIcon(new ImageIcon(ProductCard.class.getResource("/img/madreFull.png")).getImage()
						.getScaledInstance(80,80, Image.SCALE_SMOOTH));
			}
			else {
				productIcon =new ImageIcon(new ImageIcon(ProductCard.class.getResource("/img/reg.png")).getImage()
						.getScaledInstance(80,80, Image.SCALE_SMOOTH));
			}
			lblIcon.setIcon(productIcon);
			lblIcon.setFont(new Font("Arial", Font.PLAIN, 16));
			lblIcon.setBounds(266, 11, 142, 102);
			contentPanel.add(lblIcon);
		}
		{
			JLabel lblModelo = new JLabel("Modelo: "+c1.getModelo());
			lblModelo.setFont(new Font("Arial", Font.PLAIN, 16));
			lblModelo.setBounds(10, 100, 223, 14);
			contentPanel.add(lblModelo);
		}
		{
			JLabel lblMarca = new JLabel("Marca: "+c1.getMarca());
			lblMarca.setFont(new Font("Arial", Font.PLAIN, 16));
			lblMarca.setBounds(10, 138, 223, 14);
			contentPanel.add(lblMarca);
		}
		{
			JLabel lblNewLabel = new JLabel("Costo:");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 176, 89, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
			lblPrecio.setBounds(10, 214, 89, 14);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Arial", Font.PLAIN, 16));
			lblCantidad.setBounds(10, 252, 89, 14);
			contentPanel.add(lblCantidad);
		}
		
		spnCosto = new JSpinner();
		spnCosto.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnCosto.setFont(new Font("Arial", Font.PLAIN, 16));
		spnCosto.setValue((Float) c1.getCosto());
		spnCosto.setBounds(92, 171, 104, 20);
		contentPanel.add(spnCosto);
		
		spnCant = new JSpinner();
		spnCant.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnCant.setFont(new Font("Arial", Font.PLAIN, 16));
		spnCant.setValue( c1.getCantidad());
		spnCant.setBounds(92, 249, 104, 20);
		contentPanel.add(spnCant);
		
		spnPrecio = new JSpinner();
		spnPrecio.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		spnPrecio.setValue(c1.getPrecio());
		spnPrecio.setBounds(92, 213, 104, 20);
		
		contentPanel.add(spnPrecio);
		
		JLabel lblExtra1 = new JLabel("Costo:");
		lblExtra1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblExtra1.setBounds(227, 176, 181, 14);
		contentPanel.add(lblExtra1);
		
		JLabel lblExtra2 = new JLabel("Costo:");
		lblExtra2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblExtra2.setBounds(227, 214, 181, 14);
		contentPanel.add(lblExtra2);
		
		JLabel lblExtra3 = new JLabel("Costo:");
		lblExtra3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblExtra3.setBounds(227, 252, 181, 14);
		contentPanel.add(lblExtra3);
		
		if (c1 instanceof DiscoDuro) {
			DiscoDuro d1 = (DiscoDuro) c1;
			lblExtra1.setText("Capicidad: "+d1.getMaxAlmacenamiento()+d1.getMedidaAlmacenamiento());
			lblExtra2.setText("Tipo de conexion: "+d1.getTipoConexion());
			lblExtra3.setText("");
		}
		else if (c1 instanceof MemoriaRAM) {
			MemoriaRAM r1 = (MemoriaRAM) c1;
			lblExtra1.setText("Capicidad: "+r1.getCantMemoria()+r1.getMedidaDeMemoria());
			lblExtra2.setText("Tipo de conexion: "+r1.getTipoMemoria());
			lblExtra3.setText("");
		}
		else if (c1 instanceof Microprocesador) {
			Microprocesador m1 = (Microprocesador) c1;
			lblExtra1.setText("Capicidad: "+m1.getVelocidadProcesamiento()+m1.getTipoDeVelocidad());
			lblExtra2.setText("Tipo de conexion: "+m1.getTipoConexion() );
			lblExtra3.setText("");
			
		}
		else if (c1 instanceof TarjetaMadre) {
			TarjetaMadre t1 = (TarjetaMadre) c1;
			lblExtra1.setText("Tipo de ram: "+t1.getTipoRAM() );
			lblExtra2.setText("Tipo de conector: "+t1.getTipoConector());
			lblExtra3.setText("Conexiones disco duros: "+t1.getListConexionDiscoDuro());
			
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAgregarACarrito = new JButton("Agregar a carrito");
				btnAgregarACarrito.setFont(new Font("Arial", Font.PLAIN, 11));
				btnAgregarACarrito.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Controladora.getInstance().getCarrito().add(c1);
						Controladora.getInstance().guardarDatos();
						JOptionPane.showMessageDialog(null, "Agregado", "Productos", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						
					}
				});
				btnAgregarACarrito.setBackground(Color.WHITE);
				btnAgregarACarrito.setActionCommand("OK");
				buttonPane.add(btnAgregarACarrito);
			}
		
			{
				JButton okButton = new JButton("Guardar Cambios");
				okButton.setFont(new Font("Arial", Font.PLAIN, 11));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						float newCosto = (float) spnCosto.getValue();
						int newCant = (int) spnCant.getValue();
						float newPrecio = (float) spnPrecio.getValue();
						
						c1.setCosto(newCosto);
						c1.setCantidad(newCant);
						c1.setPrecio(newPrecio);
						
						JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Productos", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						
					}
				});
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Arial", Font.PLAIN, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					btnEliminar = new JButton("Eliminar");
					btnEliminar.setFont(new Font("Arial", Font.PLAIN, 11)); 
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int option = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar el vino con código: "+c1.getId(), "Confirmación", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.YES_OPTION){
								
								Controladora.getInstance().deleteProduct(c1.getId());
								dispose();
							}
						}
					});
					buttonPane.add(btnEliminar);
					
				}
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
