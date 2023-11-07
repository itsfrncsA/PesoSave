import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int centerX = (screenSize.width - 1280) / 2;
		int centerY = (screenSize.height - 780) / 2;

		setBounds(centerX, centerY, 1280, 750);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGUIMain = new JLabel("");
		lblGUIMain.setIcon(new ImageIcon("C:\\Users\\franc\\Desktop\\CCDATRCL-2NDYR-1ST-main\\Photos\\PesoSaveMain.png"));
		lblGUIMain.setBounds(0, 0, 1280, 770);
		contentPane.add(lblGUIMain);
		
		JButton expenseTrackerButton = new JButton("");
		expenseTrackerButton.setBounds(60, 180, 200, 40);
		contentPane.add(expenseTrackerButton);
        expenseTrackerButton.setOpaque(false);

		

		expenseTrackerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openExpenseIncomeTracker();
			}
		});
	}

	private void openExpenseIncomeTracker() {
		Expense_Income_Tracker expenseIncomeTracker = new Expense_Income_Tracker();
		expenseIncomeTracker.main(new String[]{});
	}
}
