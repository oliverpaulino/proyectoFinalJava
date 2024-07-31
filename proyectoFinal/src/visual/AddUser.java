package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Controladora;
import logico.Empleado;
import logico.Usuario;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class AddUser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tbId;
	private JTextField tbName;
	private JTextField tbEmail;
	private JTextField tbPhone;
	private JTextField tbAddress;
	private JTextField tbPassword;
	private JSpinner spSalary;
	private JComboBox cbType;
	private int idActual =  Controladora.getInstance().getMisUsuarios() == null? 1 : Controladora.getInstance().getMisUsuarios().size()+1 ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddUser dialog = new AddUser(null, "CLIENTE");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddUser(Usuario user, String type) { //type: CLIENTE || EMPLEADO
		setTitle("A\u00F1adir "+type.toLowerCase());
		if (user != null) {
			setTitle("Editar "+type.toLowerCase());
		}
		
		
		// (String id, String nombre, String email, String numero, String direccion,
		// String password, float salario, boolean manager )
		setBounds(100, 100, 658, 379);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 2, 0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(
					new TitledBorder(null, "Detalles personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);

			tbId = new JTextField();
			tbId.setEditable(false);
			tbId.setBounds(12, 24, 116, 22);
			panel.add(tbId);
			tbId.setColumns(10);
			tbId.setText( user!= null? user.getId(): "U-" +idActual);

			tbName = new JTextField();
			tbName.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			tbName.setBounds(12, 55, 269, 43);
			panel.add(tbName);
			tbName.setColumns(10);

			tbEmail = new JTextField();
			tbEmail.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			tbEmail.setBounds(12, 105, 269, 43);
			panel.add(tbEmail);
			tbEmail.setColumns(10);

			tbPhone = new JTextField();
			tbPhone.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tel\u00E9fono", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			tbPhone.setBounds(12, 159, 269, 43);
			panel.add(tbPhone);
			tbPhone.setColumns(10);

			tbAddress = new JTextField();
			tbAddress.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Direcci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			tbAddress.setBounds(12, 215, 269, 43);
			panel.add(tbAddress);
			tbAddress.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(
					new TitledBorder(null, "Ajustes avanzados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);

			tbPassword = new JTextField();
			tbPassword.setEnabled(false);
			tbPassword.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			tbPassword.setBounds(12, 24, 195, 43);
			panel.add(tbPassword);
			tbPassword.setColumns(10);

			spSalary = new JSpinner();
			spSalary.setEnabled(false);
			spSalary.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Salario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			spSalary.setBounds(12, 75, 96, 43);
			panel.add(spSalary);

			cbType = new JComboBox();
			cbType.setEnabled(false);
			cbType.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			cbType.setModel(new DefaultComboBoxModel(new String[] { "Cajero", "Manager" }));
			cbType.setBounds(12, 131, 153, 43);
			panel.add(cbType);
		}
		if(type == "EMPLEADO") {
			cbType.setEnabled(true);
			spSalary.setEnabled(true);
			tbPassword.setEnabled(true);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("A\u00F1adir");
				if(user != null) {
					okButton.setText("Guardar cambios");
				}
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = tbId.getText();
						String name = tbName.getText();
						String email = tbEmail.getText();
						String phone = tbPhone.getText();
						String address = tbAddress.getText();
						String password = tbPassword.getText();
						Number salary = 
								(Number) spSalary.getValue();
						String typeEmp = cbType.getSelectedItem().toString();

						if(Controladora.getInstance().buscarExistenciaDeEmail(email) == false)
							if (user == null) {
								
								if(type == "EMPLEADO") {
									Empleado newEmp = new Empleado(id, name, email, phone, address, password, salary.floatValue(),
											typeEmp.equalsIgnoreCase("Manager"));
									Controladora.getInstance().addUser(newEmp);
								} else if(type == "CLIENTE") {
									Cliente newClient = new Cliente(id, name, email, phone, address);
									Controladora.getInstance().addUser(newClient);
								}
								
								JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Registro de "+type.toLowerCase(),
										JOptionPane.INFORMATION_MESSAGE);
								idActual++;
								cleanUser();
							} else {
								tbId.setText(user.getId());
								user.setNombre(name);
								user.setEmail(email);
								user.setNumero(phone);
								user.setDireccion(address);
								
								if(user instanceof Empleado) {
									((Empleado) user).setPassword(password);
									((Empleado) user).setSalario(salary.floatValue());
									((Empleado) user).setManager(type.equalsIgnoreCase("Manager"));
								} else if(user instanceof Cliente) {
									/*...*/
								}
								
								Controladora.getInstance().deleteUser(user.getId());
								Controladora.getInstance().addUser(user);
								Controladora.getInstance().getMisUsuarios();
								
								JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Actualización de "+type.toLowerCase(),
										JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
						else {
							JOptionPane.showMessageDialog(null, "ESTE CORREO ESTA EN USO", "ERROR", JOptionPane.ERROR_MESSAGE);
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
		loadUser(user);
	}

	public void loadUser(Usuario user) {
		if (user != null) {
			tbId.setText(user.getId());
			tbName.setText(user.getNombre());
			tbEmail.setText(user.getEmail());
			tbPhone.setText(user.getNumero());
			tbAddress.setText(user.getDireccion());
			
			if(user instanceof Empleado) {
				tbPassword.setText(((Empleado) user).getPassword());
				spSalary.setValue(((Empleado) user).getSalario());
				cbType.setSelectedItem(((Empleado) user).isManager() ? "Manager" : "Empleado");
			} else if(user instanceof Cliente) {
				/*...*/
			}
		}
	}

	public void cleanUser() {
		tbId.setText("U-" + (idActual));
		tbName.setText("");
		tbEmail.setText("");
		tbPhone.setText("");
		tbAddress.setText("");
		tbPassword.setText("");
		spSalary.setValue(0);
		cbType.setSelectedItem("Empleado");
	}
}
