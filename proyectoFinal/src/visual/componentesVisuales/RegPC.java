package visual.componentesVisuales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import logico.Computadora;
import logico.Controladora;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

public class RegPC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tbId;
	private JTextField tbBrand;
	private JTextField tbModel;
	private JTextField tbSeriesNumber;
	private JSpinner spQty;
	private JSpinner spPrice;
	private JSpinner spMountCost;
	private JLabel lblSelectedHardDrive;
	private JLabel lblSelectedProcesador;
	private JLabel lblSelectedMotherboard;
	private JLabel lblSelectedRAM;
	private JTextPane tpNotes;
	private JPanel panel_1;
	
	private String selectedMotherboardId;
	private String selectedRAMId;
	private String selectedHardDriveId;
	private String selectedProcesadorId;
	private JTextField tbTotalCost;

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
		
		if(pc != null) {
			setTitle("Editar computadora: " + pc.getModelo());
		}
		
		setBounds(100, 100, 675, 479);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {290, 350};
		gbl_contentPanel.rowHeights = new int[] {130, 260, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nombre y descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(12, 25, 22, 16);
			panel.add(lblNewLabel);
			
			tbId = new JTextField();
			tbId.setEditable(false);
			tbId.setBounds(46, 22, 116, 22);
			panel.add(tbId);
			tbId.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Marca:");
			lblNewLabel_1.setBounds(12, 56, 46, 16);
			panel.add(lblNewLabel_1);
			
			tbBrand = new JTextField();
			tbBrand.setBounds(70, 53, 130, 22);
			panel.add(tbBrand);
			tbBrand.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Modelo:");
			lblNewLabel_2.setBounds(12, 88, 46, 16);
			panel.add(lblNewLabel_2);
			
			tbModel = new JTextField();
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
		lblNewLabel_3.setBounds(6, 25, 112, 16);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio:");
		lblNewLabel_4.setBounds(218, 54, 47, 16);
		panel_1_1.add(lblNewLabel_4);
		
		spMountCost = new JSpinner();
		spMountCost.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spMountCost.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				tbTotalCost.setText(spMountCost.getValue().toString());
			}
		});
		spMountCost.setBounds(121, 22, 57, 22);
		panel_1_1.add(spMountCost);
		
		spPrice = new JSpinner();
		spPrice.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spPrice.setBounds(269, 51, 69, 22);
		panel_1_1.add(spPrice);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(6, 57, 55, 16);
		panel_1_1.add(lblCantidad);
		
		spQty = new JSpinner();
		spQty.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spQty.setBounds(69, 54, 62, 22);
		panel_1_1.add(spQty);
		
		JLabel lblNmeroDeSerie = new JLabel("N\u00FAmero de serie:");
		lblNmeroDeSerie.setBounds(6, 86, 100, 16);
		panel_1_1.add(lblNmeroDeSerie);
		
		tbSeriesNumber = new JTextField();
		tbSeriesNumber.setBounds(121, 83, 217, 22);
		panel_1_1.add(tbSeriesNumber);
		tbSeriesNumber.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Costo total:");
		lblNewLabel_6.setBounds(196, 25, 69, 16);
		panel_1_1.add(lblNewLabel_6);
		
		tbTotalCost = new JTextField();
		tbTotalCost.setEditable(false);
		tbTotalCost.setBounds(269, 22, 69, 22);
		panel_1_1.add(tbTotalCost);
		tbTotalCost.setColumns(10);
		
		JPanel panel_1_11;
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Partes de computadora", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1_11 = new GridBagConstraints();
		gbc_panel_1_11.gridwidth = 2;
		gbc_panel_1_11.fill = GridBagConstraints.BOTH;
		gbc_panel_1_11.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1_11.gridx = 0;
		gbc_panel_1_11.gridy = 1;
		contentPanel.add(panel_1, gbc_panel_1_11);
		
		JLabel lblNewLabel_5 = new JLabel("Tarjeta Madre:");
		lblNewLabel_5.setBounds(12, 32, 97, 16);
		panel_1.add(lblNewLabel_5);
		
		JButton btnSelectMotherboard = new JButton("Seleccionar");
		btnSelectMotherboard.setBounds(12, 53, 117, 25);
		panel_1.add(btnSelectMotherboard);
		
		lblSelectedMotherboard = new JLabel("No seleccionado(s)...");
		lblSelectedMotherboard.setForeground(Color.RED);
		lblSelectedMotherboard.setBounds(106, 32, 120, 16);
		panel_1.add(lblSelectedMotherboard);
		
		JLabel lblRAM = new JLabel("Procesador:");
		lblRAM.setBounds(406, 32, 85, 16);
		panel_1.add(lblRAM);
		
		lblSelectedProcesador = new JLabel("No seleccionado(s)...");
		lblSelectedProcesador.setForeground(Color.RED);
		lblSelectedProcesador.setBounds(503, 32, 120, 16);
		panel_1.add(lblSelectedProcesador);
		
		JButton btnSelectProcesador = new JButton("Seleccionar");
		btnSelectProcesador.setBounds(406, 53, 117, 25);
		panel_1.add(btnSelectProcesador);
		
		JLabel label = new JLabel("Disco Duro:");
		label.setBounds(12, 91, 66, 16);
		panel_1.add(label);
		
		lblSelectedHardDrive = new JLabel("No seleccionado(s)...");
		lblSelectedHardDrive.setForeground(Color.RED);
		lblSelectedHardDrive.setBounds(90, 91, 127, 16);
		panel_1.add(lblSelectedHardDrive);
		
		JButton btnSelectHardDrive = new JButton("Seleccionar");
		btnSelectHardDrive.setBounds(12, 112, 117, 25);
		panel_1.add(btnSelectHardDrive);
		
		JLabel label_1 = new JLabel("Memoria RAM:");
		label_1.setBounds(406, 91, 85, 16);
		panel_1.add(label_1);
		
		lblSelectedRAM = new JLabel("No seleccionado(s)...");
		lblSelectedRAM.setForeground(Color.RED);
		lblSelectedRAM.setBounds(503, 91, 120, 16);
		panel_1.add(lblSelectedRAM);
		
		JButton btnSelectRAM = new JButton("Seleccionar");
		btnSelectRAM.setBounds(406, 112, 117, 25);
		panel_1.add(btnSelectRAM);
		
		JLabel lblNewLabel_7 = new JLabel("Anotaci\u00F3n adicional:");
		lblNewLabel_7.setBounds(12, 150, 117, 16);
		panel_1.add(lblNewLabel_7);
		
		tpNotes = new JTextPane();
		tpNotes.setBounds(12, 179, 611, 64);
		panel_1.add(tpNotes);
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
						float Mountcost = (float) spMountCost.getValue();
						
						float price = (float) spPrice.getValue();
						float quantity = (float) spQty.getValue();
						String series = tbSeriesNumber.getText();
						
						if(pc == null) {
							//Computadora newPc = new Computadora(Controladora.idproduct, brand, model, cost, price, quantity, series, null, null, null, null, mountCost, null);
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
	
	private void load(Computadora pc) {
		
	}
}
