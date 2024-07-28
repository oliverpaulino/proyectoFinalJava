package visual.componentesVisuales;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import logico.Product;
import logico.Controladora;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class ListProduct extends JPanel {

    private JPanel panel = new JPanel();
    private JTextField txtBuscador;
    private JComboBox cbxFiltro ;

    /**
     * Create the panel.
     */
    public ListProduct() {
    	setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        setLayout(new BorderLayout(0, 0));
        panel.setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        txtBuscador = new JTextField();
        txtBuscador.setFont(new Font("Arial", Font.PLAIN, 14));
        panel_1.add(txtBuscador);
        txtBuscador.setColumns(40);
        
        
        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		loadComponents();
        	}
        });
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panel_1.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Por:");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN,  14));
        panel_1.add(lblNewLabel_1);
        
        cbxFiltro = new JComboBox();
        cbxFiltro.setFont(new Font("Arial", Font.PLAIN, 14));
        cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Id", "Num. de serie", "Marca", "Modelo", "Tipo"}));
        
        panel_1.add(cbxFiltro);

        loadComponents();
    }

    public void loadComponents() {
    	String buscadorTxt = txtBuscador.getText().toLowerCase();
    	String tipoBuscador = cbxFiltro.getSelectedItem().toString();
    	System.out.println(tipoBuscador);
    	ArrayList<Product> losComponentes = new ArrayList<>();  
    	if (buscadorTxt.isEmpty()) {
    		losComponentes = Controladora.getInstance().getProducts();
		}
    	else {
			losComponentes = Controladora.getInstance().getFilteredProducts(buscadorTxt, tipoBuscador);
		}
    	
    	
        panel.removeAll(); 
        Dimension cardSize = new Dimension(200, 350);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        int x = 0;
        int y = 1;
        for (Product componente : losComponentes) {
            ProductCard card = new ProductCard(componente);
            card.setPreferredSize(cardSize);

            gbc.gridx = x;
            gbc.gridy = y;
            panel.add(card, gbc);

            x++;
            if (x == 5) {
                x = 0;
                y++;
            }
        }
        panel.revalidate();
        panel.repaint();     
    }
}
