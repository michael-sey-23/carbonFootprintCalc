public class Home extends EmissionSource {
    protected SourceType energySource;
    protected double annualEnergyConsumptionKWh;

    public Home(SourceType energySource, double annualEnergyConsumptionKWh) {
        super();
        this.name = "Home";
        this.category = "Housing";
        this.annualEnergyConsumptionKWh = annualEnergyConsumptionKWh;
        this.energySource = energySource;
    }

    @Override
    public double calculateEmission(){
        double factor = switch(energySource){
            case ELECTRICITY -> 0.233;
            case NATURAL_GAS -> 0.185;
            case OIL -> 0.250;
            case COAL -> 0.341;
            case SOLAR -> 0;
        };
        return annualEnergyConsumptionKWh * factor;
    }
}
