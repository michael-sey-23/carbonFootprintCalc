import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Carbon Footprint Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());

        // PANEL FOR INPUT FIELDS
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 5, 5));

        // USER INPUT FIELDS
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();

        // VEHICLE INPUTS
        JComboBox<FuelType> fuelDropdown = new JComboBox<>(FuelType.values());
        JTextField mileageField = new JTextField();
        JTextField fuelConsumptionField = new JTextField();
        JTextField engineSizeField = new JTextField();

        // HOME INPUTS
        JComboBox<SourceType> homeDropdown = new JComboBox<>(SourceType.values());
        JTextField homeEnergyField = new JTextField();



        // ADD FIELDS TO PANEL
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        panel.add(ageField);

        panel.add(new JLabel("Fuel Type:"));
        panel.add(fuelDropdown);

        panel.add(new JLabel("Annual Mileage (km):"));
        panel.add(mileageField);

        panel.add(new JLabel("Fuel Consumption (L/100km):"));
        panel.add(fuelConsumptionField);

        panel.add(new JLabel("Engine Size (L):"));
        panel.add(engineSizeField);

        panel.add(new JLabel("Home Energy Source:"));
        panel.add(homeDropdown);

        panel.add(new JLabel("Annual Energy Usage (kWh):"));
        panel.add(homeEnergyField);



        // BUTTON
        JButton calculateBtn = new JButton("Calculate Carbon Footprint");

        // OUTPUT AREA
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // BUTTON ACTION
        calculateBtn.addActionListener(e -> {
            try {
                // Retrieve all inputs
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                FuelType fuel = (FuelType) fuelDropdown.getSelectedItem();
                double mileage = Double.parseDouble(mileageField.getText());
                double fuelCons = Double.parseDouble(fuelConsumptionField.getText());
                double engine = Double.parseDouble(engineSizeField.getText());
                SourceType source = (SourceType) homeDropdown.getSelectedItem();
                double energy = Double.parseDouble(homeEnergyField.getText());


                // Create objects
                Vehicle vehicle = new Car(fuel, mileage, fuelCons, engine);
                Home home = new Home(source, energy);


                // Create user
                User user = new User(name, vehicle, home, age);

                // Display output
                outputArea.setText(user.generateReport());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please check your values.");
            }
        });

        // ADD COMPONENTS TO FRAME
        frame.add(panel, BorderLayout.NORTH);
        frame.add(calculateBtn, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
