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
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPesoSaveLogin = new JLabel("");
        lblPesoSaveLogin.setBounds(0, 0, 600, 650);
        lblPesoSaveLogin.setIcon(new ImageIcon("C:\\Users\\franc\\Desktop\\CCDATRCL-2NDYR-1ST-main\\Photos\\PesoSaveLogin.png"));
        contentPane.add(lblPesoSaveLogin);

        usernameOrEmailField = new JTextField();
        usernameOrEmailField.setBounds(80, 210, 250, 45);
        contentPane.add(usernameOrEmailField);

        passwordField = new JPasswordField();
        passwordField.setBounds(80, 290, 250, 40);
        contentPane.add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(140, 370, 250, 45);
        contentPane.add(btnLogin);

        JLabel lblCreateAccount = new JLabel("Create an Account");
        lblCreateAccount.setBounds(350, 360, 150, 160);
        contentPane.add(lblCreateAccount);

        lblCreateAccount.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                openRegistrationForm();
            }
        });

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
