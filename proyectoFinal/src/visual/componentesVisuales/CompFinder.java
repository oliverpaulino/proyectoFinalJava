package visual.componentesVisuales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import logico.Controladora;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.Product;
import logico.TarjetaMadre;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CompFinder extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelo;
	private JTextField tbSearch;
	private JTable table;
	private ArrayList<String> idsSelected = new ArrayList<String>();
	private JButton okButton;
	private JLabel resultsLabel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CompFinder dialog = new CompFinder(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CompFinder(String type) {
		// types: "RAM", "HARDDRIVE", "PROCESADOR", "MOTHERBOARD"
		setTitle("Buscador de componentes | " + getTypeName(type));
		setBounds(100, 100, 732, 446);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 250, 0, 30 };
		gbl_contentPanel.rowHeights = new int[] { 30, 30, 0, 350 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblNewLabel = new JLabel("Buscar componente:");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			tbSearch = new JTextField();
			tbSearch.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel.setLabelFor(tbSearch);
			tbSearch.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					textChanged();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					textChanged();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					textChanged();
				}

				private void textChanged() {
					String searchText = tbSearch.getText();
					findProducts(searchText, type);
				}
			});

			tbSearch.setToolTipText("Escribe ID o nombre de " + getTypeName(type));
			GridBagConstraints gbc_tbSearch = new GridBagConstraints();
			gbc_tbSearch.gridwidth = 2;
			gbc_tbSearch.insets = new Insets(0, 0, 5, 5);
			gbc_tbSearch.fill = GridBagConstraints.HORIZONTAL;
			gbc_tbSearch.gridx = 2;
			gbc_tbSearch.gridy = 1;
			contentPanel.add(tbSearch, gbc_tbSearch);
			tbSearch.setColumns(10);
		}
		{
			resultsLabel = new JLabel("Resultados ():");
			resultsLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			GridBagConstraints gbc_resultsLabel = new GridBagConstraints();
			gbc_resultsLabel.insets = new Insets(0, 0, 5, 5);
			gbc_resultsLabel.gridx = 1;
			gbc_resultsLabel.gridy = 2;
			contentPanel.add(resultsLabel, gbc_resultsLabel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 3;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				table = new JTable();
				table.setFont(new Font("Arial", Font.PLAIN, 12));
				modelo = new DefaultTableModel();

				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {

					}
				});

				table.setModel(modelo);

				if (type.equalsIgnoreCase("PROCESADOR") || type.equalsIgnoreCase("MOTHERBOARD")) {
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				} else {
					table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				}

				String[] headers = { "ID", "Marca", "Modelo", "Precio", "Numero de Serie" };
				modelo.setColumnIdentifiers(headers);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Seleccionar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int[] selectionedRows = table.getSelectedRows();
						

						if (selectionedRows.length > 0) {
							idsSelected.clear();
							for (int row : selectionedRows) {
								idsSelected.add(new String(table.getValueAt(row, 0).toString()));
							}
							
							System.out.println("Multi: " + idsSelected);
							dispose();
						} else {
							
							JOptionPane.showMessageDialog(null, "No ha seleccionado ningún producto");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		findProducts("", type);
	}

	public void findProducts(String search, String type) {
		ArrayList<Product> products = Controladora.getInstance().getProducts();
		modelo.setRowCount(0);
		int resultCount = 0;

		if (search == "") {
			for (Product product : products) {
				if (isType(product, type)) {
					Object[] row = new Object[table.getColumnCount()];
					row[0] = product.getId();
					row[1] = product.getMarca();
					row[2] = product.getModelo();
					row[3] = product.getPrecio();
					row[4] = product.getNumeroSerie();
					modelo.addRow(row);
					resultCount++;
				}
			}
		} else {
			for (Product product : products) {
				String lowerCaseSearch = search.toLowerCase();

				if (isType(product, type)) {
					if (product.getId().toLowerCase().contains(lowerCaseSearch)
							|| product.getMarca().toLowerCase().contains(lowerCaseSearch)
							|| product.getModelo().toLowerCase().contains(lowerCaseSearch)
							|| String.valueOf(product.getPrecio()).contains(lowerCaseSearch)
							|| product.getNumeroSerie().toLowerCase().contains(lowerCaseSearch)) {

						Object[] row = new Object[table.getColumnCount()];
						row[0] = product.getId();
						row[1] = product.getMarca();
						row[2] = product.getModelo();
						row[3] = product.getPrecio();
						row[4] = product.getNumeroSerie();
						modelo.addRow(row);
						resultCount++;
					}
				}
			}
		}

		resultsLabel.setText("Resultado(s) (" + resultCount + ")");

		table.setModel(modelo);
	}

	public ArrayList<String> getSelectedIDs() {
		return idsSelected;
	}

	private String getTypeName(String type) {
		switch (type) {
		case "RAM":
			return "Memoria RAM";
		case "HARDDRIVE":
			return "Almacenamiento";
		case "PROCESADOR":
			return "Procesador";
		case "MOTHERBOARD":
			return "Tarjeta Madre";
		}
		return type;
	}

	private boolean isType(Product product, String type) {
		return ((product instanceof DiscoDuro) && type.equalsIgnoreCase("HARDDRIVE"))
				|| ((product instanceof MemoriaRAM) && type.equalsIgnoreCase("RAM"))
				|| ((product instanceof Microprocesador) && type.equalsIgnoreCase("PROCESADOR"))
				|| ((product instanceof TarjetaMadre) && type.equalsIgnoreCase("MOTHERBOARD"))
				|| type.equalsIgnoreCase("");
	}

}
