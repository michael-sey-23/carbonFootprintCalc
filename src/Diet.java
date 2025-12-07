public class Diet extends EmissionSource {
    protected DietType dietType;

    public Diet(DietType dietType){
        super();
        this.name = "Diet";
        this.category = "Food";
        this.dietType = dietType;
    }



    /*
     Calculates annual carbon emissions from diet.
     Average annual emissions by diet type:
     VEGAN: ~1,500 kg CO₂ per year
     NON-VEGAN: ~2,500 kg CO₂ per year

     */
    @Override
    public double calculateEmission() {
        return switch(dietType){
            case VEGAN -> 1500.0;
            case NONVEGAN -> 2500.0;
        };
    }

}