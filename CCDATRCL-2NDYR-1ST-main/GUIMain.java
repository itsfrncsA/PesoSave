import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GUIMain extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUIMain frame = new GUIMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUIMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 770); // Setting the size
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); // Removing any border

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblGUIMain = new JLabel("");
        lblGUIMain.setIcon(new ImageIcon("C:\\Users\\franc\\Desktop\\CCDATRCL-2NDYR-1ST-main\\Photos\\PesoSaveMain.png"));
        lblGUIMain.setBounds(0, 0, 1280, 770);
        contentPane.add(lblGUIMain);

       
        openLoginForm(); // Call this method to open the login form when needed
        // or
        openRegistrationForm(); // Call this method to open the registration form when needed
    }

    private void openLoginForm() {
        PesoSaveLogin loginForm = new PesoSaveLogin();
        loginForm.setVisible(true);
    }

    private void openRegistrationForm() {
        PesoSaveRegistration registrationForm = new PesoSaveRegistration();
        registrationForm.setVisible(true);
    }
}
