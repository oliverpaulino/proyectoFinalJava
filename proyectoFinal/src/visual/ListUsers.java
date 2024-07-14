package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Controladora;
import logico.Empleado;
import logico.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListUsers extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel modelo;
	private static String idSelected;
	private JButton btnDelete;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListUsers dialog = new ListUsers(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListUsers(String type) {
		if (type == "EMPLEADO") {
			setTitle("Lista de empleados");
		} else if(type == "CLIENTE") {
			setTitle("Lista de clientes");
		}

		setBounds(100, 100, 839, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				modelo = new DefaultTableModel();
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int index = table.getSelectedRow();
						if (index >= 0) {
							idSelected = new String(table.getValueAt(index, 0).toString());
							btnDelete.setEnabled(true);
							btnEdit.setEnabled(true);
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] headers = { "ID", "Nombre", "Email", "Telefono", "Direccion" };

				if (type == "EMPLEADO") {
					String[] empHeaders = new String[headers.length + 2];
					System.arraycopy(headers, 0, empHeaders, 0, headers.length);
					empHeaders[5] = "Salario";
					empHeaders[6] = "Rol";
					modelo.setColumnIdentifiers(empHeaders);
				} else {
					modelo.setColumnIdentifiers(headers);
				}

				scrollPane.setViewportView(table);

			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAdd = new JButton("A\u00F1adir");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AddUser addEmp = new AddUser(null, type);
						addEmp.setModal(true);
						addEmp.setVisible(true);
						loadUsers(type);
					}
				});
				buttonPane.add(btnAdd);
			}
			{
				btnEdit = new JButton("Editar");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AddUser editUser = new AddUser(Controladora.getInstance().findUserById(idSelected), type);
						editUser.setModal(true);
						editUser.setVisible(true);
						
						loadUsers(type);
					}
				});
				btnEdit.setEnabled(false);
				buttonPane.add(btnEdit);
			}
			{
				btnDelete = new JButton("Eliminar");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(idSelected != null) {
							 int res = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar el usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

						        if (res == JOptionPane.YES_OPTION) {
									Controladora.getInstance().deleteUser(idSelected);
						            JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
									loadUsers(type);
						        }
						}
					}
					
				});
				btnDelete.setEnabled(false);
				buttonPane.add(btnDelete);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadUsers(type);
	}

	public void loadUsers(String type) {
		ArrayList<Usuario> users = Controladora.getInstance().getMisUsuarios();
		modelo.setRowCount(0);

		for (Usuario user : users) {
			Object[] row = new Object[5];

			row[0] = user.getId();
			row[1] = user.getNombre();
			row[2] = user.getEmail();
			row[3] = user.getNumero();
			row[4] = user.getDireccion();
			
			if (type == "EMPLEADO" && user instanceof Empleado) {
				Object[] empRow = new Object[7];
				System.arraycopy(row, 0, empRow, 0, row.length);
				empRow[5] = ((Empleado) user).getSalario();
				empRow[6] = ((Empleado) user).isManager() ? "Manager" : "Cajero";
				modelo.addRow(empRow);

			} else if(type == "CLIENTE" && user instanceof Cliente){
				modelo.addRow(row);
			}
		}

		table.setModel(modelo);
	}

}
