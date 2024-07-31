package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Controladora;
import logico.Order;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListFacturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel modelo;
	private static Object row[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListFacturacion dialog = new ListFacturacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListFacturacion() {
		setBounds(100, 100, 1019, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				modelo = new DefaultTableModel();
				table = new JTable();
				table.setDefaultEditor(Object.class, null);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table.getSelectedRow();
						if(index>=0){
							
							
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] headers = {"Id", "Cliente","Vendedor","Cantidad de Productos",  "Fecha"  ,"Total"};
				modelo.setColumnIdentifiers(headers);
				table.setModel(modelo);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadFacturas();
	}
	
	private void loadFacturas() {
		// TODO Auto-generated method stub
		ArrayList<Order>misOrders = Controladora.getInstance().getOrders();
		
		for (Order order : misOrders) {
			Object[] row = new Object[6];
			row[0]= order.getId();
			row[1]= order.getClientId();
			row[2]= order.getEmpId();
			row[3]= order.getProducts().size();
			row[4]= order.getDate();
			row[5]= order.getTotal();
			
			modelo.addRow(row);
			
		}
		table.setModel(modelo);

	}

}
