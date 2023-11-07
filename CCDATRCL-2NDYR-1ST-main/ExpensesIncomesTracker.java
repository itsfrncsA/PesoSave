import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;


// ExpenseIncomeEntry class remains unchanged from your provided code

public class ExpensesIncomesTracker extends JFrame {

    private final ExpenseIncomeTableModel tableModel;
    private final JTable table;
    private final JTextField dateField;
    private final JTextField descriptionField;
    private final JTextField amountField;
    private final JComboBox<String> typeCombobox;
    private final JButton addButton;
    private final JButton removeButton;
    private final JLabel balanceLabel;
    private double balance; // The current balance based on the added expenses and incomes.

    public ExpensesIncomesTracker() {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to Set FlatDarkLaf LookAndFeel");
        }

        // Initialize the table model and balance variable.
        balance = 0.0;
        tableModel = new ExpenseIncomeTableModel();

        // Create a JTable and set up a scroll pane to display the data.
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Create input fields and components for adding new entries.
        dateField = new JTextField(10);
        descriptionField = new JTextField(20);
        amountField = new JTextField(10);
        typeCombobox = new JComboBox<>(new String[]{"Expense", "Income"});

        // Attach an ActionListener to the "Add" button to handle new entry addition.
        addButton = new JButton("Add");
        addButton.addActionListener(e -> addEntry());
        
        // Create a button for removing an entry
        removeButton = new JButton("Remove Entry");
        removeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeEntry(selectedRow);
            }
        });

        balanceLabel = new JLabel("Balance: ₱" + balance);

        // Create input panel to arrange input components.
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Date"));
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Description"));
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Amount"));
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("Type"));
        inputPanel.add(typeCombobox);

        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Create bottom panel to display the balance.
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(balanceLabel);
        setLayout(new BorderLayout());

        // Set the layout of the main frame and add components to appropriate positions.
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Set the title, default close operation, and visibility of the main frame.
        setTitle("Expenses And Incomes Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void addEntry() {
        String date = dateField.getText();
        String description = descriptionField.getText();
        String amountStr = amountField.getText();
        String type = (String) typeCombobox.getSelectedItem();
        double amount;

        if (amountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the Amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Amount Format", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (type.equals("Expense")) {
            amount *= -1;
        }

        ExpenseIncomeEntry entry = new ExpenseIncomeEntry(date, description, amount, type);
        tableModel.addEntry(entry);

        balance += amount;
        balanceLabel.setText("Balance: ₱" + balance);

        clearInputFields();
    }

    private void clearInputFields() {
        dateField.setText("");
        descriptionField.setText("");
        amountField.setText("");
        typeCombobox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExpensesIncomesTracker().setLocationRelativeTo(null);
        });
    }
}
