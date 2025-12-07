public abstract class EmissionSource implements CarbonEmmitter {
    protected String name;
    protected String category;
    protected double annualEmission;
    protected boolean isCalculated = false;

    public EmissionSource() {
    }

    public EmissionSource(String name, String category, double annualEmission) {
        this.name = name;
        this.category = category;
        this.annualEmission = annualEmission;
    }

    public double CalcCarbonFootPrint() {
        return 0.23;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;

    }

    public double getAnnualEmissions() {
        if (!isCalculated) {
            annualEmission = calculateEmission();
            isCalculated = true;
        }
        return annualEmission;
    }

}





