package visual.componentesVisuales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Controladora;
import logico.Product;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PCPartsManagement extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel modelo;
	private String idSelected;
	private JButton btnDelete;
	private JButton btnAdd;
	public ArrayList<Product> currentList;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PCPartsManagement dialog = new PCPartsManagement(new ArrayList<Product>(), null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PCPartsManagement(ArrayList<Product> compList, String type) {
		currentList = new ArrayList<>();
		
		
		for(Product product : compList) {
			currentList.add(product);
		}
		
		String midTitle = "Manejador de partes | ";
		
		if(type == "RAM") {
			setTitle(midTitle+"Memoria(s) RAM");
		} else if(type == "HARDDRIVE") {
			setTitle(midTitle + "Almacenamiento");
		} else if(type == "PROCESADOR") {
			setTitle(midTitle + "Procesador");
		} else if(type == "MOTHERBOARD") {
			setTitle(midTitle + "Tarjeta Madre");
		} else {
			setTitle(midTitle + "Componentes Adicionales");
		}
		// types: "RAM", "HARDDRIVE", "PROCESADOR", "MOTHERBOARD"
		
		setBounds(100, 100, 598, 411);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int index = table.getSelectedRow();
						if (index >= 0) {
							idSelected = new String(table.getValueAt(index, 0).toString());
							btnDelete.setEnabled(true);
						}
					}
				});
				modelo = new DefaultTableModel();
				
				table.setModel(modelo);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] headers = { "ID", "Marca", "Modelo", "Precio", "Costo", "Numero de Serie" };
				modelo.setColumnIdentifiers(headers);

				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAdd = new JButton("A\u00F1adir");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// types: "RAM", "HARDDRIVE", "PROCESADOR", "MOTHERBOARD"

						CompFinder finderDialog = new CompFinder(type);
						finderDialog.setModal(true);
						finderDialog.setVisible(true);

						ArrayList<String> selectedIDs = finderDialog.getSelectedIDs();

						if (selectedIDs.size() > 0) {

							for (String selectedId : selectedIDs) {
								Product selectedProduct = Controladora.getInstance().findProductById(selectedId);
								currentList.add(selectedProduct);
							}
							
						}
						
						loadList();
					}
				});
				buttonPane.add(btnAdd);
			}
			{
				btnDelete = new JButton("Eliminar");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentList.remove(Controladora.getInstance().findProductById(idSelected));
						loadList();
					}
				});
				btnDelete.setEnabled(false);
				buttonPane.add(btnDelete);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// Limpiar cambios hechos y cargar lista original
						currentList.clear();
						
						for(Product product : compList) {
							currentList.add(product);
						}
						
						
						dispose();
					}
				});
				{
					btnNewButton = new JButton("Guardar cambios");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					buttonPane.add(btnNewButton);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadList();
	}
	
	private void loadList() {
		modelo.setRowCount(0);
		
		for(Product product : currentList) {
			Object[] row = new Object[table.getColumnCount()];
			row[0] = product.getId();
			row[1] = product.getMarca();
			row[2] = product.getModelo();
			row[3] = product.getPrecio();
			row[4] = product.getCosto();
			row[5] = product.getNumeroSerie();
			modelo.addRow(row);
		}
		
		table.setModel(modelo);
	}

}
