import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PesoSaveLogin extends JFrame {
    private JPanel contentPane;
    private JTextField usernameOrEmailField;
    private JPasswordField passwordField;
    private JButton btnLogin; // Changed from JLabel to JButton
    private JLabel lblCreateAccount;
    private JLabel lblPesoSaveLogin;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PesoSaveLogin frame = new PesoSaveLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PesoSaveLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Make the frame non-resizable
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the center position
        int centerX = (screenSize.width - 1280) / 2;
        int centerY = (screenSize.height - 780) / 2;

        // Set the frame's position and size
        setBounds(centerX, centerY, 1280, 750);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        usernameOrEmailField = new JTextField();
        usernameOrEmailField.setForeground(Color.BLACK);
        usernameOrEmailField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        usernameOrEmailField.setBounds(74, 277, 372, 31);
        usernameOrEmailField.setBackground(null);
        usernameOrEmailField.setBorder(null);
        usernameOrEmailField.setOpaque(false);
        usernameOrEmailField.setColumns(10);
        contentPane.add(usernameOrEmailField);

        passwordField = new JPasswordField();
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        passwordField.setBackground(null);
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        passwordField.setBounds(74, 351, 329, 37);
        passwordField.setColumns(10);
        contentPane.add(passwordField);

        btnLogin = new JButton(""); 
        btnLogin.setOpaque(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setBounds(85, 427, 361, 49);
        contentPane.add(btnLogin);
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String usernameOrEmail = usernameOrEmailField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(usernameOrEmail, password)) {
                    openGUIMain();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        lblPesoSaveLogin = new JLabel("");
        lblPesoSaveLogin.setIcon(new ImageIcon("C:\\Users\\franc\\Desktop\\CCDATRCL-2NDYR-1ST-main\\Photos\\PesoSaveLogin.png"));
        lblPesoSaveLogin.setBounds(0, 0, 1280, 770);
        contentPane.add(lblPesoSaveLogin);

        lblCreateAccount = new JLabel(""); // Assuming this is a label and not a button
        lblCreateAccount.setBounds(224, 497, 186, 49);
        contentPane.add(lblCreateAccount);
        
        lblCreateAccount.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                openRegistrationForm();
            }
        });

       
    }

    private boolean authenticateUser(String usernameOrEmail, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("user_credentials.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 3) {
                    String storedUsername = credentials[0];
                    String storedEmail = credentials[2];
                    String storedPassword = credentials[1];

                    if ((storedUsername.equals(usernameOrEmail) || storedEmail.equals(usernameOrEmail)) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void openGUIMain() {
        GUIMain guiMainForm = new GUIMain();
        guiMainForm.setVisible(true);
        this.dispose();
    }

    private void openRegistrationForm() {
        PesoSaveRegistration registrationForm = new PesoSaveRegistration();
        registrationForm.setVisible(true);
        this.dispose();
    }
}