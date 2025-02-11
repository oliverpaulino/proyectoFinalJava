package visual.componentesVisuales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import logico.Computadora;
import logico.Controladora;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.Product;
import logico.TarjetaMadre;
import logico.DiscoDuro;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class RegPC extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tbId;
	private JTextField tbBrand;
	private JTextField tbModel;
	private JTextField tbSeriesNumber;
	private JSpinner spQty;
	private JSpinner spMountCost;
	private JLabel lblSelectedHardDrive;
	private JLabel lblSelectedProcesador;
	private JLabel lblSelectedMotherboard;
	private JLabel lblSelectedRAM;
	private JPanel panel_1;
	private JLabel lblSelectedAddons;

	private TarjetaMadre selectedMotherboard = null;
	private ArrayList<MemoriaRAM> selectedRAMs = new ArrayList<MemoriaRAM>();
	private ArrayList<DiscoDuro> selectedHardDrives = new ArrayList<DiscoDuro>();
	private Microprocesador selectedProcesador = null;
	private ArrayList<String> selectedAddonsId = new ArrayList<String>();
	private JTextField tbTotalCost;
	private JTextField tbPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPC dialog = new RegPC(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPC(Computadora pc) {
		setTitle("Registrar computadora");

		if (pc != null) {
			setTitle("Editar computadora: " + pc.getModelo());
		}

		setBounds(100, 100, 675, 443);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 290, 350 };
		gbl_contentPanel.rowHeights = new int[] { 130, 220, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nombre y descripci\u00F3n",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel.setBounds(12, 25, 22, 16);
			panel.add(lblNewLabel);

			tbId = new JTextField();
			tbId.setFont(new Font("Arial", Font.PLAIN, 12));
			tbId.setEditable(false);
			tbId.setBounds(46, 22, 116, 22);
			panel.add(tbId);
			tbId.setColumns(10);
			if (pc != null) {
				tbId.setText(pc.getId());
			} else {
				tbId.setText("C-" + Controladora.idproduct);
			}

			JLabel lblNewLabel_1 = new JLabel("Marca:");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(12, 56, 46, 16);
			panel.add(lblNewLabel_1);

			tbBrand = new JTextField();
			tbBrand.setFont(new Font("Arial", Font.PLAIN, 12));
			tbBrand.setBounds(70, 53, 130, 22);
			panel.add(tbBrand);
			tbBrand.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Modelo:");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(12, 88, 46, 16);
			panel.add(lblNewLabel_2);

			tbModel = new JTextField();
			tbModel.setFont(new Font("Arial", Font.PLAIN, 12));
			tbModel.setBounds(70, 85, 116, 22);
			panel.add(tbModel);
			tbModel.setColumns(10);
		}

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "Detalles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_1.gridx = 1;
		gbc_panel_1_1.gridy = 0;
		contentPanel.add(panel_1_1, gbc_panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Costo de montaje:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(6, 25, 112, 16);
		panel_1_1.add(lblNewLabel_3);

		spMountCost = new JSpinner();
		spMountCost.setFont(new Font("Arial", Font.PLAIN, 12));
		spMountCost.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spMountCost.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				calcTotalCost();
			}
		});
		spMountCost.setBounds(121, 22, 57, 22);
		panel_1_1.add(spMountCost);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCantidad.setBounds(6, 57, 55, 16);
		panel_1_1.add(lblCantidad);

		spQty = new JSpinner();
		spQty.setFont(new Font("Arial", Font.PLAIN, 12));
		spQty.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spQty.setBounds(69, 54, 62, 22);
		panel_1_1.add(spQty);

		JLabel lblNmeroDeSerie = new JLabel("N\u00FAmero de serie:");
		lblNmeroDeSerie.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNmeroDeSerie.setBounds(6, 86, 100, 16);
		panel_1_1.add(lblNmeroDeSerie);

		tbSeriesNumber = new JTextField();
		tbSeriesNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		tbSeriesNumber.setBounds(121, 83, 217, 22);
		panel_1_1.add(tbSeriesNumber);
		tbSeriesNumber.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Precio total:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(188, 54, 69, 16);
		panel_1_1.add(lblNewLabel_6);

		tbTotalCost = new JTextField();
		tbTotalCost.setFont(new Font("Arial", Font.PLAIN, 12));
		tbTotalCost.setText("0");
		tbTotalCost.setEditable(false);
		tbTotalCost.setBounds(269, 51, 69, 22);
		panel_1_1.add(tbTotalCost);
		tbTotalCost.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Subtotal:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(206, 22, 59, 16);
		panel_1_1.add(lblNewLabel_4);

		tbPrice = new JTextField();
		tbPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		tbPrice.setBounds(269, 16, 69, 22);
		panel_1_1.add(tbPrice);
		tbPrice.setText("0");
		tbPrice.setEditable(false);
		tbPrice.setColumns(10);

		JPanel panel_1_11;
		panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Partes de computadora", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1_11 = new GridBagConstraints();
		gbc_panel_1_11.gridwidth = 2;
		gbc_panel_1_11.fill = GridBagConstraints.BOTH;
		gbc_panel_1_11.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1_11.gridx = 0;
		gbc_panel_1_11.gridy = 1;
		contentPanel.add(panel_1, gbc_panel_1_11);

		JLabel lblNewLabel_5 = new JLabel("*Tarjeta Madre:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(12, 32, 111, 16);
		panel_1.add(lblNewLabel_5);

		JButton btnSelectMotherboard = new JButton("Seleccionar");
		btnSelectMotherboard.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSelectMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// types: "RAM", "HARDDRIVE", "PROCESADOR", "MOTHERBOARD"
				CompFinder finderMotherBoardDialog = new CompFinder("MOTHERBOARD");
				finderMotherBoardDialog.setModal(true);
				finderMotherBoardDialog.setVisible(true);
				String selectedID = finderMotherBoardDialog.getSelectedIDs().get(0);
				if (selectedID != null) {
					selectedMotherboard = (TarjetaMadre) Controladora.getInstance().findProductById(selectedID);
					lblSelectedMotherboard
							.setText(selectedMotherboard.getMarca() + " " + selectedMotherboard.getModelo());
					lblSelectedMotherboard.setForeground(Color.BLUE);
					calcTotalCost();
				}
			}
		});
		btnSelectMotherboard.setBounds(12, 53, 111, 25);
		panel_1.add(btnSelectMotherboard);

		lblSelectedMotherboard = new JLabel("No seleccionado...");
		lblSelectedMotherboard.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelectedMotherboard.setForeground(Color.RED);
		lblSelectedMotherboard.setBounds(126, 32, 175, 16);
		panel_1.add(lblSelectedMotherboard);

		JLabel lblProcesador = new JLabel("*Procesador:");
		lblProcesador.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProcesador.setBounds(357, 32, 85, 16);
		panel_1.add(lblProcesador);

		lblSelectedProcesador = new JLabel("No seleccionado...");
		lblSelectedProcesador.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelectedProcesador.setForeground(Color.RED);
		lblSelectedProcesador.setBounds(449, 32, 151, 16);
		panel_1.add(lblSelectedProcesador);

		JButton btnSelectProcesador = new JButton("Seleccionar");
		btnSelectProcesador.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSelectProcesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// types: "RAM", "HARDDRIVE", "PROCESADOR", "MOTHERBOARD"
				CompFinder finderProcesadorDialog = new CompFinder("PROCESADOR");
				finderProcesadorDialog.setModal(true);
				finderProcesadorDialog.setVisible(true);
				String selectedID = finderProcesadorDialog.getSelectedIDs().get(0);
				if (selectedID != null) {
					selectedProcesador = (Microprocesador) Controladora.getInstance().findProductById(selectedID);
					lblSelectedProcesador.setText(selectedProcesador.getMarca() + " " + selectedProcesador.getModelo());
					lblSelectedProcesador.setForeground(Color.BLUE);
					calcTotalCost();
				}
			}
		});
		btnSelectProcesador.setBounds(357, 53, 117, 25);
		panel_1.add(btnSelectProcesador);

		JLabel lblAlmacenamiento = new JLabel("*Almacenamiento:");
		lblAlmacenamiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAlmacenamiento.setBounds(12, 91, 111, 16);
		panel_1.add(lblAlmacenamiento);

		lblSelectedHardDrive = new JLabel("No seleccionado(s)...");
		lblSelectedHardDrive.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelectedHardDrive.setForeground(Color.RED);
		lblSelectedHardDrive.setBounds(126, 91, 127, 16);
		panel_1.add(lblSelectedHardDrive);

		JButton btnSelectHardDrive = new JButton("Seleccionar");
		btnSelectHardDrive.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSelectHardDrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// types: "RAM", "HARDDRIVE", "PROCESADOR", "MOTHERBOARD"

				ArrayList<Product> hardDriveList = new ArrayList<Product>();
				if (selectedHardDrives.size() > 0) {
					for (DiscoDuro hardDrive : selectedHardDrives) {
						hardDriveList.add(hardDrive);
					}
				}

				PCPartsManagement pcPartsDialog = new PCPartsManagement(hardDriveList, "HARDDRIVE");
				pcPartsDialog.setModal(true);
				pcPartsDialog.setVisible(true);

				selectedHardDrives.clear();

				for (Product product : pcPartsDialog.currentList) {
					selectedHardDrives.add((DiscoDuro) product);
				}

				lblSelectedHardDrive.setText("(" + selectedHardDrives.size() + ") Almacenamiento(s)");
				lblSelectedHardDrive.setForeground(Color.BLUE);
				calcTotalCost();

			}
		});
		btnSelectHardDrive.setBounds(12, 112, 117, 25);
		panel_1.add(btnSelectHardDrive);

		JLabel lblMemoriasRam = new JLabel("*Memoria(s) RAM:");
		lblMemoriasRam.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMemoriasRam.setBounds(357, 91, 111, 16);
		panel_1.add(lblMemoriasRam);

		lblSelectedRAM = new JLabel("No seleccionado(s)...");
		lblSelectedRAM.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelectedRAM.setForeground(Color.RED);
		lblSelectedRAM.setBounds(480, 91, 120, 16);
		panel_1.add(lblSelectedRAM);

		JButton btnSelectRAM = new JButton("Seleccionar");
		btnSelectRAM.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSelectRAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// types: "RAM", "HARDDRIVE", "PROCESADOR", "MOTHERBOARD"
				ArrayList<Product> RamList = new ArrayList<Product>();

				if (selectedRAMs.size() > 0) {
					for (MemoriaRAM ram : selectedRAMs) {
						RamList.add(ram);
					}
				}
				PCPartsManagement pcPartsDialog = new PCPartsManagement(RamList, "RAM");
				pcPartsDialog.setModal(true);
				pcPartsDialog.setVisible(true);

				selectedRAMs.clear();

				for (Product product : pcPartsDialog.currentList) {
					selectedRAMs.add((MemoriaRAM) product);
				}

				lblSelectedRAM.setText("(" + selectedRAMs.size() + ") Memoria(s) RAM");
				lblSelectedRAM.setForeground(Color.BLUE);

				calcTotalCost();

			}
		});
		btnSelectRAM.setBounds(357, 112, 117, 25);
		panel_1.add(btnSelectRAM);

		JLabel lblAdicional = new JLabel("Adicional:");
		lblAdicional.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAdicional.setBounds(12, 150, 56, 16);
		panel_1.add(lblAdicional);

		lblSelectedAddons = new JLabel("No seleccionado(s)...");
		lblSelectedAddons.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSelectedAddons.setForeground(Color.RED);
		lblSelectedAddons.setBounds(80, 150, 127, 16);
		panel_1.add(lblSelectedAddons);

		JButton btnSelectAddons = new JButton("Seleccionar");
		btnSelectAddons.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSelectAddons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// types: "RAM", "HARDDRIVE", "PROCESADOR", "MOTHERBOARD"
				ArrayList<Product> AddonsList = new ArrayList<Product>();

				if (selectedAddonsId.size() > 0) {
					for (String addonId : selectedAddonsId) {
						AddonsList.add(Controladora.getInstance().findProductById(addonId));
					}
				}

				PCPartsManagement pcPartsDialog = new PCPartsManagement(AddonsList, "");
				pcPartsDialog.setModal(true);
				pcPartsDialog.setVisible(true);

				selectedAddonsId.clear();

				for (Product product : pcPartsDialog.currentList) {
					selectedAddonsId.add(product.getId());
				}

				lblSelectedAddons.setText("(" + selectedAddonsId.size() + ") Adicional(es)");
				lblSelectedAddons.setForeground(Color.BLUE);
				calcTotalCost();

			}
		});
		btnSelectAddons.setBounds(12, 171, 117, 25);
		panel_1.add(btnSelectAddons);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String id = tbId.getText();
						String brand = tbBrand.getText();
						String model = tbModel.getText();
						Float Mountcost = Float.parseFloat(spMountCost.getValue().toString());

						float price = Float.parseFloat(tbPrice.getText());
						int quantity = (int) spQty.getValue();
						String series = tbSeriesNumber.getText();

						if (pc == null) {

							if (id.length() <= 0 || brand.length() <= 0 || model.length() <= 0 || Mountcost <= 0
									|| quantity <= 0 || series.length() <= 0 || selectedHardDrives.size() <= 0 || selectedRAMs.size() <= 0 || selectedProcesador == null || selectedMotherboard == null) {
								JOptionPane.showMessageDialog(null, "Debe completar los campos requeridos.", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								Computadora newPc = new Computadora(id, brand, model, Mountcost, price, quantity,
										series, selectedHardDrives, selectedRAMs, selectedMotherboard,
										selectedProcesador, selectedAddonsId);

								Controladora.getInstance().addProduct(newPc);

								JOptionPane.showMessageDialog(null, "Operación satisfactoria",
										"Registro de computadora", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}

						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void calcTotalCost() {
		// Costo total de las RAMs
		float RAMsTotalCost = 0;
		if (selectedRAMs != null) {
			for (MemoriaRAM selectedRam : selectedRAMs) {
				if (selectedRam != null) {
					Float ramCosto = selectedRam.getCosto();
					Float ramPrecio = selectedRam.getPrecio();
					float ramCostoValue = (ramCosto != null) ? ramCosto : 0.0f;
					float ramPrecioValue = (ramPrecio != null) ? ramPrecio : 0.0f;
					RAMsTotalCost += ramCostoValue + ramPrecioValue;
				}
			}
		}

		// Costo total de almacenamientos
		float HardDrivesTotalCost = 0;
		if (selectedHardDrives != null) {
			for (DiscoDuro selectedHardDrive : selectedHardDrives) {
				if (selectedHardDrive != null) {
					Float hardDriveCosto = selectedHardDrive.getCosto();
					Float hardDrivePrecio = selectedHardDrive.getPrecio();
					float hardDriveCostoValue = (hardDriveCosto != null) ? hardDriveCosto : 0.0f;
					float hardDrivePrecioValue = (hardDrivePrecio != null) ? hardDrivePrecio : 0.0f;
					HardDrivesTotalCost += hardDriveCostoValue + hardDrivePrecioValue;
				}
			}
		}

		// Costo total de adicionales
		float AdditionalsTotalCost = 0;
		if (selectedAddonsId != null) {
			for (String selectedAdditionalId : selectedAddonsId) {
				Product product = Controladora.getInstance().findProductById(selectedAdditionalId);
				if (product != null) {
					Float additionalCosto = product.getCosto();
					Float additionalPrecio = product.getPrecio();
					float additionalCostoValue = (additionalCosto != null) ? additionalCosto : 0.0f;
					float additionalPrecioValue = (additionalPrecio != null) ? additionalPrecio : 0.0f;
					AdditionalsTotalCost += additionalCostoValue + additionalPrecioValue;
				}
			}
		}

		// Costo de la motherboard
		Float motherboardCost = selectedMotherboard != null ? selectedMotherboard.getTotalCost() : null;
		float motherboardCostValue = (motherboardCost != null) ? motherboardCost : 0.0f;

		// Costo del procesador
		Float procesadorCost = selectedProcesador != null ? selectedProcesador.getTotalCost() : null;
		float procesadorCostValue = (procesadorCost != null) ? procesadorCost : 0.0f;

		// Costo de montaje
		Float mountCost = null;
		try {
			mountCost = Float.parseFloat(spMountCost.getValue().toString());
		} catch (NumberFormatException e) {
			mountCost = 0.0f;
		}
		float subTotalNewCost = motherboardCostValue + procesadorCostValue + RAMsTotalCost + HardDrivesTotalCost
				+ AdditionalsTotalCost;

		// Mostrar el costo subtotal en el campo de texto
		tbPrice.setText(Float.toString(subTotalNewCost));

		// Mostrar el costo total en el campo de texto
		tbTotalCost.setText(Float.toString(subTotalNewCost + mountCost));
	}

	private void clean() {

		spMountCost.setValue(0);
		tbPrice.setText("0");
		tbTotalCost.setText("0");
		tbSeriesNumber.setText("");
		tbBrand.setText("");
		tbModel.setText("");
		spQty.setValue(0);

		selectedMotherboard = null;
		lblSelectedMotherboard.setText("No seleccionado...");
		lblSelectedMotherboard.setForeground(Color.RED);

		selectedProcesador = null;
		lblSelectedProcesador.setText("No seleccionado...");
		lblSelectedProcesador.setForeground(Color.RED);

		selectedAddonsId.clear();
		lblSelectedAddons.setText("No seleccionado(s)...");
		lblSelectedAddons.setForeground(Color.RED);

		selectedHardDrives.clear();
		lblSelectedHardDrive.setText("No seleccionado(s)...");
		lblSelectedHardDrive.setForeground(Color.RED);

		selectedRAMs.clear();
		lblSelectedRAM.setText("No seleccionado(s)...");
		lblSelectedRAM.setForeground(Color.RED);
	}
}
