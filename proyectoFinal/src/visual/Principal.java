package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import logico.Controladora;
import logico.Empleado;
import logico.Usuario;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Dimension dim;
    private JMenu menuCon2;
    private JMenu menuCon;
    private JMenu menuAdmin;
    private JMenu mnAdmin;
    private JButton btniniciosesion;
    private JPanel pnInicioSesion;
    private JTextField txtCorreo;
    private JLabel lblNewLabel;
    private JButton btnContra;
    private JTextField txtcontra;
    private JButton btnNewButton_1;
    private JLabel lblinicio;
    private JPanel pnContrasena;
    private Empleado Admin = null;
    private boolean inicioSesion = false;
    private JPanel pnUser;
    private JLabel lblimg;
    private JLabel lblnom;
    private JButton button;
    private JButton btnAtrasInicio;

    public static void main(String[] args) {
        Controladora.getInstance().getMisUsuarios().add(new Empleado("E1", "Oliver jose paulino perez", "Oliver@gmail.com", "8097914801", "blah blah", "1230", 15000, false));
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuCon = new JMenu("menu");
        menuCon.setMargin(new Insets(5, 5, 5, 5));
        menuCon.setFont(new Font("Arial", Font.PLAIN, 14));
        menuBar.add(menuCon);

        menuCon2 = new JMenu("consumidor");
        menuCon2.setMargin(new Insets(5, 5, 5, 5));
        menuCon2.setFont(new Font("Arial", Font.PLAIN, 14));
        menuBar.add(menuCon2);

        menuAdmin = new JMenu("Administrador");
        menuAdmin.setMargin(new Insets(5, 5, 5, 5));
        menuAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
        menuBar.add(menuAdmin);

        mnAdmin = new JMenu("Administrador");
        mnAdmin.setMargin(new Insets(5, 5, 5, 5));
        mnAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
        mnAdmin.setBackground(Color.WHITE);
        menuBar.add(mnAdmin);

        btnNewButton_1 = new JButton("Iniciar Sesion");
        btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pnInicioSesion.setVisible(true);
            }
        });
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        dim = getToolkit().getScreenSize();
        setSize(dim.width, dim.height - 35);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        pnUser = new JPanel();
        pnUser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        pnUser.setBackground(Color.WHITE);
        pnUser.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "opciones!", "Inicio de Sesion", JOptionPane.WARNING_MESSAGE);
            }
        });
        pnUser.setVisible(false);

        pnInicioSesion = new JPanel();
        pnInicioSesion.setVisible(false);
        pnInicioSesion.setBackground(Color.WHITE);
        pnInicioSesion.setBounds(702, 231, 489, 271);
        panel.add(pnInicioSesion);
        pnInicioSesion.setLayout(null);

        JButton btnEnviar = new JButton("Siguiente");
        btnEnviar.setBorderPainted(false);
        btnEnviar.setFocusTraversalKeysEnabled(false);
        btnEnviar.setFocusable(false);
        btnEnviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEnviar.setBackground(new Color(66, 133, 244));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnEnviar.setBackground(new Color(66, 133, 244));
            }
        });
        btnEnviar.setBackground(new Color(66, 133, 244));
        btnEnviar.setForeground(Color.BLACK);
        btnEnviar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Usuario user = Controladora.getInstance().buscarUsuarioByCorreo(txtCorreo.getText().toString());
                if (user != null) {
                    pnContrasena.setVisible(true);
                    pnInicioSesion.setVisible(false);
                    Admin = (Empleado) user;
                } else {
                    JOptionPane.showMessageDialog(null, "No encontramos ningun email, hable con el manager", "Registro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnEnviar.setBounds(366, 219, 89, 23);
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorder(BorderFactory.createLineBorder(new Color(66, 133, 244), 1));
        pnInicioSesion.add(btnEnviar);

        txtCorreo = new JTextField();
        txtCorreo.setForeground(Color.BLACK);
        txtCorreo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Correo Electronico", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
        txtCorreo.setBounds(106, 112, 276, 39);
        pnInicioSesion.add(txtCorreo);
        txtCorreo.setColumns(10);

        lblNewLabel = new JLabel("Inicio De Sesion");
        lblNewLabel.setForeground(SystemColor.textHighlight);
        lblNewLabel.setBackground(SystemColor.textHighlight);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
        lblNewLabel.setBounds(164, 36, 161, 25);
        pnInicioSesion.add(lblNewLabel);

        btnAtrasInicio = new JButton("<");
        btnAtrasInicio.setFocusPainted(false);
        btnAtrasInicio.setFocusTraversalKeysEnabled(false);
        btnAtrasInicio.setBorderPainted(false);
        btnAtrasInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pnInicioSesion.setVisible(false);
                txtCorreo.setText("");
            }
        });
        btnAtrasInicio.setFont(new Font("Arial", Font.PLAIN, 15));
        btnAtrasInicio.setBorder(null);
        btnAtrasInicio.setBackground(new Color(66, 133, 244));
        btnAtrasInicio.setForeground(Color.BLACK);
        btnAtrasInicio.setBounds(56, 218, 89, 23);
        pnInicioSesion.add(btnAtrasInicio);
        pnUser.setBounds(1738, 0, 156, 36);
        panel.add(pnUser);
        pnUser.setLayout(null);

        lblnom = new JLabel("New label");
        lblnom.setHorizontalAlignment(SwingConstants.RIGHT);
        lblnom.setBounds(12, 6, 97, 22);
        pnUser.add(lblnom);

        lblimg = new JLabel("");
        ImageIcon imageni = new ImageIcon(Controladora.class.getResource("/img/user.png"));
        Image image = imageni.getImage();
        lblimg.setIcon(new ImageIcon(image.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

        lblimg.setBounds(113, 3, 30, 30);
        pnUser.add(lblimg);

        btniniciosesion = new JButton("Iniciar Sesion");
        btniniciosesion.setBounds(1783, 0, 111, 26);
        panel.add(btniniciosesion);

        pnContrasena = new JPanel();
        pnContrasena.setBounds(702, 231, 489, 271);
        panel.add(pnContrasena);
        pnContrasena.setVisible(false);
        pnContrasena.setBackground(Color.WHITE);
        pnContrasena.setLayout(null);

        btnContra = new JButton("Enviar");
        btnContra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String passw = txtcontra.getText().toString();
                if (Admin.getPassword().equals(passw)) {
                    JOptionPane.showMessageDialog(null, "Su inicio de sesion ha sido exitosa!", "Inicio de Sesion", JOptionPane.INFORMATION_MESSAGE);
                    inicioSesion = true;
                    loadMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Correo o contrasena son incorrectos!", "Inicio de Sesion", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnContra.setBounds(366, 219, 89, 23);
        btnContra.setForeground(Color.BLACK);
        btnContra.setBackground(Color.WHITE);
        btnContra.setBorder(new LineBorder(new Color(66, 133, 244), 1, true));
        btnContra.setBackground(new Color(66, 133, 244));
        pnContrasena.add(btnContra);

        txtcontra = new JPasswordField();
        txtcontra.setForeground(Color.BLACK);
        txtcontra.setBounds(106, 112, 276, 39);
        txtcontra.setColumns(10);
        txtcontra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contrasena del correo", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
        pnContrasena.add(txtcontra);

        lblinicio = new JLabel("Inicio De Sesion");
        lblinicio.setBounds(164, 36, 161, 25);
        lblinicio.setBackground(SystemColor.textHighlight);
        lblinicio.setForeground(SystemColor.textHighlight);
        lblinicio.setFont(new Font("Arial", Font.BOLD, 21));
        pnContrasena.add(lblinicio);

        button = new JButton("Atras");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pnContrasena.setVisible(false);
                pnInicioSesion.setVisible(true);
            }
        });
        button.setBounds(55, 218, 89, 23);
        pnContrasena.add(button);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.ITALIC, 12));
        button.setBorder(null);
        button.setBackground(Color.WHITE);
        btniniciosesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pnInicioSesion.setVisible(true);
            }
        });
    }

    private void loadMenu() {
        if (inicioSesion) {
            btniniciosesion.setVisible(false);
            pnUser.setVisible(true);
            pnContrasena.setVisible(false);
            lblnom.setText(Admin.getNombre());
        }
    }
}
