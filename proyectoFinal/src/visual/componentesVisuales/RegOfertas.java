package visual.componentesVisuales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Controladora;
import logico.DiscoDuro;
import logico.Empleado;
import logico.MemoriaRAM;
import logico.Product;
import logico.Usuario;
import visual.Principal;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegOfertas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelo;
	private static String idSelected;
	private JTable table;
	private JButton btnOferta;
	private JComboBox<String> cbxFiltro;
	private Product prodSelected = null;
	private JSpinner spnDescuento;
	private JTextField txtDescuento;
	private float descuento, descuentoFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegOfertas dialog = new RegOfertas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegOfertas() {
		setBounds(100, 100, 698, 400);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.textHighlight);
			panel_1.setBounds(0, 0, 672, 51);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel = new JLabel("Porcentaje a reducir:");
			lblNewLabel.setForeground(SystemColor.text);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 11, 137, 29);
			panel_1.add(lblNewLabel);

			spnDescuento = new JSpinner();
			spnDescuento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
			spnDescuento.setBounds(168, 11, 145, 29);
			panel_1.add(spnDescuento);

			JLabel lblPrecioFinal = new JLabel("Precio Final:");
			lblPrecioFinal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPrecioFinal.setForeground(Color.WHITE);
			lblPrecioFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPrecioFinal.setBounds(350, 11, 137, 29);
			panel_1.add(lblPrecioFinal);

			txtDescuento = new JTextField();
			txtDescuento.setDisabledTextColor(SystemColor.activeCaptionText);
			txtDescuento.setEnabled(false);
			txtDescuento.setEditable(false);
			txtDescuento.setBounds(505, 11, 145, 29);
			panel_1.add(txtDescuento);
			txtDescuento.setColumns(10);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(0, 51, 672, 267);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			panel_2.add(scrollPane, BorderLayout.CENTER);

			modelo = new DefaultTableModel();
			table = new JTable();
			table.setDefaultEditor(Object.class, null);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index = table.getSelectedRow();
					if (index >= 0) {
						idSelected = new String(table.getValueAt(index, 1).toString());
						btnOferta.setEnabled(true);

						prodSelected = Controladora.getInstance().findProductById(idSelected);
						
						if(prodSelected.isOferta() == true)
							spnDescuento.setValue(prodSelected.getPorcentajeDescuento());
						
						actualizarPrecioFinal();

					} else {
						btnOferta.setEnabled(false);

					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			String[] headers = { "Tipo", "ID", "Marca", "Modelo", "Numero de Serie", "Costo", "Precio Real" };
			modelo.setColumnIdentifiers(headers);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			cbxFiltro = new JComboBox<String>();
			cbxFiltro.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					loadProducts(cbxFiltro.getSelectedItem().toString());
				}
			});
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] { "Todos", "Disco Duro", "Computadora",
					"Memoria Ram", "Microprocesador", "Tarjeta Madre" }));
			buttonPane.add(cbxFiltro);
			{
				btnOferta = new JButton("Publicar Oferta");
				btnOferta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(descuento > 0) {
							prodSelected.setOferta(true);
							prodSelected.setPrecioOferta(prodSelected.getPrecio()-descuentoFinal);
							prodSelected.setPorcentajeDescuento(descuento);
							JOptionPane.showMessageDialog(null, "Se ha publicado la oferta", "OFERTA", JOptionPane.INFORMATION_MESSAGE);
							
						}else {
							if(prodSelected.isOferta()) {
								prodSelected.setOferta(false);
								JOptionPane.showMessageDialog(null, "Se ha quitado la oferta del producto", "OFERTA", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						clean();
						Controladora.getInstance().guardarDatos();
						
					}
				});
				btnOferta.setActionCommand("OK");
				btnOferta.setEnabled(false);
				buttonPane.add(btnOferta);
				getRootPane().setDefaultButton(btnOferta);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		spnDescuento.addChangeListener(e -> {
				 if (prodSelected != null) {
	                    actualizarPrecioFinal();
	                }
		});
		loadProducts(cbxFiltro.getSelectedItem().toString());
	}

	public void loadProducts(String filtro) {
		ArrayList<Product> prods = Controladora.getInstance().ListarProductosPorFiltro(filtro);
		modelo.setRowCount(0);

		for (Product prod : prods) {
			Object[] row = new Object[7];
			row[0] = Controladora.getInstance().BuscarTipoDeUnProducto(prod);
			row[1] = prod.getId();
			row[2] = prod.getMarca();
			row[3] = prod.getModelo();
			row[4] = prod.getNumeroSerie();
			row[5] = prod.getCosto();
			row[6] = prod.getPrecio();

			modelo.addRow(row);
		}

		table.setModel(modelo);
	}
	
    private void actualizarPrecioFinal() {
    	 if (prodSelected != null) {
             descuento = ((Float) spnDescuento.getValue()).floatValue();
             descuentoFinal = prodSelected.getPrecio() * ( descuento / 100);
             txtDescuento.setText(String.format("%.2f $", prodSelected.getPrecio() - descuentoFinal));
         } else {
             txtDescuento.setText("");
         }
    }
    
    private void clean() {
    	spnDescuento.setValue(1f);
    	idSelected = null;
    	prodSelected = null;
    	btnOferta.setEnabled(false);
    	table.clearSelection();
    	txtDescuento.setText("");
    }
}
