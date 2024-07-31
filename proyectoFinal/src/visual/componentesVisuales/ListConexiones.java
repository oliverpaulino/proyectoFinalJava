package visual.componentesVisuales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListConexiones extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ArrayList<String> conexiones =new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListConexiones dialog = new ListConexiones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListConexiones() {
		setTitle("Conexiones");
		setBounds(100, 100, 193, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("SATA");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 12, 82, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblSpata = new JLabel("PATA");
		lblSpata.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSpata.setBounds(10, 38, 82, 14);
		contentPanel.add(lblSpata);
		
		JLabel lblScsi = new JLabel("SCSI");
		lblScsi.setFont(new Font("Arial", Font.PLAIN, 16));
		lblScsi.setBounds(10, 64, 82, 14);
		contentPanel.add(lblScsi);
		
		JLabel lblSas = new JLabel("SAS");
		lblSas.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSas.setBounds(10, 90, 82, 14);
		contentPanel.add(lblSas);
		
		JLabel lblSsd = new JLabel("SSD");
		lblSsd.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSsd.setBounds(10, 116, 82, 14);
		contentPanel.add(lblSsd);
		
		JLabel lblNvme = new JLabel("NVMe");
		lblNvme.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNvme.setBounds(10, 142, 82, 14);
		contentPanel.add(lblNvme);
		
		JLabel lblEsata = new JLabel("eSATA");
		lblEsata.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEsata.setBounds(10, 168, 82, 14);
		contentPanel.add(lblEsata);
		
		JLabel lblExpress = new JLabel("Express");
		lblExpress.setFont(new Font("Arial", Font.PLAIN, 16));
		lblExpress.setBounds(10, 194, 82, 19);
		contentPanel.add(lblExpress);
		
		JSpinner spnSATA = new JSpinner();
		spnSATA.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnSATA.setFont(new Font("Arial", Font.PLAIN, 16));
		spnSATA.setBounds(102, 7, 64, 20);
		contentPanel.add(spnSATA);
		
		JSpinner spnPATA = new JSpinner();
		spnPATA.setFont(new Font("Arial", Font.PLAIN, 16));
		spnPATA.setBounds(102, 34, 64, 20);
		contentPanel.add(spnPATA);
		
		JSpinner spnSCSI = new JSpinner();
		spnSCSI.setFont(new Font("Arial", Font.PLAIN, 16));
		spnSCSI.setBounds(102, 61, 64, 20);
		contentPanel.add(spnSCSI);
		
		JSpinner spnSAS = new JSpinner();
		spnSAS.setFont(new Font("Arial", Font.PLAIN, 16));
		spnSAS.setBounds(102, 88, 64, 20);
		contentPanel.add(spnSAS);
		
		JSpinner spnSSD = new JSpinner();
		spnSSD.setFont(new Font("Arial", Font.PLAIN, 16));
		spnSSD.setBounds(102, 115, 64, 20);
		contentPanel.add(spnSSD);
		
		JSpinner spnNVMe = new JSpinner();
		spnNVMe.setFont(new Font("Arial", Font.PLAIN, 16));
		spnNVMe.setBounds(102, 142, 64, 20);
		contentPanel.add(spnNVMe);
		
		JSpinner spnESATA = new JSpinner();
		spnESATA.setFont(new Font("Arial", Font.PLAIN, 16));
		spnESATA.setBounds(102, 169, 64, 20);
		contentPanel.add(spnESATA);
		
		JSpinner spnExpress = new JSpinner();
		spnExpress.setFont(new Font("Arial", Font.PLAIN, 16));
		spnExpress.setBounds(102, 196, 64, 20);
		contentPanel.add(spnExpress);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for (int i = 0; i < (int) spnSATA.getValue(); i++) {
							conexiones.add("SATA");
						}
						for (int i = 0; i < (int) spnPATA.getValue(); i++) {
							conexiones.add("PATA");
						}
						for (int i = 0; i < (int) spnESATA.getValue(); i++) {
							conexiones.add("eSATA");
						}
						for (int i = 0; i < (int) spnSAS.getValue(); i++) {
							conexiones.add("SAS");
						}
						for (int i = 0; i < (int) spnExpress.getValue(); i++) {
							conexiones.add("Express");
						}
						for (int i = 0; i < (int) spnNVMe.getValue(); i++) {
							conexiones.add("NVMe");
						}
						for (int i = 0; i < (int) spnSCSI.getValue(); i++) {
							conexiones.add("SCSI");
						}
						for (int i = 0; i < (int) spnSSD.getValue(); i++) {
							conexiones.add("SSD");
						}
						dispose();
						
					}
				});
				okButton.setFont(new Font("Arial", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
