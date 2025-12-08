public class Plane extends Vehicle {

    private static final double JET_FUEL_FACTOR = 2.52;  // kg CO₂ per liter of jet fuel
    private static final double ALTITUDE_MULTIPLIER = 2.0;

    public Plane(FuelType fuelType, double annualMileage, double rateOfFuelConsumption, double engineSize) {
        super("Plane", fuelType, annualMileage, rateOfFuelConsumption, engineSize);
    }

    @Override
    public double calculateEmission() {
        double fuelUsed = (annualMileage / 100.0) * rateOfFuelConsumption;

        double emissionFactor = switch (fuelType) {
            case PETROL, DIESEL, NONE -> JET_FUEL_FACTOR; // We assume jet fuel
            case HYBRID -> JET_FUEL_FACTOR * 0.8;
            case ELECTRIC -> 0.5;
        };

        // Apply altitude multiplier for greater climate impact
        return fuelUsed * emissionFactor * ALTITUDE_MULTIPLIER;
    }
}
