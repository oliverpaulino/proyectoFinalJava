package visual;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.border.TitledBorder;

import logico.Controladora;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;

public class RegComp extends JPanel {
	private JTextField txtId;
	public 	JButton btnCancelar;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtSerie;
	private JTextField txtConexion;
	private JTextField textField;
	private JComboBox cbxMedida;
	private JComboBox cbxTipoRam;
	private JComboBox cbxUnidadMemoria;
	private JSpinner spnMemoria ;
	private JSpinner spnCantidad;
	private JSpinner spnAlmacenamiento;
	private JTextField txtTipoConexionCpu;
	private JSpinner spnCosto;
	private JSpinner spnPrecio;
	private JSpinner spnProcesamiento;
	private JComboBox cbxUnidadVelocidad;
	
	
	
	/**
	 * Create the panel.
	 */
	public RegComp(int type) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(60, 50, 46, 14);
		add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Arial", Font.PLAIN, 16));
		txtId.setEnabled(false);
		txtId.setBounds(166, 44, 86, 23);
		add(txtId);
		txtId.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBounds(457, 365, 121, 23);
		add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(312, 50, 66, 14);
		add(lblNewLabel_1);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMarca.setColumns(10);
		txtMarca.setBounds(438, 47, 86, 20);
		add(txtMarca);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(60, 125, 86, 14);
		add(lblNewLabel_2);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Arial", Font.PLAIN, 16));
		txtModelo.setColumns(10);
		txtModelo.setBounds(166, 122, 86, 20);
		add(txtModelo);
		
		JLabel lblCantl = new JLabel("Cant:");
		lblCantl.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantl.setBounds(312, 125, 86, 14);
		add(lblCantl);
		
		spnCantidad = new JSpinner();
		spnCantidad.setFont(new Font("Arial", Font.PLAIN, 16));
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidad.setBounds(438, 122, 86, 20);
		add(spnCantidad);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCosto.setBounds(60, 165, 86, 14);
		add(lblCosto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecio.setBounds(312, 165, 86, 14);
		add(lblPrecio);
		
		JLabel label = new JLabel("Num. Serie");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBounds(57, 81, 89, 14);
		add(label);
		
		txtSerie = new JTextField();
		txtSerie.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSerie.setColumns(10);
		txtSerie.setBounds(166, 78, 357, 20);
		add(txtSerie);
		
		JLabel typeLabel = new JLabel("New label");
		
		typeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		typeLabel.setBounds(181, 13, 225, 14);
		add(typeLabel);
		
		JPanel panelDiscoDuro = new JPanel();
		panelDiscoDuro.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelDiscoDuro.setBounds(60, 205, 464, 150);
		add(panelDiscoDuro);
		panelDiscoDuro.setLayout(null);
		
		JPanel panelRam = new JPanel();
		panelRam.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelRam.setBounds(60, 205, 464, 150);
		add(panelRam);
		panelRam.setLayout(null);
		
		JPanel panelProcesador = new JPanel();
		panelProcesador.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelProcesador.setBounds(60, 205, 464, 150);
		add(panelProcesador);
		panelProcesador.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Tipo de conexion");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(10, 14, 121, 19);
		panelProcesador.add(lblNewLabel_8);
		
		JLabel lblTipoDeConexion_1 = new JLabel("Velocidad procesamiento");
		lblTipoDeConexion_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipoDeConexion_1.setBounds(10, 47, 203, 19);
		panelProcesador.add(lblTipoDeConexion_1);
		
		JLabel lblUnidadDeVelociad = new JLabel("Unidad de velociad");
		lblUnidadDeVelociad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUnidadDeVelociad.setBounds(10, 80, 203, 19);
		panelProcesador.add(lblUnidadDeVelociad);
		
		JLabel lblImagenDeProcesador = new JLabel("Imagen de procesador");
		lblImagenDeProcesador.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImagenDeProcesador.setBounds(10, 113, 203, 19);
		panelProcesador.add(lblImagenDeProcesador);
		
		JButton btnNewButton_2 = new JButton("Imagenes");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(343, 112, 111, 23);
		panelProcesador.add(btnNewButton_2);
		
		cbxUnidadVelocidad = new JComboBox();
		cbxUnidadVelocidad.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxUnidadVelocidad.setModel(new DefaultComboBoxModel(new String[] {"Ghz", "Mhz", "Khz"}));
		cbxUnidadVelocidad.setBounds(343, 79, 111, 20);
		panelProcesador.add(cbxUnidadVelocidad);
		
		spnProcesamiento = new JSpinner();
		spnProcesamiento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnProcesamiento.setFont(new Font("Arial", Font.PLAIN, 16));
		spnProcesamiento.setBounds(343, 46, 111, 20);
		panelProcesador.add(spnProcesamiento);
		
		txtTipoConexionCpu = new JTextField();
		txtTipoConexionCpu.setBounds(343, 13, 111, 20);
		panelProcesador.add(txtTipoConexionCpu);
		txtTipoConexionCpu.setColumns(10);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad de memoria");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 16, 187, 19);
		panelRam.add(lblNewLabel_5);
		
		spnMemoria = new JSpinner();
		spnMemoria.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnMemoria.setBounds(350, 13, 88, 20);
		panelRam.add(spnMemoria);
		
		JLabel lblNewLabel_6 = new JLabel("Medida de memoria");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(10, 51, 150, 14);
		panelRam.add(lblNewLabel_6);
		
		cbxUnidadMemoria = new JComboBox();
		cbxUnidadMemoria.setModel(new DefaultComboBoxModel(new String[] {"Gb", "Mb"}));
		cbxUnidadMemoria.setBounds(350, 46, 88, 20);
		panelRam.add(cbxUnidadMemoria);
		
		JLabel lblTipo = new JLabel("Tipo de memoria");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipo.setBounds(10, 81, 150, 14);
		panelRam.add(lblTipo);
		
		cbxTipoRam = new JComboBox();
		cbxTipoRam.setModel(new DefaultComboBoxModel(new String[] {"DDR1", "DDR2", "DDR3", "DDR4", "DDR5"}));
		cbxTipoRam.setBounds(350, 79, 88, 20);
		panelRam.add(cbxTipoRam);
		
		
		JLabel lblNewLabel_7 = new JLabel("Imagen");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 111, 150, 19);
		panelRam.add(lblNewLabel_7);
		JLabel imgLabel = new JLabel("");
		imgLabel.setBounds(224, 46, 116, 84);
		panelRam.add(imgLabel);
		
		JButton btnNewButton_1 = new JButton("Seleccionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser compImgSelec = new JFileChooser();
				compImgSelec.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif", "bmp"));
				int valor = compImgSelec.showOpenDialog(null);
				if (valor == JFileChooser.APPROVE_OPTION) {
					File imgFile = compImgSelec.getSelectedFile();
					ImageIcon imgPath = new ImageIcon(imgFile.getAbsolutePath());
					imgLabel.setIcon(imgPath);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.setBounds(349, 112, 89, 23);
		panelRam.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad de almacenamiento");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(51, 14, 237, 19);
		panelDiscoDuro.add(lblNewLabel_3);
		
		spnAlmacenamiento = new JSpinner();
		spnAlmacenamiento.setFont(new Font("Arial", Font.PLAIN, 16));
		spnAlmacenamiento.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnAlmacenamiento.setBounds(339, 13, 86, 20);
		panelDiscoDuro.add(spnAlmacenamiento);
		
		JLabel lblNewLabel_4 = new JLabel("Medida de almacenamieto");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(51, 47, 220, 19);
		panelDiscoDuro.add(lblNewLabel_4);
		
		cbxMedida = new JComboBox();
		cbxMedida.setModel(new DefaultComboBoxModel(new String[] {"Gb", "Mb"}));
		cbxMedida.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxMedida.setBounds(339, 46, 86, 20);
		panelDiscoDuro.add(cbxMedida);
		
		JLabel lblTipoDeConexion = new JLabel("Tipo de conexion");
		lblTipoDeConexion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipoDeConexion.setBounds(51, 80, 220, 19);
		panelDiscoDuro.add(lblTipoDeConexion);
		
		txtConexion = new JTextField();
		txtConexion.setFont(new Font("Arial", Font.PLAIN, 16));
		txtConexion.setColumns(10);
		txtConexion.setBounds(339, 79, 86, 20);
		panelDiscoDuro.add(txtConexion);
		
		JLabel lblImagenDeDisco = new JLabel("Imagen de disco duro");
		lblImagenDeDisco.setFont(new Font("Arial", Font.PLAIN, 16));
		lblImagenDeDisco.setBounds(51, 113, 220, 19);
		panelDiscoDuro.add(lblImagenDeDisco);
		JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(243, 77, 86, 55);
		panelDiscoDuro.add(imageLabel);
		
		
		JButton btnNewButton = new JButton("Imagenes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser selecImagen = new JFileChooser();
				selecImagen.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png","bmp"));
				int valor = selecImagen.showOpenDialog(null);
				if (valor == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = selecImagen.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    
					imageLabel.setIcon(imageIcon); // Display the image in the label
                }
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(336, 112, 89, 23);
		panelDiscoDuro.add(btnNewButton);
		
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String marca = txtMarca.getText();
				String modelo = txtModelo.getText();
				String numSerie = txtSerie.getText();
				int cant = (int) spnCantidad.getValue();
				float costo = (float) spnCosto.getValue();
				float precio = (float) spnPrecio.getValue();
				switch (type) {
				case 0:
					String conexion = txtConexion.getText();
					int almacenamiento = (int) spnAlmacenamiento.getValue();
					String medidaAlmacenamiento = cbxMedida.getSelectedItem().toString();
					
					DiscoDuro discoDuro = new DiscoDuro("C-"+Controladora.getInstance().idcomponente, marca, modelo, costo, precio, cant, numSerie, almacenamiento, medidaAlmacenamiento, conexion);
					Controladora.getInstance().addComponente(discoDuro);
					clean();
					
					break;
				case 1:
					String tipoConexionCpu = txtTipoConexionCpu.getText();
					String unidadVelcidad = cbxUnidadVelocidad.getSelectedItem().toString();
					float velocidadProcesamiento = (float)spnProcesamiento.getValue();
					
					Microprocesador microprocesador = new Microprocesador("C-"+Controladora.getInstance().idcomponente, marca, modelo, costo, precio, cant, numSerie, tipoConexionCpu, velocidadProcesamiento, unidadVelcidad);
					Controladora.getInstance().addComponente(microprocesador);
					clean();
					
					
					
					break;
				case 2:
					int memoria = (int) spnMemoria.getValue();
					String tipoMemoria = cbxTipoRam.getSelectedItem().toString();
					String medidaRam = cbxUnidadMemoria.getSelectedItem().toString();
					
					MemoriaRAM memoriaRAM = new MemoriaRAM("C"+Controladora.getInstance().idcomponente, marca, modelo, costo, precio, cant, numSerie, memoria, medidaRam, tipoMemoria);
					Controladora.getInstance().addComponente(memoriaRAM);
					clean();
					break;
					
				default:
					break;
				}
			}
		});
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(312, 367, 121, 23);
		add(btnRegistrar);
		
		spnCosto = new JSpinner();
		spnCosto.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnCosto.setFont(new Font("Arial", Font.PLAIN, 16));
		spnCosto.setBounds(166, 164, 86, 20);
		add(spnCosto);
		
		spnPrecio = new JSpinner();
		spnPrecio.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		spnPrecio.setBounds(438, 164, 86, 20);
		add(spnPrecio);
		
		panelDiscoDuro.setVisible(false);
		panelRam.setVisible(false);
		panelProcesador.setVisible(false);
		
		switch (type) {
		case 0:
			typeLabel.setText("Registro Disco Duro");
			panelDiscoDuro.setVisible(true);
			break;
		case 1:
			typeLabel.setText("Registro Micro Procesador");
			panelProcesador.setVisible(true);
			break;
		case 2:
			typeLabel.setText("Registro Ram");
			panelRam.setVisible(true);
			break;
			
		default:
			break;
		}
		
		clean();
		
	}
	
	private void clean() {
		txtId.setText("C-"+Controladora.getInstance().idcomponente);
		txtMarca.setText("");
		txtConexion.setText("");
		txtModelo.setText("");
		txtSerie.setText("");
		spnCantidad.setValue(0);
		spnCantidad.setValue(0);
		spnAlmacenamiento.setValue(0);
		cbxMedida.setSelectedIndex(0);
		txtConexion.setText("");
		
		
	}
	
	public void actualizarId() {
		txtId.setText("C-"+Controladora.getInstance().idcomponente);
	}
}
