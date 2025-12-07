public class User {
    private String name;
    private Vehicle vehicle;
    private Home home;
    private int age;

    public User(String name, Vehicle vehicle, Home home, int age) {
        this.name = name;
        this.vehicle = vehicle;
        this.home = home;
        this.age = age;

    }
    public String getName(){
        return name;

    }
    public int getAge() {
        return age;
    }

    public double getTotalFootPrint() {
        return vehicle.getAnnualEmissions() + home.getAnnualEmissions();

    }

    public String getCategory(){
        double total = getTotalFootPrint();
        if( total < 3000){
            return "Low";
        }
        if( total < 7000){
            return "Moderate";
        }
        return "High";
    }

    public String generateReport(){
        return "User: " + getName() +
                "\nUser's age: " + getAge() +
                "\nUser's Total CarbonFootPrint: "+ getTotalFootPrint() +
                "\nUser's category: " + getCategory();
    }
}
