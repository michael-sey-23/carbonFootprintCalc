public class User {
    protected String name;
    protected Vehicle vehicle;
    protected Home home;
    protected Diet diet;
    protected int age;

    public User(String name, Vehicle vehicle, Home home, Diet diet, int age) {
        this.name = name;
        this.vehicle = vehicle;
        this.home = home;
        this.diet = diet;
        this.age = age;

    }
    public String getName(){
        return name;

    }
    public int getAge() {
        return age;
    }

    public double getTotalFootPrint() {
        return vehicle.getAnnualEmissions() + home.getAnnualEmissions() + diet.getAnnualEmissions();

    }

    public String getCategory(){
        double total = getTotalFootPrint();
        if( total < 5000){
            return "Low";
        }
        if( total < 10000){
            return "Moderate";
        }
        return "High";
    }

    public String generateReport(){
        return "User: " + getName() +
                "\nTotal Carbon Footprint: "+ getTotalFootPrint() + " kg CO₂" +
                "\nCarbon Emission Level: " + getCategory();
    }

    public String getComparison() {
        double worldAverage = 4000; // kg CO₂ per person per year
        double percentDiff = ((getTotalFootPrint() - worldAverage) / worldAverage) * 100;
        return String.format("%.1f%% %s than world average",
                Math.abs(percentDiff),
                percentDiff > 0 ? "higher" : "lower");
    }
}
