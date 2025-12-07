import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // Frame
        JFrame frame = new JFrame("Carbon Footprint Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 650);
        frame.setLayout(new BorderLayout(10, 10));


        // Title
        JLabel title = new JLabel("Carbon Footprint Calculator", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setOpaque(true);
        title.setBackground(new Color(46, 139, 87)); // green
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        frame.add(title, BorderLayout.NORTH);

        // Input
        JPanel panel = new JPanel(new GridLayout(12, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Fonts
        Font labelFont = new Font("Times New Roman", Font.PLAIN, 16);
        Font inputFont = new Font("Times New Roman", Font.PLAIN, 16);

        // Components
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();

        // Vehicle Type Selection
        String[] vehicleTypes = {"Car", "Motorcycle", "Plane", "Public Transport"};
        JComboBox<String> vehicleTypeDropdown = new JComboBox<>(vehicleTypes);

        JComboBox<FuelType> fuelDropdown = new JComboBox<>(FuelType.values());
        JTextField mileageField = new JTextField();
        JTextField fuelConsumptionField = new JTextField();
        JTextField engineSizeField = new JTextField();
        JComboBox<SourceType> homeDropdown = new JComboBox<>(SourceType.values());
        JTextField homeEnergyField = new JTextField();
        JComboBox<DietType> dietDropdown = new JComboBox<>(DietType.values());


        // Add labels
        panel.add(formatLabel("Name:", labelFont));
        panel.add(formatInput(nameField, inputFont));

        panel.add(formatLabel("Age:", labelFont));
        panel.add(formatInput(ageField, inputFont));

        panel.add(formatLabel("Vehicle Type:", labelFont));
        panel.add(vehicleTypeDropdown);

        panel.add(formatLabel("Fuel Type:", labelFont));
        panel.add(fuelDropdown);

        panel.add(formatLabel("Annual Mileage (km):", labelFont));
        panel.add(formatInput(mileageField, inputFont));

        panel.add(formatLabel("Fuel Consumption (L/100km):", labelFont));
        panel.add(formatInput(fuelConsumptionField, inputFont));

        panel.add(formatLabel("Engine Size (L):", labelFont));
        panel.add(formatInput(engineSizeField, inputFont));

        panel.add(formatLabel("Home Energy Source:", labelFont));
        panel.add(homeDropdown);

        panel.add(formatLabel("Annual Energy (kWh):", labelFont));
        panel.add(formatInput(homeEnergyField, inputFont));

        panel.add(formatLabel("Diet Type: ", labelFont));
        panel.add(dietDropdown);

        frame.add(panel, BorderLayout.CENTER);

        // Calc Button
        JButton calculateBtn = new JButton("Calculate Footprint");
        calculateBtn.setFont(new Font("Arial", Font.BOLD, 18));
        calculateBtn.setBackground(new Color(70, 130, 180));
        calculateBtn.setForeground(Color.WHITE);
        calculateBtn.setFocusPainted(false);
        calculateBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        frame.add(calculateBtn, BorderLayout.SOUTH);

        // Output window
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        // After the button is clicked
        calculateBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String vehicleType = (String) vehicleTypeDropdown.getSelectedItem();
                FuelType fuel = (FuelType) fuelDropdown.getSelectedItem();
                double mileage = Double.parseDouble(mileageField.getText());
                double fuelCons = Double.parseDouble(fuelConsumptionField.getText());
                double engine = Double.parseDouble(engineSizeField.getText());
                SourceType source = (SourceType) homeDropdown.getSelectedItem();
                double energy = Double.parseDouble(homeEnergyField.getText());
                DietType diet = (DietType) dietDropdown.getSelectedItem();

                if (mileage < 0 || fuelCons < 0 || engine < 0 || energy < 0) {
                    throw new IllegalArgumentException("Values cannot be negative");
                }

                Vehicle vehicle = switch (vehicleType) {
                    case "Motorcycle" -> new Motorcycle(fuel, mileage, fuelCons, engine);
                    case "Plane" -> new Plane(fuel, mileage, fuelCons, engine);
                    case "Public Transport" -> new PublicTransport(fuel, mileage, fuelCons, engine);
                    default -> new Car(fuel, mileage, fuelCons, engine);
                };

                Home home = new Home(source, energy);
                Diet userDiet = new Diet(diet);

                User user = new User(name, vehicle, home, userDiet, age);

                String output = user.generateReport() + "\n" + user. getComparison();

                JOptionPane.showMessageDialog(frame, output);


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, " Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private static JLabel formatLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private static JTextField formatInput(JTextField field, Font font) {
        field.setFont(font);
        return field;
    }
}
