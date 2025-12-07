public class Diet extends EmissionSource {
    protected DietType dietType;
    protected double annualEnergyConsumptionKWh;

    public Diet(DietType dietType, double annualEnergyConsumptionKWh){
        super();
        this.name = "Diet";
        this.category = "";
        this.annualEnergyConsumptionKWh = annualEnergyConsumptionKWh;
        this.dietType = dietType;
    }

    @Override
    public double calculateEmission() {

    }
}
