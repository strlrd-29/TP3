import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

public class App {
    public DefaultTableModel model;

    public static void main(String[] args) throws Exception {
        Object[][] data = { { 1, "John", "Doe", "01/01/2000", "MI" }, { 2, "Jane", "Doe", "01/01/2000", "MI" },
                { 3, "John", "Doe", "01/01/2000", "MI" }, { 4, "Jane", "Doe", "01/01/2000", "MI" } };

        String[] columnNames = { "Matricule", "Prénom", "Nom", "Date de naissance", "Spécialité" };

        JFrame frame = new JFrame("TP3");
        frame.setBounds(350, 100, 550, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        // get table model
        

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 250, 500, 250);
        panel.add(scrollPane);

        JLabel addStudent = new JLabel("Ajouter un étudiant");
        addStudent.setFont(new Font("Arial", Font.BOLD, 20));
        addStudent.setBounds(180, 20, 200, 20);
        panel.add(addStudent);
        JLabel number = new JLabel("Matricule");
        number.setFont(new Font("Arial", Font.BOLD, 14));
        number.setBounds(50, 70, 100, 20);
        panel.add(number);
        JLabel firstName = new JLabel("Prénom");
        firstName.setFont(new Font("Arial", Font.BOLD, 14));
        firstName.setBounds(50, 100, 100, 20);
        panel.add(firstName);
        JLabel lastName = new JLabel("Nom");
        lastName.setFont(new Font("Arial", Font.BOLD, 14));
        lastName.setBounds(50, 130, 100, 20);
        panel.add(lastName);
        JLabel birthDate = new JLabel("Date de naissance");
        birthDate.setFont(new Font("Arial", Font.BOLD, 14));
        birthDate.setBounds(50, 160, 100, 20);
        panel.add(birthDate);
        JLabel speciality = new JLabel("Spécialité");
        speciality.setFont(new Font("Arial", Font.BOLD, 14));
        speciality.setBounds(50, 190, 100, 20);
        panel.add(speciality);

        JTextField numberField = new JTextField();
        numberField.setBounds(180, 70, 200, 25);
        panel.add(numberField);
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(180, 100, 200, 25);
        panel.add(firstNameField);
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(180, 130, 200, 25);
        panel.add(lastNameField);
        JTextField birthDateField = new JTextField();
        birthDateField.setBounds(180, 160, 200, 25);
        panel.add(birthDateField);

        // combo box for speciality
        String[] specialities = { "MI", "DSIA" };
        JComboBox<String> specialityComboBox = new JComboBox<String>(specialities);
        specialityComboBox.setBounds(180, 190, 200, 25);
        panel.add(specialityComboBox);

        JButton addButton = new JButton("Ajouter");
        addButton.setBackground(Color.GREEN);
        addButton.setBounds(390, 190, 130, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = numberField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String birthDate = birthDateField.getText();
                String speciality = (String) specialityComboBox.getSelectedItem();
                if (number.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || birthDate.isEmpty()
                        || speciality.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Object[] row = { number, firstName, lastName, birthDate, speciality };
                    model.addRow(new Object [] {number,firstName,lastName,birthDate,speciality});
                    JOptionPane.showMessageDialog(frame, "Etudiant ajouté");

                    numberField.setText("");
                    firstNameField.setText("");
                    lastNameField.setText("");
                    birthDateField.setText("");
                    specialityComboBox.setSelectedIndex(0);
                }
            }
        });
        panel.add(addButton);
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.setBackground(Color.RED);
        deleteButton.setBounds(200, 520, 150, 25);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int row_number = table.getSelectedRowCount();
            	if(row_number == 1) {
            		model.removeRow(row_number);
            		JOptionPane.showMessageDialog(frame, "Etudiant supprimé");
            	} else {
            		JOptionPane.showMessageDialog(frame, "Vous devez selectionner un etudiant", "Suppression", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
        panel.add(deleteButton);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
