public class PublicTransport extends Vehicle {

    private static final double AVERAGE_PASSENGERS = 40.0;

    public PublicTransport(FuelType fuelType, double annualMileage, double rateOfFuelConsumption, double engineSize) {
        super("Public Transport", fuelType, annualMileage, rateOfFuelConsumption, engineSize);
    }

    @Override
    public double calculateEmission() {
        double fuelUsed = (annualMileage / 100.0) * rateOfFuelConsumption;

        double fuelEmissionFactor = switch (fuelType) {
            case PETROL -> 2.35;
            case DIESEL -> 2.69;
            case HYBRID -> 1.5;
            case ELECTRIC, NONE -> 0;
        };

        // Divide by average passengers to get per-person emissions
        double totalVehicleEmissions = fuelUsed * fuelEmissionFactor;
        return totalVehicleEmissions / AVERAGE_PASSENGERS;
    }
}