package visual.componentesVisuales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import logico.Controladora;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.TarjetaMadre;
import visual.RegOption;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class RegComp extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btnCancelar;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtSerie;
	private JComboBox cbxMedida;
	private JComboBox cbxTipoRam;
	private JComboBox cbxUnidadMemoria;
	private JSpinner spnMemoria;
	private JSpinner spnAlmacenamiento;
	private JTextField txtTipoConexionCpu;
	private JSpinner spnProcesamiento;
	private JComboBox cbxUnidadVelocidad;
	private JTextField txtConectorTarjetaMadre;
	private JComboBox cbxTipoRamMadre;
	private int idActual = Controladora.getInstance().getProducts().size() + 1;
	private ListConexiones listConexiones = new ListConexiones();
	private JComboBox cbxConexion;
	private JSpinner spnCosto;
	private JSpinner spnCantidad;
	private JSpinner spnPrecio;
	private JTextField txtId;

	/**
	 * Create the panel.
	 */
	public RegComp(int type) {
		setLayout(null);

		btnCancelar = new JButton("Cancelar");

		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBounds(355, 359, 121, 23);
		add(btnCancelar);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String id = txtId.getText();
					String marca = txtMarca.getText();
					String modelo = txtModelo.getText();
					String numSerie = txtSerie.getText();
					int cant = (int) spnCantidad.getValue();
					boolean error = false;
					float costo = (float) spnCosto.getValue();
					float precio = (float) spnPrecio.getValue();
					if (cant == 0 || costo == 0 || precio == 0 || marca.isEmpty() || modelo.isEmpty()
							|| numSerie.isEmpty()) {
						error = true;
					} else {

						switch (type) {
						case 0:
							String conexion = cbxConexion.getSelectedItem().toString();
							int almacenamiento = (int) spnAlmacenamiento.getValue();
							String medidaAlmacenamiento = cbxMedida.getSelectedItem().toString();

							if (conexion.isEmpty() || almacenamiento == 0 || medidaAlmacenamiento.isEmpty()) {
								error = true;
							} else {

								DiscoDuro discoDuro = new DiscoDuro(id, marca, modelo, costo, precio, cant, numSerie,
										almacenamiento, medidaAlmacenamiento, conexion);
								Controladora.getInstance().addProduct(discoDuro);

							}

							break;
						case 1:
							String tipoConexionCpu = txtTipoConexionCpu.getText();
							String unidadVelcidad = cbxUnidadVelocidad.getSelectedItem().toString();
							float velocidadProcesamiento = (float) spnProcesamiento.getValue();
							if (tipoConexionCpu.isEmpty() || velocidadProcesamiento == 0) {
								error = true;
							} else {

								Microprocesador microprocesador = new Microprocesador(id, marca, modelo, costo, precio,
										cant, numSerie, tipoConexionCpu, velocidadProcesamiento, unidadVelcidad);
								Controladora.getInstance().addProduct(microprocesador);
							}

							break;
						case 2:
							int memoria = (int) spnMemoria.getValue();
							String tipoMemoria = cbxTipoRam.getSelectedItem().toString();
							String medidaRam = cbxUnidadMemoria.getSelectedItem().toString();

							if (memoria == 0) {
								error = true;
							} else {

								MemoriaRAM memoriaRAM = new MemoriaRAM(id, marca, modelo, costo, precio, cant, numSerie,
										memoria, medidaRam, tipoMemoria);
								Controladora.getInstance().addProduct(memoriaRAM);
							}
							break;

						case 3:
							String conectorTajetaMadre = txtConectorTarjetaMadre.getText();
							String tipoRamTarjeta = cbxTipoRamMadre.getSelectedItem().toString();
							ArrayList<String> conexionesDiscoDuro = listConexiones.conexiones;

							if (conectorTajetaMadre.isEmpty() || conexionesDiscoDuro.isEmpty()) {
								error = true;
							} else {

								TarjetaMadre tarjetaMadre = new TarjetaMadre(id, marca, modelo, costo, precio, cant,
										numSerie, conectorTajetaMadre, tipoRamTarjeta, conexionesDiscoDuro);
								Controladora.getInstance().addProduct(tarjetaMadre);
							}

						default:
							break;
						}

					}

					if (error) {
						JOptionPane.showMessageDialog(null, "Complete/Cambie todos los campos", "Registro",
								JOptionPane.WARNING_MESSAGE);
					} else {

						JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Registro",
								JOptionPane.INFORMATION_MESSAGE);
						clean();
					}

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Formato de número incorrecto: " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Valor nulo encontrado: " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setBounds(117, 361, 121, 23);
		add(btnRegistrar);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 593, 35);
		add(panel);
		panel.setLayout(null);

		JLabel typeLabel = new JLabel("New label");
		typeLabel.setBounds(10, 8, 573, 19);
		panel.add(typeLabel);
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setForeground(SystemColor.text);

		typeLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel pnFondo = new JPanel();
		pnFondo.setBackground(UIManager.getColor("Button.light"));
		pnFondo.setBounds(30, 35, 533, 319);
		add(pnFondo);
		pnFondo.setLayout(null);

		spnCosto = new JSpinner();
		spnCosto.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnCosto.setFont(new Font("Arial", Font.PLAIN, 14));
		spnCosto.setBounds(139, 111, 86, 20);
		pnFondo.add(spnCosto);

		JPanel panelDiscoDuro = new JPanel();
		panelDiscoDuro.setBounds(33, 149, 464, 150);
		pnFondo.add(panelDiscoDuro);
		panelDiscoDuro.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelDiscoDuro.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Capacidad de almacenamiento");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(51, 23, 237, 19);
		panelDiscoDuro.add(lblNewLabel_3);

		spnAlmacenamiento = new JSpinner();
		spnAlmacenamiento.setFont(new Font("Arial", Font.PLAIN, 16));
		spnAlmacenamiento.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnAlmacenamiento.setBounds(339, 22, 86, 20);
		panelDiscoDuro.add(spnAlmacenamiento);

		JLabel lblNewLabel_4 = new JLabel("Medida de almacenamieto");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(51, 65, 220, 19);
		panelDiscoDuro.add(lblNewLabel_4);

		cbxMedida = new JComboBox();
		cbxMedida.setModel(new DefaultComboBoxModel(new String[] { "Gb", "Mb" }));
		cbxMedida.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxMedida.setBounds(339, 64, 86, 20);
		panelDiscoDuro.add(cbxMedida);

		JLabel lblTipoDeConexion = new JLabel("Tipo de conexion");
		lblTipoDeConexion.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipoDeConexion.setBounds(51, 107, 220, 19);
		panelDiscoDuro.add(lblTipoDeConexion);

		cbxConexion = new JComboBox();
		cbxConexion.setModel(new DefaultComboBoxModel(
				new String[] { "SATA", "PATA", "eSATA", "SCSI", "SSD", "SAS", "NVMe", "Express" }));
		cbxConexion.setSelectedIndex(0);
		cbxConexion.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxConexion.setBounds(339, 108, 86, 20);
		panelDiscoDuro.add(cbxConexion);

		JPanel panelRam = new JPanel();
		panelRam.setBounds(33, 149, 464, 150);
		pnFondo.add(panelRam);
		panelRam.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelRam.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Cantidad de memoria");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 25, 187, 19);
		panelRam.add(lblNewLabel_5);

		spnMemoria = new JSpinner();
		spnMemoria.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnMemoria.setBounds(350, 22, 88, 20);
		panelRam.add(spnMemoria);

		JLabel lblNewLabel_6 = new JLabel("Medida de memoria");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(10, 69, 150, 14);
		panelRam.add(lblNewLabel_6);

		cbxUnidadMemoria = new JComboBox();
		cbxUnidadMemoria.setModel(new DefaultComboBoxModel(new String[] { "Gb", "Mb" }));
		cbxUnidadMemoria.setBounds(350, 64, 88, 20);
		panelRam.add(cbxUnidadMemoria);

		JLabel lblTipo = new JLabel("Tipo de memoria");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipo.setBounds(10, 108, 150, 14);
		panelRam.add(lblTipo);

		cbxTipoRam = new JComboBox();
		cbxTipoRam.setModel(new DefaultComboBoxModel(new String[] { "DDR1", "DDR2", "DDR3", "DDR4", "DDR5" }));
		cbxTipoRam.setBounds(350, 106, 88, 20);
		panelRam.add(cbxTipoRam);

		JPanel panelProcesador = new JPanel();
		panelProcesador.setBounds(33, 149, 464, 150);
		pnFondo.add(panelProcesador);
		panelProcesador.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelProcesador.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Tipo de conexion");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(10, 23, 121, 19);
		panelProcesador.add(lblNewLabel_8);

		JLabel lblTipoDeConexion_1 = new JLabel("Velocidad procesamiento");
		lblTipoDeConexion_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipoDeConexion_1.setBounds(10, 65, 203, 19);
		panelProcesador.add(lblTipoDeConexion_1);

		JLabel lblUnidadDeVelociad = new JLabel("Unidad de velociad");
		lblUnidadDeVelociad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUnidadDeVelociad.setBounds(10, 107, 203, 19);
		panelProcesador.add(lblUnidadDeVelociad);

		cbxUnidadVelocidad = new JComboBox();
		cbxUnidadVelocidad.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxUnidadVelocidad.setModel(new DefaultComboBoxModel(new String[] { "Ghz", "Mhz", "Khz" }));
		cbxUnidadVelocidad.setBounds(343, 106, 111, 20);
		panelProcesador.add(cbxUnidadVelocidad);

		spnProcesamiento = new JSpinner();
		spnProcesamiento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnProcesamiento.setFont(new Font("Arial", Font.PLAIN, 16));
		spnProcesamiento.setBounds(343, 64, 111, 20);
		panelProcesador.add(spnProcesamiento);

		txtTipoConexionCpu = new JTextField();
		txtTipoConexionCpu.setBounds(343, 22, 111, 20);
		panelProcesador.add(txtTipoConexionCpu);
		txtTipoConexionCpu.setColumns(10);

		JPanel panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setBounds(33, 149, 464, 150);
		pnFondo.add(panelTarjetaMadre);
		panelTarjetaMadre.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTarjetaMadre.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Tipo de conector");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(10, 24, 151, 19);
		panelTarjetaMadre.add(lblNewLabel_9);

		txtConectorTarjetaMadre = new JTextField();
		txtConectorTarjetaMadre.setFont(new Font("Arial", Font.PLAIN, 14));
		txtConectorTarjetaMadre.setBounds(316, 22, 138, 20);
		panelTarjetaMadre.add(txtConectorTarjetaMadre);
		txtConectorTarjetaMadre.setColumns(10);

		JLabel lblTipoDeRam = new JLabel("Tipo de ram");
		lblTipoDeRam.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTipoDeRam.setBounds(10, 67, 151, 19);
		panelTarjetaMadre.add(lblTipoDeRam);

		cbxTipoRamMadre = new JComboBox();
		cbxTipoRamMadre.setFont(new Font("Arial", Font.PLAIN, 14));
		cbxTipoRamMadre.setModel(new DefaultComboBoxModel(new String[] { "DDR1", "DDR2", "DDR3", "DDR4", "DDR5" }));
		cbxTipoRamMadre.setBounds(316, 64, 138, 20);
		panelTarjetaMadre.add(cbxTipoRamMadre);

		JLabel lblNewLabel_10 = new JLabel("Conexiones disco duro");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(10, 110, 184, 14);
		panelTarjetaMadre.add(lblNewLabel_10);

		JButton btnConexiones = new JButton("Conexiones");
		btnConexiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listConexiones.setModal(true);
				listConexiones.setVisible(true);
			}
		});
		btnConexiones.setFont(new Font("Arial", Font.PLAIN, 16));
		btnConexiones.setBackground(Color.WHITE);
		btnConexiones.setBounds(316, 108, 138, 23);
		panelTarjetaMadre.add(btnConexiones);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(30, 111, 86, 14);
		pnFondo.add(lblCosto);
		lblCosto.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(285, 111, 86, 14);
		pnFondo.add(lblPrecio);
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblCantl = new JLabel("Cantidad:");
		lblCantl.setBounds(285, 77, 86, 14);
		pnFondo.add(lblCantl);
		lblCantl.setFont(new Font("Arial", Font.PLAIN, 16));

		txtModelo = new JTextField();
		txtModelo.setBounds(139, 74, 86, 20);
		pnFondo.add(txtModelo);
		txtModelo.setFont(new Font("Arial", Font.PLAIN, 16));
		txtModelo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setBounds(30, 77, 86, 14);
		pnFondo.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel label = new JLabel("Num. Serie");
		label.setBounds(30, 45, 89, 14);
		pnFondo.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 16));

		txtSerie = new JTextField();
		txtSerie.setBounds(139, 42, 357, 20);
		pnFondo.add(txtSerie);
		txtSerie.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSerie.setColumns(10);

		txtMarca = new JTextField();
		txtMarca.setBounds(411, 8, 86, 20);
		pnFondo.add(txtMarca);
		txtMarca.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMarca.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(285, 11, 66, 14);
		pnFondo.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(30, 11, 46, 14);
		pnFondo.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		spnPrecio = new JSpinner();
		spnPrecio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnPrecio.setFont(new Font("Arial", Font.PLAIN, 14));
		spnPrecio.setBounds(411, 109, 86, 20);
		pnFondo.add(spnPrecio);

		spnCantidad = new JSpinner();
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
		spnCantidad.setBounds(411, 74, 86, 20);
		pnFondo.add(spnCantidad);

		txtId = new JTextField();
		txtId.setText("C-" + idActual);
		System.out.println(idActual);
		txtId.setFont(new Font("Arial", Font.PLAIN, 16));
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(139, 7, 86, 23);
		pnFondo.add(txtId);
		panelTarjetaMadre.setVisible(false);
		panelProcesador.setVisible(false);
		panelRam.setVisible(false);

		panelDiscoDuro.setVisible(false);

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
		case 3:
			typeLabel.setText("Registro Tarjeta Madre");
			panelTarjetaMadre.setVisible(true);

		default:
			break;
		}

	}

	private void clean() {
		idActual=(Controladora.getInstance().getProducts().size() + 1);
		txtId.setText("C-" + idActual);
		txtMarca.setText("");
		txtModelo.setText("");
		txtSerie.setText("");
		spnAlmacenamiento.setValue(0);
		spnProcesamiento.setValue(0);
		spnCosto.setValue(new Float(1));
		spnPrecio.setValue(new Float(1));
		spnCantidad.setValue(new Integer(1));
		cbxMedida.setSelectedIndex(0);
		cbxTipoRam.setSelectedIndex(0);
		cbxTipoRamMadre.setSelectedIndex(0);
		cbxUnidadMemoria.setSelectedIndex(0);
		cbxUnidadVelocidad.setSelectedIndex(0);

	}

	public void actualizarId() {
		txtId.setText("C-" + (Controladora.getInstance().getProducts().size() + 1));
	}
}
