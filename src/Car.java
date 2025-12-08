public class Car extends Vehicle{
    public Car(FuelType fuelType, double annualMileage, double rateOfFuelConsumption, double engineSize){
        super("Car",fuelType,annualMileage, rateOfFuelConsumption, engineSize);
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

        return fuelUsed * fuelEmissionFactor;
    }
}
