public abstract class Vehicle extends EmissionSource {
    protected FuelType fuelType;
    protected double annualMileage;
    protected double rateOfFuelConsumption;//In l per 100km
    protected double engineSize;

   public Vehicle(){
   }
   public Vehicle(String name, FuelType fuelType, double annualMileage, double rateOfFuelConsumption, double engineSize) {
       this.name = "Vehicle";
       this.category = "Transport";
       this.fuelType = fuelType;
       this.annualMileage = annualMileage;
       this.rateOfFuelConsumption = rateOfFuelConsumption;
       this.engineSize = engineSize;
   }
    /*
     * Each fuel type produces a different amount of CO₂ when burned.
     * These emission factors (kg of CO₂ per liter of fuel) come from
     * standard environmental data used in carbon-footprint calculators.
     * PETROL  → ~2.31 kg CO₂ per liter
     * DIESEL  → ~2.68 kg CO₂ per liter (diesel contains more carbon)
     * HYBRID  → ~1.5 kg CO₂ per liter (uses less fuel due to electric assistance)
     * ELECTRIC → 0 kg CO₂ (no tailpipe emissions for electric vehicles)
     * We use these factors to estimate emissions:
     * carbonEmissions = fuelUsed * emissionFactor
     * This ensures our vehicle model behaves realistically and reflects
     * real-world environmental impact.
     */

    @Override
    public double calculateEmission(){
       double fuelUsed = (annualMileage / 100) * rateOfFuelConsumption;

       double fuelEmissionFactor = switch (fuelType){
           case PETROL -> 2.35;
           case DIESEL -> 2.69;
           case HYBRID -> 1.5;
           case ELECTRIC, NONE -> 0;
       };
       return fuelUsed * fuelEmissionFactor;
   }
}
