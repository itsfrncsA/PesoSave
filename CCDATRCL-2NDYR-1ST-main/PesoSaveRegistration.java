import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PesoSaveRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblPesoSaveRegister;

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


	public PesoSaveRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Make the frame non-resizable
        setSize(1280, 750); // Set the size of the frame

        // Center the window
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
        usernameTextField= new JTextField();
        usernameTextField.setForeground(Color.BLACK);
        usernameTextField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        usernameTextField.setBounds(73, 275, 372, 31);
        usernameTextField.setBackground(null);
        usernameTextField.setBorder(null);
        usernameTextField.setOpaque(false);
        usernameTextField.setColumns(10);
        contentPane.add(usernameTextField);
		
        emailTextField= new JTextField();
        emailTextField.setForeground(Color.BLACK);
        emailTextField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        emailTextField.setBounds(73, 352, 372, 31);
        emailTextField.setBackground(null);
        emailTextField.setBorder(null);
        emailTextField.setOpaque(false);
        emailTextField.setColumns(10);
        contentPane.add(emailTextField);
		
        passwordField = new JPasswordField();
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        passwordField.setBackground(null);
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        passwordField.setBounds(73, 429, 329, 37);
        passwordField.setColumns(10);
        contentPane.add(passwordField);
		
		JButton btnSignUp = new JButton(""); 
        btnSignUp.setOpaque(false);
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setBounds(63, 500, 372, 48);
        contentPane.add(btnSignUp);
		
		JButton btnContinueWithEmail = new JButton(""); 
        btnContinueWithEmail.setOpaque(false);
        btnContinueWithEmail.setContentAreaFilled(false);
        btnContinueWithEmail.setBorderPainted(false);
        btnContinueWithEmail.setBounds(63, 516, 372, 48);
        contentPane.add(btnContinueWithEmail);
		
        
        btnLogin = new JButton("");
        btnLogin.setOpaque(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setBounds(333, 595, 63, 21);
        contentPane.add(btnLogin);
        
        lblPesoSaveRegister = new JLabel("");
        lblPesoSaveRegister.setIcon(new ImageIcon("C:\\Users\\franc\\Desktop\\CCDATRCL-2NDYR-1ST-main\\Photos\\PesoSaveRegister.png"));
        lblPesoSaveRegister.setBounds(0, 0, 1280, 770);
        contentPane.add(lblPesoSaveRegister);
        

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLoginForm();
            }
        });
		
		btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String username =  usernameTextField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailTextField.getText();

                saveToTextFile(username, password, email);
                openLoginForm();
            }
        });
    }
	
    private void saveToTextFile(String username, String password, String email) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("user_credentials.txt", true));
            writer.write(username + " ," + password + " ," + email);
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

    public static void main1(String[] args) {
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
