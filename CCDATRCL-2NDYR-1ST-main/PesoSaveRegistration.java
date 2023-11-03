import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

public class PesoSaveRegistration extends JFrame {
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;

    public PesoSaveRegistration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPesoSaveRegister = new JLabel("");
        lblPesoSaveRegister.setBounds(0, 0, 600, 650);
        lblPesoSaveRegister.setIcon(new ImageIcon("C:\\Users\\franc\\Desktop\\CCDATRCL-2NDYR-1ST-main\\Photos\\PesoSaveRegister.png"));
        contentPane.add(lblPesoSaveRegister);

        usernameField = new JTextField();
        usernameField.setBounds(70, 215, 331, 34);
        contentPane.add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(70, 370, 331, 34);
        contentPane.add(passwordField);

        emailField = new JTextField();
        emailField.setBounds(70, 290, 259, 34);
        contentPane.add(emailField);

        JButton btnRegister = new JButton("Sign Up");
        btnRegister.setBounds(170, 450, 180, 40);
        contentPane.add(btnRegister);

        JButton lblLogin = new JButton("Login");
        lblLogin.setBounds(200, 570, 100, 40);
        contentPane.add(lblLogin);

        lblLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLoginForm();
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();

                saveToTextFile(username, password, email);
                openLoginForm();
            }
        });
    }

    private void saveToTextFile(String username, String password, String email) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("user_credentials.txt", true));
            writer.write(username + "," + password + "," + email);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openLoginForm() {
        PesoSaveLogin loginForm = new PesoSaveLogin();
        loginForm.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PesoSaveRegistration frame = new PesoSaveRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
