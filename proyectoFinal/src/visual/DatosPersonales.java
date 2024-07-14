package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Empleado;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DatosPersonales extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtid;
	private JTextField txtCargo;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JButton btnedit;
	private JButton cancelButton;
	private JTextField pfAntigua;
	private JTextField pfNueva1;
	private JTextField pfNueva2;
	private JPanel pnCambioContra;
	private JButton btnCancelarcambio;
	private JButton btncambio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DatosPersonales dialog = new DatosPersonales(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DatosPersonales(Empleado Emp) {
		setBounds(100, 100, 592, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(UIManager.getColor("Button.light"));
				panel_1.setBounds(5, 0, 556, 42);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNombre = new JLabel("Nombre: ");

					lblNombre.setBounds(67, 17, 421, 14);
					if (Emp != null) {
						String nombre = Emp.getNombre();
						lblNombre.setText("Nombre: " + nombre != null ? nombre : "");
					}
					panel_1.add(lblNombre);
				}
			}
			{
				JLabel lblNewLabel = new JLabel("id:");
				lblNewLabel.setBounds(100, 60, 12, 20);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblCargo = new JLabel("Cargo:");
				lblCargo.setBounds(79, 90, 33, 20);
				panel.add(lblCargo);
			}
			{
				JLabel lblCoreo = new JLabel("Correo:");
				lblCoreo.setBounds(75, 120, 37, 20);
				panel.add(lblCoreo);
			}
			{
				JLabel lblTelefono = new JLabel("Telefono:");
				lblTelefono.setBounds(66, 153, 46, 14);
				panel.add(lblTelefono);
			}
			{
				JLabel lblDireccion = new JLabel("Direccion:");
				lblDireccion.setBounds(65, 180, 47, 39);
				panel.add(lblDireccion);
			}
			{
				btncambio = new JButton("Cambiar Contrasena");
				btncambio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (btncambio.getText().equals("Cambiar Contrasena")) {
							pnCambioContra.setVisible(true);
							btncambio.setText("Confirmar Cambio");
							btnCancelarcambio.setVisible(true);
							btnedit.setEnabled(false);
							cancelButton.setEnabled(false);
						} else {
							String antigua = pfAntigua.getText().toString();
							String nueva1 = pfNueva1.getText().toString();
							String nueva2 = pfNueva2.getText().toString();
							
							if (antigua.equals(Emp.getPassword()) && nueva1.equals(nueva2)) {
								Emp.setPassword(nueva1);
								JOptionPane.showMessageDialog(null, "Operacion Exitosa", "SUCCESS",
										JOptionPane.INFORMATION_MESSAGE);
								pnCambioContra.setVisible(false);
								btnedit.setEnabled(true);
								cancelButton.setEnabled(true);
								btnCancelarcambio.setVisible(false);
							} else if (!nueva1.equals(nueva2)) {
								JOptionPane.showMessageDialog(null,
										"Las contrasenas escritas no son iguales, volver a digitar", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null,
										"Contrasena \"Antigua\" es erronea, volver a escribir", "ERROR",
										JOptionPane.ERROR_MESSAGE);

							}
						}
					}

				});
				btncambio.setBounds(217, 249, 131, 23);
				panel.add(btncambio);
			}
			{
				txtid = new JTextField();
				txtid.setBounds(158, 60, 256, 20);
				txtid.setText(Emp.getId());
				txtid.setEnabled(false);
				panel.add(txtid);
				txtid.setColumns(10);
			}
			{
				txtCargo = new JTextField();
				txtCargo.setColumns(10);
				txtCargo.setText(Emp.isManager() ? "Manager" : "Cajero/No-Manager");
				txtCargo.setEnabled(false);
				txtCargo.setBounds(158, 90, 256, 20);
				panel.add(txtCargo);
			}
			{
				txtCorreo = new JTextField();
				txtCorreo.setColumns(10);
				txtCorreo.setText(Emp.getEmail());
				txtCorreo.setEnabled(false);
				txtCorreo.setBounds(158, 120, 256, 20);
				panel.add(txtCorreo);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setColumns(10);
				txtTelefono.setText(Emp.getNumero());
				txtTelefono.setEnabled(false);
				txtTelefono.setBounds(158, 150, 256, 20);
				panel.add(txtTelefono);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setText(Emp.getDireccion());
				txtDireccion.setEnabled(false);
				txtDireccion.setBounds(158, 180, 256, 39);
				panel.add(txtDireccion);
			}

			pnCambioContra = new JPanel();
			pnCambioContra.setVisible(false);
			pnCambioContra.setBackground(UIManager.getColor("Button.light"));
			pnCambioContra.setBounds(5, 279, 556, 57);
			panel.add(pnCambioContra);
			pnCambioContra.setLayout(null);

			JLabel lblNewLabel_1 = new JLabel("Antigua:");
			lblNewLabel_1.setBounds(14, 21, 41, 14);
			pnCambioContra.add(lblNewLabel_1);

			pfAntigua = new JPasswordField();
			pfAntigua.setBounds(64, 18, 111, 20);
			pnCambioContra.add(pfAntigua);

			JLabel lblContrasenaNueva = new JLabel("Nueva:");
			lblContrasenaNueva.setBounds(184, 21, 35, 14);
			pnCambioContra.add(lblContrasenaNueva);

			pfNueva1 = new JPasswordField();
			pfNueva1.setBounds(228, 18, 111, 20);
			pnCambioContra.add(pfNueva1);

			JLabel lblRepetir = new JLabel("Repetir Nueva:");
			lblRepetir.setBounds(348, 21, 73, 14);
			pnCambioContra.add(lblRepetir);

			pfNueva2 = new JPasswordField();
			pfNueva2.setBounds(430, 18, 111, 20);
			pnCambioContra.add(pfNueva2);

			btnCancelarcambio = new JButton("Cancelar");
			btnCancelarcambio.setVisible(false);
			btnCancelarcambio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnCambioContra.setVisible(false);
					btnCancelarcambio.setVisible(false);
					pfAntigua.setText("");
					pfNueva1.setText("");
					pfNueva2.setText("");
					btnedit.setEnabled(true);
					cancelButton.setEnabled(true);
					btncambio.setText("Cambiar Contrasena");
				}
			});
			btnCancelarcambio.setActionCommand("Cancelar");
			btnCancelarcambio.setBounds(358, 249, 75, 23);
			panel.add(btnCancelarcambio);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnedit = new JButton("Editar");
				btnedit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (btnedit.getText().equals("Editar")) {
							editInfo(true);
							btncambio.setEnabled(false);
						} else {
							Emp.setDireccion(txtDireccion.getText());
							Emp.setEmail(txtCorreo.getText());
							Emp.setNumero(txtTelefono.getText());
							btncambio.setEnabled(true);
							editInfo(false);
						}
					}
				});
				btnedit.setActionCommand("OK");
				buttonPane.add(btnedit);
				getRootPane().setDefaultButton(btnedit);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cancelButton.getText().equals("Cancelar Cambios")) {
							editInfo(false);
							txtCorreo.setText(Emp.getEmail());
							txtDireccion.setText(Emp.getDireccion());
							txtTelefono.setText(Emp.getNumero());

						} else {
							dispose();
						}
					}
				});
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void editInfo(boolean state) {
		txtCorreo.setEnabled(state);
		txtDireccion.setEnabled(state);
		txtTelefono.setEnabled(state);
		if (state) {
			btnedit.setText("Actualizar Datos");
			cancelButton.setText("Cancelar Cambios");
		} else {
			btnedit.setText("Editar");
			cancelButton.setText("Cancelar");
		}

	}
}
