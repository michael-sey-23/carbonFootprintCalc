public class Diet extends EmissionSource {
    protected DietType dietType;
    protected double annualEnergyConsumptionKWh;

    public Diet(DietType dietType, double annualEnergyConsumptionKWh){
        super();
        this.name = "Diet";
        this.category = "Food";
        this.annualEnergyConsumptionKWh = annualEnergyConsumptionKWh;
        this.dietType = dietType;
    }

    /**
     * Calculates annual carbon emissions from diet.

     * Average annual emissions by diet type:
     * VEGAN: ~1,500 kg CO₂ per year
     * NON-VEGAN: ~2,500 kg CO₂ per year

     * These values represent typical carbon footprints from food production,
     * including agriculture, livestock, processing, and transportation.

     * The annualEnergyConsumptionKWh can represent cooking/refrigeration energy,
     * with a conversion factor of 0.233 kg CO₂ per kWh (electricity).
     */
    @Override
    public double calculateEmission() {
        double dietEmission = switch(dietType){
            case VEGAN -> 1500.0;
            case NONVEGAN -> 2500.0;
        };

        // Add emissions from cooking/refrigeration energy
        double energyEmission = annualEnergyConsumptionKWh * 0.233;

        return dietEmission + energyEmission;
    }
}